package TicTacToe;
import java.util.Random;

public class Spiel {
    private char[][] feld;
    private char spielerEins = 'X';
    private char spielerZwei = 'O';
    public char getSpielerEins() {
        return spielerEins;
    }

    public char getSpielerZwei() {
        return spielerZwei;
    }
    public Spiel() {
        feld = new char[3][3];
        feldInitialisieren();
    }
    
    private void feldInitialisieren() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                feld[i][j] = '-';
            }
        }
    }
    
    public void feldAnzeigen() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(feld[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean zugMachen(int Zeile, int Spalte, char Spieler) {
    	if(Zeile < 1 || Zeile > 3 || Spalte < 1 || Spalte > 3) {
    	    System.out.println("Ungültige Eingabe! Bitte zwischen 1 und 3 eingeben.");
    	    return false;
    	}
    	if(feld[Zeile-1][Spalte-1] == spielerEins || feld[Zeile-1][Spalte-1] == spielerZwei) {
    		System.out.println("Dieses Feld ist bereits belegt!");
    		return false;
    	}
    	
    	else if(Spieler != spielerEins && Spieler != spielerZwei) {
    		System.out.println("Ungültige Eingabe!");
    		return false;
    	}
    	else {
    		feld[Zeile-1][Spalte-1]=Spieler;
    		return true;
    	}
    }
    
    public boolean gewonnen(char spieler) {
    	String gewinner = null;
    	
    		for(int i=0; i<3; i++) {
    			if(feld[i][0] == feld[i][1] && feld[i][1]== feld[i][2] && feld[i][0] == spieler) {
        			gewinner = String.valueOf(feld[i][0]);
        			
    			}
    		}
    		for(int j=0; j<3; j++) {
    			if(feld[0][j] == feld[1][j] && feld[1][j]==feld[2][j] && feld[0][j] == spieler) {
        			gewinner = String.valueOf(feld[0][j]);
        			
    			}
 
    		}
    	    if(feld[0][0]==feld[1][1] && feld[1][1]==feld[2][2] && feld[0][0] == spieler) {
    	    	gewinner = String.valueOf(feld[0][0]);
    	    }
    	   
    	    if(feld[0][2]==feld[1][1] && feld[1][1]==feld[2][0] && feld[0][2] == spieler) {
    	    	gewinner = String.valueOf(feld[0][2]);
    	    }
    	
    	if(gewinner != null) {
    		System.out.println(gewinner +" ist der Gewinner!");
    		return true;
    	}
    	
    	else {
    		return false;
    	}
    }    
    public boolean unentschieden() {
    	for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(feld[i][j]=='-') {
                	return false;
                }
                
            }
    }
    	System.out.println();
    	feldAnzeigen();
    	System.out.println("Es ist unentschieden!");
    	return true;
}
    
    public void computerZug() {
    	int Zeile;
    	int Spalte;
    	Random random = new Random();
    	boolean success = false;
    	while(success == false) {
    	    Zeile = random.nextInt(3)+1;
    	    Spalte = random.nextInt(3)+1;
    	    success = zugMachen(Zeile, Spalte, spielerZwei);
    	}
    }
}	
    			
    		
    	
    
