package randomWork;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sodoku {
	
	public static ArrayList<String> readFile(String path) throws FileNotFoundException {
		   ArrayList<String> lines = new ArrayList<>();
		   Scanner sc = new Scanner(new File(path));
		 
		   
		   while (sc.hasNextLine()) {
		      lines.add(sc.nextLine());
		   }

		   sc.close();		
		   
		   return lines;
		}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> text = readFile("resources/sodokus.csv");
		SodokuAusgeben(text);
		
	}
	
	public static void SodokuAusgeben(ArrayList<String> csv) {
		int csvSize = csv.size();
		
			
			
			String csvNummern = csv.get(((int)(Math.random()*csvSize)));
			char[] ungelöstesSodoku = new char[81];
			char[] gelöstesSodoku = new char[81];
			
			char[][] ungelöstesSodoku2D = new char [9][9];
			char[][] gelöstesSodoku2D = new char [9][9];
			
			//ungelöstes 1d sodok
			for(int k = 0; k < 81; k++) {
				//0 in - umwandeln
				ungelöstesSodoku[k] = (csvNummern.charAt(k));
			}
			
			//gelöstes 1d sodok
			for(int n = 82; n < 163; n++) {
				gelöstesSodoku[n - 82] = (csvNummern.charAt(n));	
			}
			
			//ungelöstes 2D-Array
			System.out.println("ungelöstes sodoku: ");
			System.out.println("---a-b-c---d-e-f---g-h-i-");

			for(int zeilen = 0; zeilen < 9; zeilen++) {
				System.out.print(zeilen);
				for(int spalten = 0; spalten < 9; spalten++) {
					ungelöstesSodoku2D[zeilen][spalten] = ungelöstesSodoku[zeilen * 9 + spalten];
					
					if(spalten % 3 == 0) {
						System.out.print("| ");
					}
					System.out.print(ungelöstesSodoku2D[zeilen][spalten] + " ");
				}
				System.out.println("\n");
				if((zeilen  + 1) % 3 == 0 && zeilen != 0) {
					System.out.println("------------------------");
				}
			}
			
			//gelöstes 2D-Array
			System.out.println("gelöstes sodoku: ");
			System.out.println("---a-b-c---d-e-f---g-h-i-");

			for(int zeilen = 0; zeilen < 9; zeilen++) {
				System.out.print(zeilen);
				for(int spalten = 0; spalten < 9; spalten++) {
					gelöstesSodoku2D[zeilen][spalten] = gelöstesSodoku[zeilen * 9 + spalten];
					
					if(spalten % 3 == 0) {
						System.out.print("| ");
					}
					System.out.print(gelöstesSodoku2D[zeilen][spalten] + " ");
				}
				System.out.println("\n");
				if((zeilen  + 1) % 3 == 0 && zeilen != 0) {
					System.out.println("------------------------");
				}
			}
	}

}
