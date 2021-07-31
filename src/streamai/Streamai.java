package streamai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Streamai {

    public static void main(String[] args) {
        try (
            InputStream is = new FileInputStream("a.txt");
            Reader r = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(r);
            OutputStream os = new FileOutputStream("out.txt");
            Writer w = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(w);
        ) {
            String s;
            int i = 1;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
                bw.write(i++ + ". eilute: ");
                bw.write(s);
                bw.write("\r\n");
            }
        } catch (Exception ex) {
            System.out.println("Failed to read file a.txt");
        }
    }

    public static void countByteUsage(String fileName, Map<Integer, Integer> stats) {
        try (InputStream is = new FileInputStream(fileName);) {
            int b;
            while ((b = is.read()) != -1) {
                Integer counter = stats.get(b);
                if (counter == null) {
                    counter = 0;
                }
                counter++;
                stats.put(b, counter);
            }
        } catch (Exception ex) {
            System.out.println("Failed to read file " + fileName);
        }
    }

    public static void main1(String[] args) {
        Map<Integer, Integer> stats = new HashMap();
        countByteUsage("a.txt", stats);
        countByteUsage("b.txt", stats);
        countByteUsage("c.txt", stats);
        System.out.println(stats);
        Integer maxUsedByte = 0;
        Integer maxUsedByteCount = 0;
        for (Integer b : stats.keySet()) {
            if (stats.get(b) > maxUsedByteCount) {
                maxUsedByte = b;
                maxUsedByteCount = stats.get(b);
            }
        }
        System.out.println("Max used byte: " + maxUsedByte + " used " + maxUsedByteCount + " times.");
        List<Integer> bytesUsed = new ArrayList(stats.keySet());
        bytesUsed.sort((b1, b2) -> {
            return stats.get(b2) - stats.get(b1);
        });
        try (OutputStream os = new FileOutputStream("out.txt")) {
            for (Integer b : bytesUsed) {
                os.write(b);
            }
        } catch (Exception ex) {
            System.out.println("Failed to write to file out.txt");
        }
//        try (
//            InputStream is = new FileInputStream("a.txt");
//            InputStream is1 = new FileInputStream("b.txt");
//            OutputStream os = new FileOutputStream("out.txt");
//        ) {
//            int b;
//            while ((b = is.read()) != -1) {
//                System.out.println(b);
//                os.write(b);
//            }
//            while ((b = is1.read()) != -1) {
//                System.out.println(b);
//                os.write(b);
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("OOps");
//        }
//        finally {
//            System.out.println("vis tiek suveiks");
//        }

//        InputStream is = null;
//        InputStream is1 = null;
//        try {
//            is = new FileInputStream("a.txt");
//            is1 = new FileInputStream("b.txt");
//            int b;
//            while ((b = is.read()) != -1) {
//                System.out.println(b);
//            }
//            while ((b = is1.read()) != -1) {
//                System.out.println(b);
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("OOps");
//        }
//        finally {
//            if (is1 != null) {
//                try {
//                    is1.close();
//                } catch (IOException ex) {
//                    // ignored
//                }
//            }
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException ex) {
//                    // ignored
//                }
//            }
//        }
        System.out.println("tesiam programa toliau");

    }

}

/*
perskaityti baitus is failu a.txt, b.txt ir c.txt

suskaiciuoti kiek kiekvienas baitas kartu buvo panaudotas

atspausdinti baitu panaudojimu statistika

atspausdinti dazniausiai panaudota baita ir kiek kartu jis buvo panaudotas

*** i failai out.txt surasyti visus baitus panaudojimo mazejimo tvarka

 */
