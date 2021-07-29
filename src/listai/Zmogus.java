package listai;

import java.util.Objects;

/**
 *
 * @author Aleksandras Novikovas <Aleksandras.Novikovas@gmail.com>
 */
public class Zmogus {
    
    private String vardas;
    private String pavarde;

    public Zmogus(String vardas, String pavarde) {
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zmogus other = (Zmogus) obj;
        if (!Objects.equals(this.vardas, other.vardas)) {
            return false;
        }
        if (!Objects.equals(this.pavarde, other.pavarde)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zmogus{" + "vardas=" + vardas + ", pavarde=" + pavarde + '}';
    }


}
