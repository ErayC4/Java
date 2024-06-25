package pü6;

public class Paket {
    private String empfaenger;
    private String adresse;

    public Paket(String empfaenger, String adresse) {
        this.empfaenger = empfaenger;
        this.adresse = adresse;
    }

    public String getAnschrift() {
        return adresse;
    }

    public String getEmpfaenger() {
        return empfaenger;
    }

    @Override
    public String toString() {
        return "EmpfÃ¤nger: " + empfaenger + ", Adresse: " + adresse;
    }
}
