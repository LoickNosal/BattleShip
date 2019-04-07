package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class PartieIA implements Partie, Serializable {
	
	private Joueur j;
	private IA intelligence;
	
	public PartieIA(Joueur jo) {
		this.j = jo;
		this.intelligence = null;
	}
	
	public PartieIA() {
		this.j = null;
		this.intelligence = null;
	}
	
	@Override
	public void sauvegarder(String dest) throws FileNotFoundException, IOException {
		ObjectOutputStream d = new ObjectOutputStream(new FileOutputStream(dest));
		d.writeObject(this);
		d.close();
		for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
			System.out.print(" ");
		}
		System.out.println("sauvegarde partie IA effecutée");
	}

	@Override
	public PartieIA charger(String source) throws IOException, ClassNotFoundException{
	
		ObjectInputStream di = new ObjectInputStream(new FileInputStream(source));
		PartieIA p = (PartieIA)(di.readObject());
		di.close();
		System.out.println("sauvegarde partie IA chargée");
		return p;
	}
	
	@Override
	public void lancerPartie() throws FileNotFoundException, IOException {
		Grille gIA = new Grille(j.gJoueur.getTailleX(),j.gJoueur.getTailleY());
		this.intelligence = new IA(gIA,"IA");
		boolean end = false;
		intelligence.afficherGrilleJoueur(j);
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " , position x où tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " position y où tirer : ");
			int posY = sc.nextInt();
			j.tirer(posX, posY, intelligence);
			
			if (intelligence.aucunBateau() == true) {
				for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j.getNomJoueur() + " gagne");
				end = true;
				System.exit(1);
			}
			
			if(end == false) {
				intelligence.tirer(j);
				//j1.afficherGrilleJoueur();
				intelligence.afficherGrilleJoueur(j);
				if (j.aucunBateau() == true) {
					for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println("l'IA gagne");
					end = true;
					System.exit(1);
				}
			}
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("src\\Sauvegardes\\partieIA");
				System.exit(1);
			}
		}
	}
	
	@Override
	public void reprendrePartie() throws FileNotFoundException, IOException {
		System.out.println();
		intelligence.afficherGrilleJoueur(j);
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " , position x où tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j.nomJoueur + " position y où tirer : ");
			int posY = sc.nextInt();
			j.tirer(posX, posY, intelligence);
			
			if (intelligence.aucunBateau() == true) {
				for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j.getNomJoueur() + " gagne");
				end = true;
				System.exit(1);
			}
			
			if(end == false) {
				intelligence.tirer(j);
				//j1.afficherGrilleJoueur();
				intelligence.afficherGrilleJoueur(j);
				if (j.aucunBateau() == true) {
					for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println("l'IA gagne");
					end = true;
					System.exit(1);
				}
			}
			for (int i = 0; i < this.j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("test");
				System.exit(1);
			}
		}
	}









}
