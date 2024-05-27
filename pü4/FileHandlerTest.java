package pü4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

// Klasse FileHandler zur Verwaltung der Dateioperationen
public class FileHandlerTest {
    static String defaultFilePath = "C:\\Dateien\\Coding\\Java\\püTextDateien"; // Variable für den Standardpfad der Dateien

    // Methode zum Schreiben eines Textes in eine Datei
    public static void writeToFile(String filename, String text) throws IOException {
        String fullPath = Paths.get(defaultFilePath, filename).toString(); // Kombinieren des Pfades mit dem Dateinamen
        Files.write(Paths.get(fullPath), text.getBytes(StandardCharsets.UTF_8)); // Schreiben des Textes in die Datei
    }

    // Methode zum Lesen eines Textes aus einer Datei
    public static String readFromFile(String filename) throws IOException {
        String fullPath = Paths.get(defaultFilePath, filename).toString(); // Kombinieren des Pfades mit dem Dateinamen
        return new String(Files.readAllBytes(Paths.get(fullPath)), StandardCharsets.UTF_8); // Lesen des Textes aus der Datei
    }
}
