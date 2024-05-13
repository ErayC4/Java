package pü2;
import java.util.Scanner;
public class PrimzahlErkenner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Gib eine Zahl ein: ");
        int eingabe = scanner.nextInt();

        if (eingabe <= 1) {
            System.out.println("Gib eine Zahl ein, die größer als 1 ist!");
            return;
        }

        for (int current = 2; current <= eingabe; current++) {
            boolean istPrimzahl = true;
            for (int i = 2; i <= current/2; i++) {
                if (current % i == 0) {
                    istPrimzahl = false;
                    break;
                }
            }
            if (istPrimzahl) {
                System.out.println(current);
            }
        }
	}

}
