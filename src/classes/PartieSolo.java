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
			System.out.print(j.nomJoueur + " position x où tirer : ");
			int posX = sc.nextInt();
			System.out.print(j.nomJoueur + " position y où tirer : ");
			int posY = sc.nextInt();
			j.tirer(posX, posY, j);
			j.afficherGrilleJoueur(j);
			if (j.aucunBateau() == true) {
				System.out.println("Fin de partie");
				end = true;
				return;
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
		System.out.println("sauvegarde partie Solo effecutée");
	}

	@Override
	public PartieSolo charger(String source) throws IOException, ClassNotFoundException{
		
		ObjectInputStream di = new ObjectInputStream(new FileInputStream(source));
		PartieSolo p = (PartieSolo)(di.readObject());
		di.close();
		System.out.println("sauvegarde partie Solo chargée");
		return p;
	}

	@Override
	public void reprendrePartie() throws FileNotFoundException, IOException {
		System.out.println();
		j.afficherGrilleJoueur(j);
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			System.out.print(j.nomJoueur + " position x où tirer : ");
			int posX = sc.nextInt();
			System.out.print(j.nomJoueur + " position y où tirer : ");
			int posY = sc.nextInt();
			j.tirer(posX, posY, j);
			j.afficherGrilleJoueur(j);
			if (j.aucunBateau() == true) {
				System.out.println("Fin de partie");
				end = true;
				return;
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
