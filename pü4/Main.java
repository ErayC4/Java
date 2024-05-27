package pü4;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//import static Crypto.*;

// Hauptklasse, die die Benutzeroberfläche für das Programm zur Verfügung stellt
public class Main {
    private static Scanner scanner = new Scanner(System.in); // Erzeugt ein Scanner-Objekt für Eingaben über die Konsole

    public static void main(String[] args) throws IOException {
        // Deklaration der Variablen für den verschlüsselten Text
        String  encryptedText;
        int shift;

        // Endlosschleife, um dem Benutzer wiederholt Optionen anzubieten
        while (true) {  // Benutzeroberfläche mit den verfügbaren Optionen
            System.out.println("Choose an operation:");
            System.out.println("2. Read a note");
            System.out.println("1. Write a note");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int selection = scanner.nextInt(); // Liest die Benutzerauswahl ein
            scanner.nextLine(); // Entfernt den übriggebliebenen Zeilenumbruch nach der Zahleingabe
            System.out.println();

            switch (selection) {
            case 2:
	            
				try {
					System.out.println("Gebe einen Datei Namen ein: ");
					String filename = scanner.next();
					String content = FileHandler.readFromFile(filename);
					FileHandler.readFromFile(filename);
		            System.out.println("Inhalt der Datei: " + content);
		            scanner.close();
		            
		        } catch (FileNotFoundException e) {
		            // Fehler abfangen und Fehlermeldung ausgeben
		            System.err.println("Datei nicht gefunden!");
		        }
		        
				
            	break;
            case 1: // Option 1: Schreiben einer Notiz
                // Eingabeaufforderung und -lesen für die Verschlüsselung
                System.out.print("Enter text to encrypt: ");
                String text = scanner.nextLine();
                System.out.print("Enter shift value: ");
                shift = scanner.nextInt();

                scanner.nextLine(); // Entfernt den übriggebliebenen Zeilenumbruch nach der Zahleneingabe

                encryptedText = Crypto.caesarEncrypt(text, shift); // Verschlüsselt den eingegebenen Text

                // Anpassung des Shift-Wertes, falls nötig, und Vorbereitung des verschlüsselten Texts für die Dateiausgabe
                String encryptedTextWithShiftPrefix = Crypto.normalizeShiftValueAndSetShiftAsPrefix(shift, encryptedText);

                System.out.println("Encrypted text: " + encryptedTextWithShiftPrefix);
                System.out.println();

                System.out.println("Gebe einen Datei Namen ein: ");
				String filename = scanner.next();
				
				//annahme wenn name vorhanden, tut es überscheiben, wenn nicht neue datei erstellen
				FileHandler.writeToFile(filename, encryptedTextWithShiftPrefix);
				String content = FileHandler.readFromFile(filename);

				FileHandler.readFromFile(filename);
	            System.out.println("Inhalt der Datei: " + content);

                break;

            case 0: // Option 0: Beenden des Programms
                scanner.close(); // Schließen des Scanner-Objektes
                System.exit(0); // Beendigung des Programms
                break;

            default:
                // Behandlung ungültiger Auswahl
                System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut.");
                break;
            }
        }
    }
}
