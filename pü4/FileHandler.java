package pü4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Klasse FileHandler zur Verwaltung der Dateioperationen
public class FileHandler {
    static String defaultFilePath = "C:\\Dateien\\Coding\\Java\\püTextDateien\\"; // Variable für den Standardpfad der Dateien

    // Methode zum Schreiben eines Textes in eine Datei
    public static void writeToFile(String filename, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(defaultFilePath + filename));
        writer.write(text);
        writer.close();
    }

    // Methode zum Lesen eines Textes aus einer Datei
    public static String readFromFile(String filename) throws IOException {
        // Öffnet einen BufferedReader, um aus der Datei zu lesen, deren Pfad aus dem Standardpfad und dem Dateinamen besteht
        BufferedReader reader = new BufferedReader(new FileReader(defaultFilePath + filename));
        
        // Erstellt einen StringBuilder, um den Inhalt der Datei zu speichern
        StringBuilder fileContent = new StringBuilder();
        
        // Deklariert eine String-Variable für die Zeilen, die aus der Datei gelesen werden
        String currentLine;
        
        // Liest Zeile für Zeile aus der Datei, bis das Ende der Datei erreicht ist (null)
        while ((currentLine = reader.readLine()) != null) {
            // Fügt die gelesene Zeile und einen Zeilenumbruch dem StringBuilder hinzu
			fileContent.append(currentLine).append("\n");
        }
        
        // Schließt den BufferedReader, um Ressourcen freizugeben
        reader.close();
        
        // Gibt den gesamten Inhalt der Datei als String zurück
        return fileContent.toString();
    }

}
