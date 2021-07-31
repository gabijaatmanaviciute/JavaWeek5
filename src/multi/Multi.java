package multi;

import java.util.Date;

public class Multi {

    public static void main(String[] args) {
        
        Date data = new Date(); // 1970-01-01 00:00:00.000
        
        System.out.println(data);
        System.out.println(data.getTime());
        
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            //ignored
        }

        Date data1 = new Date(); // 1970-01-01 00:00:00.000
        System.out.println(data1);
        System.out.println(data1.getTime());

        int i = 101;   //32
        long l = 101;  //64
        
        float f = 15.3f;  //32
        double d = 15.3;  //64

        Object o = new Object();

        class Bf {

            int a = 0;
            int b = 0;
        }
        Bf b = new Bf();

        /*
        b: -> a: 1
              b: 0
        
        t1: 0 ++ atgal 1
            -1 ++ atgal 0
        
        t2: 0 -- atgal -1 //
            0 -- atgal -1 xxxxx
         */
        Thread t1 = new Thread(() -> {
            while (b.a < 10) {
                try {
                    Thread.sleep(1);
                } catch (Exception ex) {
                    //ignored
                }
                synchronized (b) {
                    synchronized (o) {
                        b.a++;
                        b.b++;
                        System.out.println("didejimas a: " + b.a + ", b: " + b.b);
                        if (b.a != b.b) {
                            System.out.println("didejimas nelygu");
                            break;
                        }
                    }
                }
            }
            System.out.println("pabaige didejimas");
        });

        Thread t2 = new Thread(() -> {
            while (b.a > -10) {
                try {
                    Thread.sleep(1);
                } catch (Exception ex) {
                    //ignored
                }
                synchronized (b) {
                    synchronized (o) {
                        b.a--;
                        b.b--;
                        b.a--;
                        b.b--;
                        System.out.println("mazejimas a: " + b.a + ", b: " + b.b);
                        if (b.a != b.b) {
                            System.out.println("mazejimas nelygu");
                            break;
                        }
                    }
                }
            }
            System.out.println("pabaige mazejimas");
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (Exception ex) {
                //ignored
            }
            while (b.a > -20) {
                b.a--;
                b.b--;
                try {
                    Thread.sleep(1);
                } catch (Exception ex) {
                    //ignored
                }
                System.out.println("pikciurna a: " + b.a + ", b: " + b.b);
                if (b.a != b.b) {
                    System.out.println("pikciurna nelygu");
                    break;
                }
            }
            System.out.println("pabaige pikciurna");
        });

//        t1.start();
//        t2.start();
//        t3.start();
    }

    public static void main1(String[] args) {
        Begikas b1 = new Begikas("Jonas");
        Begikas b2 = new Begikas("Petras");
        Studentas s1 = new Studentas("Antanas", "Antanaitis", "programavimas");
        Thread t1 = new Thread(s1);
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Nezinomas abstract: " + i + " " + Thread.currentThread().getName());
                }
            }
        };
        Thread t2 = new Thread(r2);
        Runnable r3 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Nezinomas lamda atskiras: " + i + " " + Thread.currentThread().getName());
            }
        };
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Nezinomas lamda parametras: " + i + " " + Thread.currentThread().getName());
            }
        });
        System.out.println("pradedam begti");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        b1.start();
        b2.start();
        System.out.println("pabaiga");
    }

}

/*
Sraigiu lenktynes
yra 8 sraiges

visos sraiges sliauzia 1000 cm

kiekviena sraige:
pasliauzia random nuo 1-3 cm ir
pamiega random nuo 1-5 ms

pabaigoj atspausdinti turnyrine lentele,
surusiuota pagal distancijos iveikimo greiti

*/