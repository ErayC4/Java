package pü2;
import java.util.Scanner;
public class PrimzahlMarkierer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Gebe die maximale Zahl ein: ");
        int n;
        //falls die Eingabe aus einem Int besteht
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                	boolean[] primzahlArray = new boolean[n + 1];

                    // Alle Zahlen auf true setzen
                    for (int i = 1; i < n + 1; i++) {
                        primzahlArray[i] = true;
                    }

                    // Sieb des Eratosthenes
                    for (int p = 2; p <= n; p++) {
                        if (primzahlArray[p]) {
                            for (int i = p+p; i <= n; i = i +  p) {
                                primzahlArray[i] = false;
                            }
                        }
                    }

                    // Primzahlen ausgeben
                    System.out.print("Primzahlen bis zu " + n + ": ");
                    for (int i = 2; i < n + 1; i++) {
                    	//falls es eine Primzahl ist, tut es diesen Ausgeben
                        if (primzahlArray[i]) {
                            System.out.print(i + " ");
                        }
                    }
                } else {
                    System.out.println("Bitte geb eine positive Zahl eine.");
                }
            } else {
                System.out.println("Bitte gebe eine Zahl ein.");
                scanner.next();
            }
        
        scanner.close(); // Schließen des Scanners

        
	}

}
