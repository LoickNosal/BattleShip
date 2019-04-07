package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Loïck Nosal
 * représente une partie où s'affrontent deux joueurs
 *
 */
public class PartieDuo implements Partie, Serializable{
	
	/**
	 * joueur 1
	 */
	private Joueur j1;
	/**
	 * joueur 2
	 */
	private Joueur j2;
	
	/**
	 * @param jo1 joueur 1
	 * @param jo2 joueur 2
	 */
	public PartieDuo(Joueur jo1, Joueur jo2) {
		this.j1 = jo1;
		this.j2 = jo2;
	}
	
	/**
	 * Constructeur vide
	 */
	public PartieDuo() {
		
		this.j1 = null;
		this.j2 = null;
	}
	
	@Override
	public void sauvegarder(String dest) throws FileNotFoundException, IOException {
		
		ObjectOutputStream d = new ObjectOutputStream(new FileOutputStream(dest));
		d.writeObject(this);
		d.close();
		for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
			System.out.print(" ");
		}
		System.out.println("sauvegarde partie Duo effecutée");
	}
	
	@Override
	public PartieDuo charger(String source) throws IOException, ClassNotFoundException{
		ObjectInputStream di = new ObjectInputStream(new FileInputStream(source));
		PartieDuo p = (PartieDuo)(di.readObject());
		di.close();
		System.out.println("sauvegarde partie Duo chargée");
		return p;
	}
	
	@Override
	public void lancerPartie() throws FileNotFoundException, IOException {
		System.out.println();
		j2.afficherGrilleJoueur(j1);
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j1.nomJoueur + " , position x où tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j1.nomJoueur + " position y où tirer : ");
			int posY = sc.nextInt();
			j1.tirer(posX, posY, j2);
			
			if (j2.aucunBateau() == true) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j1.getNomJoueur() + " gagne");
				end = true;
				System.exit(1);
			}
			
			if(end == false) {
				for (int i = 0; i < this.j2.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j2.nomJoueur + " , position x où tirer : ");
				posX = sc.nextInt();
				for (int i = 0; i < this.j2.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j2.nomJoueur + " position y où tirer : ");
				posY = sc.nextInt();
				
				j2.tirer(posX, posY, j1);
				j2.afficherGrilleJoueur(j1);
				if (j1.aucunBateau() == true) {
					for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println(this.j2.getNomJoueur() + " gagne");
					end = true;
					System.exit(1);
				}
			}
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("src\\Sauvegardes\\partieDuo");
				System.exit(1);
			}
		}
		
	}
	@Override
	public void reprendrePartie() throws FileNotFoundException, IOException {
		System.out.println();
		j2.afficherGrilleJoueur(j1);
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j1.nomJoueur + " , position x où tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j1.nomJoueur + " position y où tirer : ");
			int posY = sc.nextInt();
			j1.tirer(posX, posY, j2);
			
			if (j2.aucunBateau() == true) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j1.getNomJoueur() + " gagne");
				end = true;
				System.exit(1);
			}
			
			if(end == false) {
				for (int i = 0; i < this.j2.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j2.nomJoueur + " , position x où tirer : ");
				posX = sc.nextInt();
				for (int i = 0; i < this.j2.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j2.nomJoueur + " position y où tirer : ");
				posY = sc.nextInt();
				
				j2.tirer(posX, posY, j1);
				j2.afficherGrilleJoueur(j1);
				if (j1.aucunBateau() == true) {
					for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println(this.j2.getNomJoueur() + " gagne");
					end = true;
					System.exit(1);
				}
			}
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("src\\Sauvegardes\\partieDuo");
				System.exit(1);
			}
		}
		
	}
}
