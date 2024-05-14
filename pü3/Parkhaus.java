package pü3;
import java.util.regex.*;
import java.util.Scanner;

public class Parkhaus {

	public static void main(String[] args) {
        System.out.println("Parkzeitberechnung");
		
        //tut einfahrt und Ausfahrt einlesen
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEinfahrt (hh:mm): ");
		String einfahrt = scanner.nextLine();
		
		System.out.print("Ausfahrt (hh:mm): ");
		String ausfahrt = scanner.nextLine();

		
		if (istEingabeGueltig(einfahrt, ausfahrt)) {
			int parkdauer = berechneZuZahlendeParkdauer(einfahrt, ausfahrt);
			
			if (parkdauer == 0) {
				System.out.println("Keine Gebühr erforderlich!");
			} else {
				float parkgebühren = berechneParkgebuehr(parkdauer);
				float parkgebührenInEuro = parkgebühren / 100 ;
				String parkstring = String.format("%.2f", parkgebührenInEuro);

				String[] teile = parkstring.split("\\,");
				System.out.println("\nParkgebühr: " + teile[0] + " Euro und " + teile[1] + " Cent.");
				System.out.print("Zahlung (€€,cc): ");
				String zahlung = scanner.nextLine();
				int zahlungInCent = zahlungGueltig(zahlung);
				int rueckgeld = zahlungInCent - (int)parkgebühren;
				int[] rueckgeldArray = rueckgeld(rueckgeld);
				if (zahlungInCent != -1) {
					if (zahlungInCent - parkgebühren >= 0) {
						for (int i = 0; i < rueckgeldArray.length; i++) {
							String[] ausgabenArray = {"\nRueckgeld\n2 Euro: ", "1 Euro: ", "50 Cent: ", "20 Cent: ", "10 Cent: "};
							System.out.println(ausgabenArray[i] + rueckgeldArray[i]);
						}
						} else {
							
						System.out.print("\nDu Geizhals steckst jetzt fest!");
						}
				} else {
					System.out.print("\nDie Eingabe ist nicht korrekt!");
				}
			}
		} else {
			System.out.println("Die Eingabe ist ungültig.");
		}
		scanner.close();

	}	
		
//		
	public static boolean istEingabeGueltig(String einfahrt, String ausfahrt) {
		// Überprüft die Validität der Eingabezeiten in dem Format hh:mm.
		// Die Methode kontrolliert, ob die Zeiten 
		// innerhalb der Betriebszeiten des Parkhauses liegen (06:00 bis 22:00 Uhr),
		// ob die Einfahrtszeit nicht nach der Ausfahrtszeit liegt.
		String pattern = "\\d{2}:\\d{2}";
		
        // Erstelle ein Pattern-Objekt
        Pattern p = Pattern.compile(pattern);
        
        // Erstellt Matcher-Objekt
        Matcher m = p.matcher(einfahrt);
        Matcher n = p.matcher(ausfahrt);
		
		if (m.matches() && n.matches()) {
		
	        String[] einfahrtszeitStücke = einfahrt.split(":");
	        String[] ausfahrtszeitStücke = ausfahrt.split(":");
	        
	        int einfahrtstunden = Integer.parseInt(einfahrtszeitStücke[0]);
	        int einfahrtminuten = Integer.parseInt(einfahrtszeitStücke[1]);
	        int ausfahrtstunden = Integer.parseInt(ausfahrtszeitStücke[0]);
	        int ausfahrtminuten = Integer.parseInt(ausfahrtszeitStücke[1]);
        
	        if (einfahrtstunden > ausfahrtstunden || (einfahrtstunden == ausfahrtstunden && einfahrtminuten >= ausfahrtminuten)) {
	        	return false;
	        }
	        
	        if (einfahrtstunden == 22 || ausfahrtstunden == 22) {
	        	return (einfahrtstunden >= 6 && einfahrtstunden <= 22) && (einfahrtminuten < 60) && 
	             	   (ausfahrtstunden >= 6 && ausfahrtstunden <= 22) && (ausfahrtminuten == 0);
	        }
        
	        return (einfahrtstunden >= 6 && einfahrtstunden < 22) && (einfahrtminuten >= 0 && einfahrtminuten < 60) && 
	        	   (ausfahrtstunden >= 6 && ausfahrtstunden < 22) && (ausfahrtminuten >= 0 && ausfahrtminuten < 60);
        
         } else {
        	 return false;
         }
        
	}
		
