package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class PartieDuo implements Partie, Serializable{
	
	private Joueur j1;
	private Joueur j2;
	
	public PartieDuo(Joueur jo1, Joueur jo2) {
		this.j1 = jo1;
		this.j2 = jo2;
	}
	
	public PartieDuo() {
		this.j1 = null;
		this.j2 = null;
	}
	
	@Override
	public void sauvegarder(String dest) throws FileNotFoundException, IOException {
		ObjectOutputStream d = new ObjectOutputStream(new FileOutputStream(dest));
		d.writeObject(this);
		d.close();
		System.out.println("sauvegarde partie Duo effecut�e");
	}
	
	@Override
	public PartieDuo charger(String source) throws IOException, ClassNotFoundException{
		ObjectInputStream di = new ObjectInputStream(new FileInputStream(source));
		PartieDuo p = (PartieDuo)(di.readObject());
		di.close();
		System.out.println("sauvegarde partie Duo charg�e");
		return p;
	}
	
	@Override
	public void lancerPartie() throws FileNotFoundException, IOException {
		j2.afficherGrilleJoueur(j1);
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j1.nomJoueur + " , position x o� tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j1.nomJoueur + " position y o� tirer : ");
			int posY = sc.nextInt();
			j1.tirer(posX, posY, j2);
			
			if (j2.aucunBateau() == true) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j1.getNomJoueur() + " gagne");
				end = true;
			}
			
			if(end == false) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j1.nomJoueur + " , position x o� tirer : ");
				posX = sc.nextInt();
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j1.nomJoueur + " position y o� tirer : ");
				posY = sc.nextInt();
				
				j2.tirer(posX, posY, j1);
				j2.afficherGrilleJoueur(j1);
				if (j1.aucunBateau() == true) {
					for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println(this.j2.getNomJoueur() + " gagne");
					end = true;
				}
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
			System.out.print(j1.nomJoueur + " , position x o� tirer : ");
			int posX = sc.nextInt();
			for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(j1.nomJoueur + " position y o� tirer : ");
			int posY = sc.nextInt();
			j1.tirer(posX, posY, j2);
			
			if (j2.aucunBateau() == true) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j1.getNomJoueur() + " gagne");
				end = true;
			}
			
			if(end == false) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j1.nomJoueur + " , position x o� tirer : ");
				posX = sc.nextInt();
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.print(j1.nomJoueur + " position y o� tirer : ");
				posY = sc.nextInt();
				
				j2.tirer(posX, posY, j1);
				j2.afficherGrilleJoueur(j1);
				if (j1.aucunBateau() == true) {
					for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println(this.j2.getNomJoueur() + " gagne");
					end = true;
				}
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
