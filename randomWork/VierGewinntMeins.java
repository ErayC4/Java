package randomWork;
import java.util.Scanner;

public class VierGewinntMeins {
	
	static int zeilen = 6;
	static int spalten = 7;
	static char brett[][] = new char[zeilen][spalten];
	static boolean spieler1Zug = true;

	public static void main(String[] args) {
		BrettInit();
		BrettZeigen();
		WerIstDran(spieler1Zug);
	}
	
	public static void BrettZeigen() {
		
		for(int i = 0; i < zeilen; i++) {
			for(int j = 0; j < spalten; j++) {
				System.out.print("|   ");
			}
			System.out.println("|");
		}
		System.out.println("* 1 * 2 * 3 * 4 * 5 * 6 * 7 *");
	}
	

	public static void BrettInit() {
		
		for(int i = 0; i < zeilen; i++) {
			for(int j = 0; j < spalten; j++) {
				brett[i][j] = ' ';
			}
		}
	}
	
	public static int WerIstDran(boolean isPlayer1Turn) {
		Scanner einlesen = new Scanner(System.in);
		System.out.print("Spieler " + (spieler1Zug ? "1" : "2") + ", wähle eine Spalte (1-7): ");
        return einlesen.nextInt() - 1;
		
	}
}