	public static int berechneZuZahlendeParkdauer(String einfahrt, String ausfahrt) {
		// Berechnet die Dauer in Minuten, für die Parkgebühren anfallen,
		// unter Berücksichtigung der gebührenfreien Zeiten.
		// Die Parkgebühr beginnt nach einer gebührenfreien Zeit von 06:00 bis 10:00 Uhr
		// sowie einer zusätzlichen
		// ersten kostenlosen Stunde nach Beginn der Gebührenpflicht um 10:00 Uhr. Wenn die
		// Parkdauer null Minuten beträgt
		// oder die gesamte Parkzeit innerhalb der gebührenfreien Zeitspannen liegt,
		// fallen keine Gebühren an und somit beträgt die parkdauer = 0.
		
			String[] einfahrtzeitstücke = einfahrt.split(":");
	        String[] ausfahrtzeitstücke = ausfahrt.split(":");
	        
	        int einfahrtstunden = Integer.parseInt(einfahrtzeitstücke[0]);
	        int einfahrtminuten = Integer.parseInt(einfahrtzeitstücke[1]);
	        int ausfahrtstunden = Integer.parseInt(ausfahrtzeitstücke[0]);
	        int ausfahrtminuten = Integer.parseInt(ausfahrtzeitstücke[1]);
			
	        int einfahrtszeit = einfahrtstunden * 60 + einfahrtminuten;
	        int ausfahrtszeit = ausfahrtstunden * 60 + ausfahrtminuten;

	        int parkdauer = (ausfahrtszeit - einfahrtszeit) - 60;
	        
	        //falls in der gebührenfreien zeit eingefahren wurde
	        if (einfahrtstunden >= 6 && einfahrtstunden < 10) {
	        	//falls die gebührenfreie zeit überschritten worden ist.
	            if (ausfahrtstunden >= 10) {
	            	//guck um wie viel die gebührenfreie zeit überschritten worden ist
	            	parkdauer = parkdauer - (10 * 60) - einfahrtszeit;
	            
	            //falls im bereich zwischen 6 und 10 geblieben worden ist,
	            //ist die gebührenpflichtige parkdauer = 0
	            } else {
	                parkdauer = 0;
	            }
	        }
	        //falls parkdauer größer 0 ist, gibt es parkdauer zurück,
	        //wenn nicht dann die 0
	        return Math.max(0, parkdauer);
		}
		

	public static int berechneParkgebuehr(int parkdauer) {
		// Berechnet die Parkgebühr basierend auf der gesamten gebührenpflichtigen Parkdauer in Minuten.
		// Die ersten 90 Minuten nach der freien Zeit kosten pauschal 3,00 Euro.
		// Danach wird jede angefangene Stunde
		// mit 1,50 Euro berechnet, bis ein Maximalbetrag von 10,00 Euro erreicht ist.
		// @param parkdauer Die gesamte gebührenpflichtige Parkdauer in Minuten.
		// @return Die Parkgebühr in Cent. 
		// Bei einer Parkdauer von 0 Minuten oder weniger wird keine Gebühr berechnet.
		if (parkdauer <= 0) {
	        return 0;
	    }

		int stündlicheGebühr = 150; // 1.50 Euro in Cent
		
		//wenn parkdauer kleiner 0 ist, gibt es 0 zurück
		//berechnet wie viele minuten man zahlen muss
		int zuzahlendeMinuten = Math.max(parkdauer - 90, 0);

		//Math.min erlaubt es in diesem fall, das wenn die berechnung größer 1000 ist, 1000 zurückzugeben 
		//Math.ceil gibt die kleinste gerade Zahl zurück
		//300 für die 90 min + stundenanzahl * stündliche gebü
		return Math.min(300 + (int)Math.ceil(zuzahlendeMinuten / 60.0) * stündlicheGebühr, 1000);

	}

	public static int zahlungGueltig(String zahlung) {
		// Überprüft die Gültigkeit der vom Benutzer eingegebenen Zahlung.
		// Eine gültige Zahlung muss im Format €€,cc erfolgen,
		// darf keine negativen Werte enthalten und die Cent-Angabe muss
		// durch 10 teilbar sein.
		// @param zahlung Die eingegebene Zahlung als String im Format €€,cc
		// @return Den Wert der Zahlung in Cent, wenn diese gültig ist; andernfalls -1.
		String pattern = "\\d{2},\\d{2}";

        // Erstelle ein Pattern-Objekt
        Pattern p = Pattern.compile(pattern);

        // Erstelle ein Matcher-Objekt
        Matcher m = p.matcher(zahlung);

        if(m.matches()) {
            String[] zahlungsstücke = zahlung.split(",");

            int zahlungeuro = Integer.parseInt(zahlungsstücke[0]);
            int zahlungcent = Integer.parseInt(zahlungsstücke[1]); 

            if (zahlungeuro > 99 || zahlungcent > 90  || zahlungcent % 10 != 0 ) {
                return -1;
            }
            
            return (zahlungeuro * 100)+ zahlungcent;
        } else {
            return -1;
        }
    }
	
	public static int[] rueckgeld(int rueckgeld) {
		// Berechnet die Aufteilung des Rückgelds in verschiedene Münzwerte
		// basierend auf dem übergebenen Gesamtbetrag in Cent.
		// Die Methode teilt das Rückgeld in die größtmöglichen Münzwerte auf,
		// beginnend mit 2 Euro, gefolgt von 1 Euro,
		// 50 Cent, 20 Cent und 10 Cent. Anschliessend gibt diese das Rückgeld in
		// absteigender Reihenfolge zurück.
		// @param rueckgeld Der Rückgeldbetrag in Cent, der aufgeteilt werden soll.
		// @return Ein Array von ganzen Zahlen, das die Anzahl der Münzen für jede
		// Stückelung enthält. Die Reihenfolge im Array entspricht: [2 Euro-Münzen,
		// 1 Euro-Münzen, 50 Cent-Münzen, 20 Cent-Münzen, 10 Cent-Münzen].
		int[] muenzen = {200, 100, 50, 20, 10};
	    int[] rueckgeldarray = new int[muenzen.length];

	    for (int i = 0; i < muenzen.length; i++) {
	        rueckgeldarray[i] = rueckgeld / muenzen[i];
	        rueckgeld %= muenzen[i];
	    }
	    
	    return rueckgeldarray;
	}
}