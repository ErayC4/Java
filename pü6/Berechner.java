package pü6;

public class Berechner {
	public static int fakultaet(int n) {
		int fakultätsSumme = 1;
		
		for(int i = 1; i <= n; i++) {
			fakultätsSumme *= i;
		}	
		return fakultätsSumme;
	}
}
