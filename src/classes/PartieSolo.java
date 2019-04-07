package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class PartieSolo implements Partie, Serializable{
	
	private Joueur j;
	
	public PartieSolo(Joueur jo) {
		this.j = jo;
	}
	
	public PartieSolo() {
		this.j = null;
	}
	
	@Override
	public void lancerPartie() throws FileNotFoundException, IOException {
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " position x o� tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " position y o� tirer : ");
			int posY = sc.nextInt();
			j.tirer(posX, posY, j);
			j.afficherGrilleJoueur(j);
			if (j.aucunBateau() == true) {
				for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println("Fin de partie");
				end = true;
				System.exit(1);
			}
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("src\\Sauvegardes\\partieSolo");
				System.exit(1);
			}
		}

	}

	@Override
	public void sauvegarder(String dest) throws FileNotFoundException, IOException {
		ObjectOutputStream d = new ObjectOutputStream(new FileOutputStream(dest));
		d.writeObject(this);
		d.close();
		for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
			System.out.print(" ");
		}
		System.out.println("sauvegarde partie Solo effecut�e");
	}

	@Override
	public PartieSolo charger(String source) throws IOException, ClassNotFoundException{
		
		ObjectInputStream di = new ObjectInputStream(new FileInputStream(source));
		PartieSolo p = (PartieSolo)(di.readObject());
		di.close();
		
		System.out.println("sauvegarde partie Solo charg�e");
		return p;
	}

	@Override
	public void reprendrePartie() throws FileNotFoundException, IOException {
		System.out.println();
		j.afficherGrilleJoueur(j);
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " position x o� tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " position y o� tirer : ");
			int posY = sc.nextInt();
			j.tirer(posX, posY, j);
			j.afficherGrilleJoueur(j);
			if (j.aucunBateau() == true) {
				for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println("Fin de partie");
				end = true;
				System.exit(1);
			}
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("src\\Sauvegardes\\partieSolo");
				System.exit(1);
			}
		}
	}

}
