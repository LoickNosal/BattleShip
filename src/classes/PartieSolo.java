package classes;

import java.io.Serializable;
import java.util.Scanner;

public class PartieSolo implements Partie, Serializable{
	
	private Joueur j;
	
	@Override
	public void lancerPartie() {
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			System.out.print("position x où tirer : ");
			int posX = sc.nextInt();
			System.out.print("position y où tirer : ");
			int posY = sc.nextInt();
			j.tirer(posX, posY, j);
			j.afficherGrilleJoueur();
			if (j.aucunBateau() == true) {
				System.out.println("Fin de partie");
				end = true;
				return;
			}		
		}

	}

	@Override
	public void sauvegarder(String dest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Partie charger(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reprendrePartie() {
		// TODO Auto-generated method stub
		
	}

}
