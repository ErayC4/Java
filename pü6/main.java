package pü6;

import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in); // Erzeugt ein Scanner-Objekt für Eingaben über die Konsole

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welche Rechenart soll ausgeführt werden?\r\n");
		System.out.println("[ Multiplikation | Division | Exponent | Fakultät ]");
		System.out.println("[ m | d | e | f ]\r\n");
		String rechenArtAuswahl = scanner.next();
		if(rechenArtAuswahl.length() != 1) {
			System.out.println("ne");
		} else {
			System.out.println("Gebe eine Zahl ein");
			int n = scanner.nextInt();
			switch (rechenArtAuswahl) {
				case "m": 
					System.out.println("case m");
				break;
				default: 
					System.out.println("gebe m | d | e | f ein!");
				}
				
		}
		
	}

}
