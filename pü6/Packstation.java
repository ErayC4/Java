package pü6;

import java.awt.Point;

public class Packstation {
    public Paket[][] station;

    public Packstation(int breite, int hoehe) {
        if (breite <= 0 || hoehe <= 0) {
            throw new IllegalArgumentException("Breite und Höhe müssen größer als 0 sein.");
        }
        station = new Paket[breite][hoehe];
    }

    public Packstation() {
        this(5, 4);
    }

    public Point legePaketAb(Paket paket) {
        for (int i = 0; i < station.length; i++) {
            for (int j = 0; j < station[i].length; j++) {
                if (station[i][j] == null) {
                    station[i][j] = paket;
                    return new Point(i, j);
                }
            }
        }
        throw new IllegalStateException("Kein Platz mehr in der Packstation.");
    }

    public int zaehleFreieBoxen() {
        int freieBoxen = 0;
        for (int i = 0; i < station.length; i++) {
            for (int j = 0; j < station[i].length; j++) {
                if (station[i][j] == null) {
                    freieBoxen++;
                }
            }
        }
        return freieBoxen;
    }

    public String informationZumBoxenplatz(int spalte, int reihe) {
        if (spalte < 0 || spalte >= station.length || reihe < 0 || reihe >= station[0].length) {
            throw new IllegalArgumentException("Die angegebene Box existiert nicht.");
        }
        Paket paket = station[spalte][reihe];
        if (paket == null) {
            return "Die Box ist leer";
        } else {
            return paket.toString();
        }
    }
}