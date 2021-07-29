package intefeisai;

public abstract class NamoDalis implements ElVand, Ventiliacija {
    
    public void trumpasSujungimas() {
        System.out.println("Viskas nafig sudege");
    }

    @Override
    public void nuleisk() {
        System.out.println("Namo dalyje aprasytas tuoleto naudojimas");
    }
    
    public abstract void gesinkGaisra();
    
}
