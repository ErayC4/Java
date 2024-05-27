package pü4;

public class Crypto {

    // Methode zur Verschlüsselung eines Textes mit dem Caesar-Verfahren
    public static String caesarEncrypt(String textToEncrypt, int shift) {
        shift = normalizeShiftValue(shift);
        char[] chars = new char[textToEncrypt.length()]; // Char-Array zur Aufnahme des verschlüsselten Textes
        for (int charIndex = 0; charIndex < textToEncrypt.length(); charIndex++) {
            char character = textToEncrypt.charAt(charIndex); // Extraktion des einzelnen Zeichens aus dem Text
            if (character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z') { // Überprüfung, ob das Zeichen ein Buchstabe ist
                char base;
                if (character >= 'A' && character <= 'Z') { // Bestimmung der Basis
                    base = 'A'; // Für Großbuchstaben
                } else {
                    base = 'a'; // Für Kleinbuchstaben
                }
                chars[charIndex] = (char) (base + (character - base + shift) % 26); // Berechnung des verschobenen Zeichens unter Berücksichtigung des Überlaufs im Alphabet
            } else {
                chars[charIndex] = character; // Beibehaltung von Nicht-Buchstaben-Zeichen im Text
            }
        }
        return new String(chars); // Konvertierung des Char-Arrays zurück in einen String und Rückgabe
    }

    // Methode zur Normalisierung des Verschiebungswerts innerhalb des gültigen Bereichs (Shift-Wert immer zwischen 0 und 25)
    public static int normalizeShiftValue(int shift) {
        return (shift % 26 + 26) % 26;
    }

    // Methode zur Normalisierung des Verschiebungswerts und Hinzufügung als Präfix zum verschlüsselten Text
    public static String normalizeShiftValueAndSetShiftAsPrefix(int shift, String encryptedText) {
        shift = normalizeShiftValue(shift);
        if (shift <= 9) {
            return "0" + normalizeShiftValue(shift) + encryptedText;
        } else {
            return normalizeShiftValue(shift) + encryptedText;
        }
    }

}