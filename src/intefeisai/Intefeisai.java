package intefeisai;

/**
 *
 * @author Aleksandras Novikovas <Aleksandras.Novikovas@gmail.com>
 */
public class Intefeisai {

    public static void pamirksek(Elektra e) {
        e.ijunk();
        e.isjunk();
        e.ijunk();
        e.isjunk();
        e.ijunk();
        e.isjunk();
    }

    public static void kasTu(Object o) {
        System.out.println("Palapine:" + (o instanceof Palapine));
        System.out.println("SodoNamas:" + (o instanceof SodoNamas));
        System.out.println("Namas:" + (o instanceof Namas));
        System.out.println("Dangoraizis:" + (o instanceof Dangoraizis));
        System.out.println("Elektra:" + (o instanceof Elektra));
        System.out.println("Vanduo:" + (o instanceof Vanduo));
        System.out.println("ElVand:" + (o instanceof ElVand));
        System.out.println("Ventiliacija:" + (o instanceof Ventiliacija));
        System.out.println("Liftas:" + (o instanceof Liftas));
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Namas n = new Namas();
        Palapine p = new Palapine();
        SodoNamas sn = new SodoNamas();

        Virdulys v = new Virdulys();

//        pamirksek(n);
//        System.out.println("----");
//        pamirksek(p);
//        System.out.println("----");
//        pamirksek(sn);
//        System.out.println("----");
//        pamirksek(v);
//        
        Dangoraizis d = new Dangoraizis();
//        System.out.println(d.kurYra());
//        d.vaziuojam(5);
//        System.out.println(d.kurYra());
//        System.out.println("==========");
//        pamirksek(d);

//        System.out.println("--- Virdulys");
//        kasTu(v);
//        System.out.println("--- Palapine");
//        kasTu(p);
//        System.out.println("--- SodoNamas");
//        kasTu(sn);
//        System.out.println("--- Namas");
//        kasTu(n);
//        System.out.println("--- Dangoraizis");
//        kasTu(d);
//        
//        Ventiliacija vvv = d;
//        vvv.pusk(10);
//        Elektra e = (Elektra) vvv;
//        e.ijunk();
//        if (e instanceof Liftas) {
//            Liftas l = (Liftas) e;
//            l.vaziuojam(3);
//        }
        n.nuleisk();
        
        NamoDalis nd = new Namas();
        NamoDalis nd1 = new Dangoraizis();
        
        // Taip negalima, nes negalima tiesiogiai sukurti abstrakcios klases atstovo
//        NamoDalis nd = new NamoDalis();

        // Taip negalima, nes negalima tiesiogiai sukurti interfeiso atstovo
//        Elektra el = new Elektra();
    }

}
