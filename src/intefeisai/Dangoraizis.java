package intefeisai;

public class Dangoraizis extends Namas implements Liftas {
    
    private int aukstas = 1;

    @Override
    public void vaziuojam(int aukstas) {
        if (this.aukstas != aukstas) {
            System.out.println("Vaziuojam is " + this.aukstas + " i " + aukstas);
            this.aukstas = aukstas;
        }
    }

    @Override
    public int kurYra() {
        return this.aukstas;
    }
    
}
