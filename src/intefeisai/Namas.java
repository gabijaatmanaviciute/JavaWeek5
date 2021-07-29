package intefeisai;

/**
 *
 * @author Aleksandras Novikovas <Aleksandras.Novikovas@gmail.com>
 */
public class Namas extends NamoDalis {
    
    public void atidaromLanga() {
        System.out.println("atidarem langus");
    }
    
    public void gesinkGaisra() {
        System.out.println("Viskas OK");
    }

//    public void trumpasSujungimas() {
//        System.out.println("Gesink, nes tuoj sudegs");
//    }
//
    public void ijunk() {
        System.out.println("Name ijungiam sviesa");
    }
    
    public void isjunk() {
        System.out.println("Name isjungem sviesa");
    }

    @Override
    public void atsuk() {
        System.out.println("Name paleidom vandeni");
    }

    @Override
    public void uzsuk() {
        System.out.println("Name uzsukom vandeni");
    }

    @Override
    public void nuleisk() {
        super.nuleisk();
        System.out.println("Tualetas pagaliau laisvas");
    }

    @Override
    public void pusk(int stiprumas) {
        System.out.println("Name ijungem ventiliatoriu su stiprumu " + stiprumas);
    }

}
