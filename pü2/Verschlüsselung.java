package pü2;
import java.util.Scanner;

public class Verschlüsselung {

    public static void main(String[] args) {
        // Scanner-Objekt für die Eingabe initialisieren
        Scanner scanner = new Scanner(System.in);

        // Benutzer zur Eingabe eines Wortes oder Satzes auffordern
        System.out.print("Geben Sie ein Wort oder einen Satz ein: ");
        String satz = scanner.nextLine();
        
        // Erstellen Sie ein Array zur Speicherung der Buchstaben des Satzes
        char[] buchstaben = new char[satz.length()];
        
        // Schleife durchläuft jeden Buchstaben des Satzes
        for (int i = 0; i < satz.length(); i++) {
            // Buchstabe an der aktuellen Position im Array speichern
            buchstaben[i] = satz.charAt(i);
            // ASCII-Wert des aktuellen Buchstabens erhalten
            int asciiValue = Character.codePointAt(buchstaben, i);
            
            // Überprüft, ob der ASCII-Wert im Bereich der Buchstaben liegt oder ein Leerzeichen ist
            if(asciiValue >= 64 && asciiValue <= 90 || asciiValue >= 97 && asciiValue <= 122 || asciiValue == 32) {
                // Buchstaben um 1 erhöhen, um sie zu verschlüsseln
            	
                char letter = Character.valueOf((char) (asciiValue + 1));
                
                //Wenn der Buchstabe 'Z' ist, wird er zu 'A'
                if(asciiValue == 90) {
                    letter = 'A';
                }
                //Wenn der Buchstabe 'z' ist, wird er zu 'a' 
                if(asciiValue == 122) {
                    letter = 'a';
                }
                //Wenn der Buchstabe ein Leerzeichen ist
                if(asciiValue == 32) {
                    letter = ' ';
                }
                System.out.print(letter);

            } else {
                // Fehlermeldung, wenn ein ungültiges Zeichen eingegeben wird
                System.out.println("Bitte geben Sie nur Buchstaben aus dem Alphabet ein.");
            }
        }
        scanner.close();
    }

}
