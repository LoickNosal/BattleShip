import java.io.IOException;
import java.util.Scanner;

public class Principale {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		Grille g = new Grille(10,10);
		Joueur j1 = new Joueur(g,"Loick");

		Partie p = new Partie(j1,j1);
		p.PartieVsIA();

	}

}
