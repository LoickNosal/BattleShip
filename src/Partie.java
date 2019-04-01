import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Partie implements Serializable{
	
	private Joueur j1;
	private Joueur j2;
	private IA intelligence;
	
	//faire plusieurs constructeur
	public Partie(Joueur joueur1, Joueur joueur2) {
		this.j1 = joueur1;
		this.j2 = joueur2;
		this.intelligence = null;
	}
	public Partie() {
		this.j1 = null;
		this.j2 = null;
		this.intelligence = null;
		
	}
	
	public void sauvegarder(String dest) throws IOException {
		ObjectOutputStream d = new ObjectOutputStream(new FileOutputStream(dest));
		d.writeObject(this);
		d.close();
		System.out.println("sauvegarde effecutée");
	}
	
	public Partie charger(String source) throws IOException, ClassNotFoundException{
		
		ObjectInputStream di = new ObjectInputStream(new FileInputStream(source));
		Partie p = (Partie)(di.readObject());
		di.close();
		System.out.println("sauvegarde chargée");
		return p;
	}
	
	
	
	public void PartieSolo() {
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			System.out.print("position x où tirer : ");
			int posX = sc.nextInt();
			System.out.print("position y où tirer : ");
			int posY = sc.nextInt();
			j1.tirer(posX, posY, j1);
			j1.afficherGrilleJoueur();
			if (j1.aucunBateau() == true) {
				System.out.println("Fin de partie");
				end = true;
				return;
			}		
		}

	}
	
	public void PartieVsIA() throws IOException {
		Grille gIA = new Grille(j1.gJoueur.getTailleX(),j1.gJoueur.getTailleY());
		this.intelligence = new IA(gIA,"IA");
		boolean end = false;
		intelligence.afficherGrilleJoueur(j1);
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
			j1.tirer(posX, posY, intelligence);
			
			if (intelligence.aucunBateau() == true) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j1.getNomJoueur() + " gagne");
				end = true;
			}
			
			if(end == false) {
				intelligence.tirer(j1);
				//j1.afficherGrilleJoueur();
				intelligence.afficherGrilleJoueur(j1);
				if (j1.aucunBateau() == true) {
					for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println("l'IA gagne");
					end = true;
				}
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("test");
			}
		}
	}
	
	public void reprendrePartieIA() throws IOException {
		intelligence.afficherGrilleJoueur(j1);
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
			j1.tirer(posX, posY, intelligence);
			
			if (intelligence.aucunBateau() == true) {
				for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println(this.j1.getNomJoueur() + " gagne");
				end = true;
			}
			
			if(end == false) {
				intelligence.tirer(j1);
				//j1.afficherGrilleJoueur();
				intelligence.afficherGrilleJoueur(j1);
				if (j1.aucunBateau() == true) {
					for (int i = 0; i < this.j1.gJoueur.getTailleX()*3+10; i++) {
						System.out.print(" ");
					}
					System.out.println("l'IA gagne");
					end = true;
				}
			}
			System.out.print("voulez-vous enregistrer la partie ? oui/non : ");
			Scanner sc2 = new Scanner(System.in);
			String partie = sc2.nextLine();
			if (partie.equals("oui")) {
				this.sauvegarder("test");
			}
		}
	}

}
