package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static final int PORT = 8080;
    public static final String WEB_DIR = "web";
    
    public static void sendError(BufferedWriter bw, int errorCode, String errorMessage) throws IOException {
        bw.write("HTTP/1.1 " + errorCode + " " + errorMessage + "\r\n");
        bw.write("\r\n");
    }

    public static void main(String[] args) {
        ServerSocket sc = null;
        try {
            sc = new ServerSocket(PORT);
            boolean finished = false;
            while (!finished) {
                try (
                    Socket socket = sc.accept();
                    InputStream is = socket.getInputStream();
                    Reader r = new InputStreamReader(is, "UTF-8");
                    BufferedReader br = new BufferedReader(r);
                    OutputStream os = socket.getOutputStream();
                    Writer w = new OutputStreamWriter(os, "UTF-8");
                    BufferedWriter bw = new BufferedWriter(w);
                ) {
//                    String s;
//                    while ((s = br.readLine()) != null && !s.isEmpty()) {
//                        System.out.println(s);
//                    }
                    String s = br.readLine();
                    if (s != null && !s.isEmpty()) {
                        String[] parts = s.split(" ");
                        if (parts.length == 3) {
                            String path = parts[1];
                            if (path.equalsIgnoreCase("/end")) {
                                bw.write("HTTP/1.1 200 OK\r\n");
                                bw.write("\r\n");
                                bw.write("<html>\r\n");
                                bw.write("<body>\r\n");
                                bw.write("<h1>Bye. Server is down.</h1>\r\n");
                                bw.write("</body>\r\n");
                                bw.write("</html>\r\n");
                                bw.write("\r\n");
                                finished = true;
                            } else {
                                System.out.println(path);
//                                if (path.startsWith("/")) {
//                                    path = path.substring(1);
//                                }
                                File f = new File(WEB_DIR, path);
                                if (f.exists()) {
                                    if (f.isDirectory()) {
                                        String webDir = new File(WEB_DIR).getCanonicalPath();
                                        bw.write("HTTP/1.1 200 OK\r\n");
                                        bw.write("\r\n");
                                        bw.write("<html>\r\n");
                                        bw.write("<body>\r\n");
                                        if (!webDir.equals(f.getCanonicalPath()) &&
                                            !webDir.equals(f.getCanonicalPath() + File.pathSeparator)
                                        ) {
                                            bw.write("<p><a href=\"../\">..</a></p>");
                                        }
                                        File[] files = f.listFiles();
                                        for (File file : files) {
                                            String href = file.getCanonicalPath();
                                            href = href.substring(webDir.length());
                                            bw.write("<p><a href=\"" + href + "\">" + file.getName() + "</a></p>");
                                            bw.write("\r\n");
                                        }
                                        bw.write("</body>\r\n");
                                        bw.write("</html>\r\n");
                                        bw.write("\r\n");
                                    } else {
                                        bw.write("HTTP/1.1 200 OK\r\n");
                                        bw.write("\r\n");
                                        try (
                                            InputStream fis = new FileInputStream(f);
                                            Reader fr = new InputStreamReader(fis, "UTF-8");
                                            BufferedReader fbr = new BufferedReader(fr);
                                        ) {
                                            String line;
                                            while ((line = fbr.readLine()) != null) {
                                                bw.write(line);
                                                bw.write("\r\n");
                                            }
                                        }
                                        catch (Exception ex) {
                                            sendError(bw, 500, "Internal Server Error");
                                        }
                                        bw.write("\r\n");
                                    }
                                } else {
                                    sendError(bw, 404, "Not Found");
                                }
                            }
                        } else {
                            sendError(bw, 400, "Bad Request");
                        }
                    } else {
                        sendError(bw, 400, "Bad Request");
                    }
                }
                catch (Exception ex) {
                    System.err.println("Error while reading request:" + ex.getMessage());
                }
            }
        }
        catch (IOException ex) {
            System.err.println("Failed to open port " + PORT);
        }
        finally {
            if (sc != null) {
                try {
                    sc.close();
                } catch (Exception ex) {
                    // ignored
                }
            }
        }
    }
    
}
