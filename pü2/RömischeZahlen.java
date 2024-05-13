package pü2;
import java.util.Scanner;

public class RömischeZahlen {

    public static void main(String[] args) {
        // Scanner-Objekt für die Eingabe initialisieren
        Scanner scanner = new Scanner(System.in);
        
        // Benutzer zur Eingabe einer Ganzzahl auffordern
        System.out.print("Bitte geben Sie eine Ganzzahl ein (bis zu 3999): ");
        int nummer = scanner.nextInt();
        int anfangsZahl = nummer;
        
        // Überprüfen, ob die eingegebene Zahl gültig ist
        if (nummer < 1 || nummer > 3999) {
            System.out.println("Die eingegebene Zahl ist zu groß");
        } else {
            // StringBuilder für die Konvertierung in römische Zahlen initialisieren
            StringBuilder roman = new StringBuilder();
            // Arrays für arabische und römische Ziffern definieren
            int[] zahlen = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] römischeZeichen = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            int i = 0;
            // Konvertierung der Zahl in römische Zahlen
            while (nummer > 0) {
                while (nummer >= zahlen[i]) {
                    roman.append(römischeZeichen[i]);
                    nummer -= zahlen[i];
                }
                i++;
            }
            // Ausgabe der ursprünglichen Zahl und der römischen Darstellung
            System.out.println(anfangsZahl + " ist: " + roman);
        }
        // Scanner schließen, um Ressourcen freizugeben
        scanner.close();
    }

}
