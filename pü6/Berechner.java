package pü6;

import java.util.Scanner;

public class Berechner {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welche Rechenart soll ausgeführt werden?");
            System.out.println("[ Multiplikation | Division | Exponent | Fakultät ]");
            System.out.println("[ m | d | e | f ]");
            System.out.print("Geben Sie das zugehörige Zeichen an: ");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie genau ein Zeichen ein.");
                continue;
            }

            char operation = input.charAt(0);
            int ergebnis = berechnung(operation);
            if (ergebnis != -1) {
                System.out.println("Das Ergebnis ist: " + ergebnis + "\n");
            }
        }
    }

    public static int berechnung(char c) {
        Scanner scanner = new Scanner(System.in);
        try {
            switch (c) {
                case 'm':
                    System.out.print("Geben Sie den ersten Faktor ein: ");
                    int faktor1 = scanner.nextInt();
                    System.out.print("Geben Sie den zweiten Faktor ein: ");
                    int faktor2 = scanner.nextInt();
                    return multiplizieren(faktor1, faktor2);
                case 'd':
                    System.out.print("Geben Sie den Dividend ein: ");
                    int dividend = scanner.nextInt();
                    System.out.print("Geben Sie den Divisor ein: ");
                    int divisor = scanner.nextInt();
                    return dividieren(dividend, divisor);
                case 'e':
                    System.out.print("Geben Sie die Basis ein: ");
                    int grundwert = scanner.nextInt();
                    System.out.print("Geben Sie den Exponenten ein: ");
                    int exponent = scanner.nextInt();
                    return exponent(grundwert, exponent);
                case 'f':
                    System.out.print("Geben Sie eine Zahl ein: ");
                    int n = scanner.nextInt();
                    return fakultaet(n);
                default:
                    System.out.println("Ungültiges Zeichen. Bitte versuchen Sie es erneut.");
                    return -1;
            }
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Fehler: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.out.println("Ein unbekannter Fehler ist aufgetreten.");
            return -1;
        }
    }

    public static int multiplizieren(int faktor1, int faktor2) {
        if (faktor1 < 0 || faktor2 < 0) {
            throw new IllegalArgumentException("Faktoren müssen positiv sein.");
        }
        if (faktor2 == 0) {
            return 0;
        }
        return faktor1 + multiplizieren(faktor1, faktor2 - 1);
    }

    public static int dividieren(int dividend, int divisor) {
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("Dividend und Divisor müssen positiv sein.");
        }
        if (divisor == 0) {
            throw new ArithmeticException("Division durch Null ist nicht erlaubt.");
        }
        if (dividend < divisor) {
            return 0;
        }
        return 1 + dividieren(dividend - divisor, divisor);
    }

    public static int exponent(int grundwert, int exponent) {
        if (grundwert < 0 || exponent < 0) {
            throw new IllegalArgumentException("Grundwert und Exponent müssen positiv sein.");
        }
        if (exponent == 0) {
            return 1;
        }
        return grundwert * exponent(grundwert, exponent - 1);
    }

    public static int fakultaet(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Die Zahl muss positiv sein.");
        }
        if (n == 0) {
            return 1;
        }
        return n * fakultaet(n - 1);
    }
}
