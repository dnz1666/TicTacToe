package TicTacToe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	boolean gewinn = false;
    	boolean draw = false;
    	Scanner scanner = new Scanner(System.in);
      	int Zeile;
    	int Spalte;
    	int Auswahl=0;
        Spiel spiel = new Spiel();  
        boolean abfrage = false;
        while(abfrage == false) {
        System.out.println("Spielen Sie zu zweit oder möchten Sie gegen den Computer spielen?");
        System.out.print("Wählen sie (1) für zu zweit und (2) um gegen den Computer zu spielen :");
        Auswahl = Integer.parseInt(scanner.nextLine());
        if(Auswahl != 1 && Auswahl!= 2) {
        	System.out.print("Ungültige Eingabe!\n\n");
        	abfrage = false;
        }
        else {
        	abfrage=true;
        }
        }
        
        if(Auswahl == 1) {
        while(gewinn == false && draw == false) {
            spiel.feldAnzeigen();
            System.out.println("Spieler 1 (X)");
            boolean gueltig= false;
            while(gueltig == false) {
                System.out.print("Zeile: ");
                Zeile = Integer.parseInt(scanner.nextLine());
                System.out.print("Spalte: ");
                Spalte = Integer.parseInt(scanner.nextLine());
                gueltig = spiel.zugMachen(Zeile, Spalte, spiel.getSpielerEins());
            }
            
            if(spiel.gewonnen(spiel.getSpielerEins())) {
                spiel.feldAnzeigen();
                System.out.println("Spieler 1 (X) hat gewonnen!");
                gewinn = true;
                continue;
            }
            if(spiel.unentschieden()) {
                draw = true;
                continue;
            }
            
            spiel.feldAnzeigen();
            boolean gueltigz= false;
            System.out.print("Spieler 2 (O) ");
            while(gueltigz == false) {
                System.out.print("Zeile: ");
                Zeile = Integer.parseInt(scanner.nextLine());
                System.out.print("Spalte: ");
                Spalte = Integer.parseInt(scanner.nextLine());
                gueltigz = spiel.zugMachen(Zeile, Spalte, spiel.getSpielerZwei());
            }
            
            if(spiel.gewonnen(spiel.getSpielerZwei())) {
                spiel.feldAnzeigen();
                System.out.println("Spieler 2 (O) hat gewonnen!");
                gewinn = true;
                continue;
            }
            if(spiel.unentschieden()) {
                draw = true;
                continue;
            }
        }
        }
        else {
        	while(gewinn == false && draw == false) {
                spiel.feldAnzeigen();
                System.out.println("Spieler 1 (X)");
                boolean gueltig= false;
                while(gueltig == false) {
                    System.out.print("Zeile: ");
                    Zeile = Integer.parseInt(scanner.nextLine());
                    System.out.print("Spalte: ");
                    Spalte = Integer.parseInt(scanner.nextLine());
                    gueltig = spiel.zugMachen(Zeile, Spalte, spiel.getSpielerEins());
                }
                
                if(spiel.gewonnen(spiel.getSpielerEins())) {
                    spiel.feldAnzeigen();
                    System.out.println("Spieler 1 (X) hat gewonnen!");
                    gewinn = true;
                    continue;
                }
                if(spiel.unentschieden()) {
                    draw = true;
                    continue;
                }
                spiel.feldAnzeigen();
                System.out.println();
                spiel.computerZug();
                if(spiel.gewonnen(spiel.getSpielerZwei())) {
                    spiel.feldAnzeigen();
                    System.out.println("Der Computer (O) hat gewonnen!");
                    gewinn = true;
                    continue;
                }
                if(spiel.unentschieden()) {
                    draw = true;
                    continue;
                }
        }
    }
}
}
