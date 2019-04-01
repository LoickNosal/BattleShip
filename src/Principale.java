import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Principale {


	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		try {
			Partie p = new Partie();
			System.out.print("voulez-vous charger la partie ? oui/non : ");
			Scanner sc = new Scanner(System.in);
			String partie = sc.nextLine();
			if (partie.equals("oui")) {
				p = p.charger("test");
				//p.reprendrePartieIA();
			}else {
				Grille g = new Grille(10,10);
				Joueur j1 = new Joueur(g,"Loick");
				Partie p2 = new Partie(j1,j1);
				p2.PartieVsIA();
			}
			
		} catch (IOException e) {
			System.out.println("probleme a l’ouverture du fichier");
			throw(e);
		}
		
		

	}
	
	

}
