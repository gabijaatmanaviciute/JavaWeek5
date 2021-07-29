package listai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aleksandras Novikovas <Aleksandras.Novikovas@gmail.com>
 */
public class Listai {

    public static void printElements(List l) {
        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i));
            l.get(i);
        }
    }

    public static void generateLargeList(List l) {
        for (int i = 0; i < 200000; i++) {
            l.add(i);
        }
    }

    public static void removeElements(List l) {
        while (!l.isEmpty()) {
            l.remove(0);
        }
    }

    public static void fill(List l, int count) {
        for (int i = 0; i < count; i++) {
            l.add(Math.random());
            // Kadangi Math.random metodas generuoja primityvaus tipo double skaiciu,
            // o add metodas reikalauja objekto, Java ta skaiciu "box'ina"
            //      0.5 (double)
            //     new Double (0.5)
        }
    }

    public static double avg(List l) {
        double sum = 0;
        for (int i = 0; i < l.size(); i++) {
            sum += (Double) l.get(i);
        }
        return sum / l.size();
    }

    public static double min(List l) {
        double m = Double.MAX_VALUE;
        for (int i = 0; i < l.size(); i++) {
            if (m > (Double) l.get(i)) {
                m = (Double) l.get(i);
                //           0.5 (Double)
                //           .doubleValue() = > 0.5 (double)
            }
        }
        return m;
    }

    public static double max(List l) {
        double m = Double.MIN_VALUE;
        for (int i = 0; i < l.size(); i++) {
            if (m < (Double) l.get(i)) {
                m = (Double) l.get(i);
            }
        }
        return m;
    }

    public static void printList(List l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + 1 + ". " + l.get(i));
        }
        System.out.println("---------");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Zmogus> l = new ArrayList();
        
        l.add(new Zmogus("Jonas", "Jonaitis"));
        l.add(null);
        l.add(new Zmogus("Petras", "Petraitis"));
        l.add(new Zmogus("Petras", null));
        l.add(new Zmogus(null, "Petraitis"));
        l.add(new Zmogus("Antanas", "Antanaitis"));
        l.add(new Zmogus("Jonas", "Petraitis"));
        l.add(new Zmogus("Jonas", null));
        l.add(new Zmogus("Jonas", null));
        l.add(new Zmogus("Jonas", "Antanaitis"));
        l.add(null);
        l.add(new Zmogus("Antanas", "Petraitis"));
        l.add(new Zmogus("Petras", "Jonaitis"));
        l.add(new Zmogus(null, "Jonaitis"));
        
        printList(l);
 
        class PagalVardaDidejimas implements Comparator<Zmogus> {

            @Override
            public int compare(Zmogus o1, Zmogus o2) {
//                System.out.println(o1 + " lyginam su " + o2);
                if (o1 == null) {
                    if (o2 == null) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    if (o2 == null) {
                        return -1;
                    } else {
                        if (o1.getVardas() == null) {
                            if (o2.getVardas() == null) {
                                return 0;
                            } else {
                                return 1;
                            }
                        } else {
                            if (o2.getVardas() == null) {
                                return -1;
                            } else {
                                return o1.getVardas().compareTo(o2.getVardas());
                            }
                        }
                    }
                }
            }
        }
        
        l.sort(new PagalVardaDidejimas());
        
        printList(l);
 
        class PagalVardaPavardeDidejimas implements Comparator<Zmogus> {

            @Override
            public int compare(Zmogus o1, Zmogus o2) {
//                System.out.println(o1 + " lyginam su " + o2);
                if (o1 == null) {
                    if (o2 == null) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    if (o2 == null) {
                        return -1;
                    } else {
                        if (o1.getVardas() == null) {
                            if (o2.getVardas() == null) {
                                return 0;
                            } else {
                                return 1;
                            }
                        } else {
                            if (o2.getVardas() == null) {
                                return -1;
                            } else {
                                int vardaiLygus = o1.getVardas().compareTo(o2.getVardas());
                                if (vardaiLygus == 0) {
                                    if (o1.getPavarde()== null) {
                                        if (o2.getPavarde()== null) {
                                            return 0;
                                        } else {
                                            return 1;
                                        }
                                    } else {
                                        if (o2.getPavarde()== null) {
                                            return -1;
                                        } else {
                                            return o1.getPavarde().compareTo(o2.getPavarde());
                                        }
                                    }
                                } else {
                                    return vardaiLygus;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        l.sort(new PagalVardaPavardeDidejimas());
        
        printList(l);
        
        l.sort(new Comparator<Zmogus>() {
            @Override
            public int compare(Zmogus o1, Zmogus o2) {
//                System.out.println(o1 + " lyginam su " + o2);
                if (o1 == null) {
                    if (o2 == null) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    if (o2 == null) {
                        return 1;
                    } else {
                        if (o1.getPavarde()== null) {
                            if (o2.getPavarde()== null) {
                                return 0;
                            } else {
                                return -1;
                            }
                        } else {
                            if (o2.getPavarde()== null) {
                                return 1;
                            } else {
                                return o2.getPavarde().compareTo(o1.getPavarde());
                            }
                        }
                    }
                }
            }
        });
        
        printList(l);
        
        l.sort(new Comparator<Zmogus>() {
            @Override
            public int compare(Zmogus o1, Zmogus o2) {
//                System.out.println(o1 + " lyginam su " + o2);
                if (o1 == null) {
                    if (o2 == null) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    if (o2 == null) {
                        return 1;
                    } else {
                        if (o1.getPavarde()== null) {
                            if (o2.getPavarde()== null) {
                                return 0;
                            } else {
                                return -1;
                            }
                        } else {
                            if (o2.getPavarde()== null) {
                                return 1;
                            } else {
                                int pavardesLygios = o2.getPavarde().compareTo(o1.getPavarde());
                                if (pavardesLygios == 0) {
                                    if (o1.getVardas() == null) {
                                        if (o2.getVardas() == null) {
                                            return 0;
                                        } else {
                                            return -1;
                                        }
                                    } else {
                                        if (o2.getVardas() == null) {
                                            return 1;
                                        } else {
                                            return o2.getVardas().compareTo(o1.getVardas());
                                        }
                                    }
                                } else {
                                    return pavardesLygios;
                                }
                            }
                        }
                    }
                }
            }
        });
        
        printList(l);
        
        l.sort(new Comparator<Zmogus>() {
            @Override
            public int compare(Zmogus o1, Zmogus o2) {
//                System.out.println(o1 + " lyginam su " + o2);
                if (o1 == null) {
                    if (o2 == null) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    if (o2 == null) {
                        return -1;
                    }
                    int z1 = (o1.getVardas() == null) ? 0 : o1.getVardas().length();
                    z1 += (o1.getPavarde()== null) ? 0 : o1.getPavarde().length();
                    int z2 = (o2.getVardas() == null) ? 0 : o2.getVardas().length();
                    z2 += (o2.getPavarde()== null) ? 0 : o2.getPavarde().length();
                    return z1 - z2;
                }
            }
        });
        
        printList(l);
        
//        l.add("Labas");
//        l.add("Pasauli");
////        l.add("kaip");
////        l.add("tau");
////        l.add("sekasi");
//        l.add("?");
//        System.out.println(l);
//        
//        class Lygintojas<E extends Comparable> implements Comparator<E> {
//
//            @Override
//            public int compare(E o1, E o2) {
//                System.out.println(o1.compareTo(o2));
//                return o1.compareTo(o2);
//            }
//            
//        }
//        
//        Comparator<String> c = new Lygintojas();
//        
//        Comparator<String> c1 = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                System.out.println(o1.compareTo(o2));
//                return o1.compareTo(o2);
//            }
//        };
//        
//        
//        l.sort(c);
//        
////        for (int i = 0; i < l.size() - 1; i++) {
////            for (int j = i + 1; j < l.size(); j++) {
////                String s1 = (String) l.get(i);
////                String s2 = (String) l.get(j);
////                if (c.compare(s1, s2) > 0) { // s1 > s2
//////                if (s1.compareTo(s2) > 0) { // s1 > s2
////                    l.set(i, s2);
////                    l.set(j, s1);
////                }
////            }
////        }
//        
//        System.out.println(l);
        
//        Object o = null;
//        
//        {
//            class Skaicius {
//
//                int i;
//
//                public Skaicius(int i) {
//                    this.i = i;
//                }
//
//                public void inc() {
//                    this.i++;
//                }
//
//                public void dec() {
//                    this.i--;
//                }
//
//                @Override
//                public String toString() {
//                    return "Skaicius{" + "i=" + i + '}';
//                }
//
//            }
//            Skaicius ss = new Skaicius(5);
//            ss.inc();
//            ss.inc();
//            ss.inc();
//            System.out.println(ss);
//            o = ss;
//        }
////        Skaicius kitas = new Skaicius(15);
//        System.out.println("==== uz scope ribu ===");
//        
//        System.out.println(o);

//        Zmogus z1 = new Zmogus("Jonas", "Jonaitis");
//        Zmogus z2 = new Zmogus("Jonas", "Jonaitis");
//        
//        if (z1.equals(z2)) {
//            System.out.println("toks pats");
//        } else {
//            System.out.println("kitas");
//        }
//        String s1 = "abc";
//        
//        String s2 = "abf";
//        
//        System.out.println(s1);
//        System.out.println(s2);
//        
//        if (s1.compareToIgnoreCase(s2) > 0) {
//            System.out.println("didesnis s1");
//            System.out.println(s2);
//            System.out.println(s1);
//        } else {
//            System.out.println("didesnis s2");
//            System.out.println(s1);
//            System.out.println(s2);
//        }
//        List l = new ArrayList();
////        fill(l, 10);
//        System.out.println(l);
////        System.out.println(avg(l));
//        System.out.println(min(l));
////        System.out.println(max(l));
//        System.out.println(new Date());
//        List l = new ArrayList();
//        generateLargeList(l);
//        System.out.println(new Date());
//        printElements(l);
//        System.out.println(new Date());
//        removeElements(l);
//        System.out.println(new Date());
//        int s1 = 15;
//        int s2 = 16;
//        int s3 = s1 + s2;
//        System.out.println(s3);
//                
//
//
//        Integer sk1 = 15;
//        // sk1 = new Integer(15)
//        
//        Integer sk2 = 16;
//        // sk2 = new Integer(16)
//        
//        sk2 = null;
//
//        Integer sk3 = sk1 + sk2;
//        //            sk1.intValue() =>15
//        //                  sk2.intValue() =>16
//        //             15 + 16
//        //                31
//        //      sk3 = new Integer(31)
//        
//        System.out.println(sk3);
    }

}
/*
byte        Byte
short       Short
int         Integer
long        Long
float       Float
double      Double
char        Character
boolean     Boolean
 */

/*
sukurti metoda, kuris uzpildys duota lista nurodytu kiekiu elementu Math.random()

void fill(List l, int count);

sukurti metoda, kuris paskaiciuotu liste esanciu elementu vidurki
double avg(List l);

sukurti metoda, kuris surastu didziausia elementa
double max(List l);

sukurti metoda, kuris surastu maziausia elementa
double min(List l);
*/


/*
sukurti klase Zmogus (vardas, pavarde)

i List'a (kuris turi generic'a Zmogus) sudeti:

Jonas Jonaitis
Petras Petraitis
Antanas Antanaitis
Jonas Petraitis
Jonas Antanaitis
Antanas Petraitis
Petras Jonaitis

sukurti Comparator klase (su generic), kuri rusiuotu zmones

1. tik pagal varda (didejimo tvarka)
2. tik pagal pavarde (mazejimo tvarka)
3. pagal varda pavarde (didejimo tvarka)
4. pagal pavarde varda (mazejimo tvarka)
5. pagal vardo ir pavardes (kartu) ilgi (didejimo tvarka)


2, 4 ir 5 padaryti su anoniminem klasem

surusiuoti List'a su kiekvienu is Comparator'iu
ir atspausdinti po kiekvieno rusiavimo

*/
