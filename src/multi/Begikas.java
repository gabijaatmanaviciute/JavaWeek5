package multi;

public class Begikas extends Thread {
    private String vardas;

    public Begikas(String vardas) {
        this.vardas = vardas;
    }
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getVardas() + " " + i);
        }
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }
    
    
}
