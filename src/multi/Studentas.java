package multi;

public class Studentas extends Zmogus implements Runnable {

    private String kursas;

    public Studentas(String vardas, String pavarde, String kursas) {
        super(vardas, pavarde);
        this.kursas = kursas;
    }

    public String getKursas() {
        return kursas;
    }

    public void setKursas(String kursas) {
        this.kursas = kursas;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Studentas: " + this.getVardas() + " " + i + " " + Thread.currentThread().getName());
        }
    }
    
}
