package pü6;

import java.awt.Point;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Packstation packstation = new Packstation();

        while (true) {
            System.out.println("W채hlen Sie eine Option:");
            System.out.println("1. Paket ablegen");
            System.out.println("2. Freie Boxen zählen");
            System.out.println("3. Information zum Boxenplatz anzeigen");
            System.out.println("4. Beenden");
            System.out.print("Ihre Wahl: ");
            int wahl = scanner.nextInt();
            scanner.nextLine();  // Eingabepuffer leeren

            switch (wahl) {
                case 1:
                    System.out.print("Empfänger: ");
                    String empfaenger = scanner.nextLine();
                    System.out.print("Adresse: ");
                    String adresse = scanner.nextLine();
                    Paket paket = new Paket(empfaenger, adresse);
                    try {
                        Point position = packstation.legePaketAb(paket);
                        System.out.println("Paket abgelegt bei: " + position);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    int freieBoxen = packstation.zaehleFreieBoxen();
                    System.out.println("Freie Boxen: " + freieBoxen);
                    break;
                case 3:
                    System.out.print("Spalte: ");
                    int spalte = scanner.nextInt();
                    System.out.print("Reihe: ");
                    int reihe = scanner.nextInt();
                    scanner.nextLine();  // Eingabepuffer leeren
                    try {
                        String info = packstation.informationZumBoxenplatz(spalte, reihe);
                        System.out.println(info);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Programm beendet.");
                    return;
                default:
                    System.out.println("Ung체ltige Wahl. Bitte versuchen Sie es erneut.");
            }
        }
    }
}