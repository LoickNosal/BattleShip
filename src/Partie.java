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
	
	public Partie(Joueur joueur1, Joueur joueur2) {
		this.j1 = joueur1;
		this.j2 = joueur2;
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
	
	public void PartieVsIA() {
		Grille gIA = new Grille(j1.gJoueur.getTailleX(),j1.gJoueur.getTailleY());
		IA joueurIA = new IA(gIA,"IA");
		boolean end = false;
		Scanner sc = new Scanner(System.in);
		while(end == false) {
			System.out.print("joueur 1 , position x où tirer : ");
			int posX = sc.nextInt();
			System.out.print("joueur 1 , position y où tirer : ");
			int posY = sc.nextInt();
			j1.tirer(posX, posY, joueurIA);
			
			if (joueurIA.aucunBateau() == true) {
				System.out.println(this.j1.getNomJoueur() + " gagne");
				end = true;
			}
			
			if(end == false) {
				joueurIA.tirer(j1);
				//j1.afficherGrilleJoueur();
				joueurIA.afficherGrilleJoueur(j1);
				if (j1.aucunBateau() == true) {
					System.out.println("l'IA gagne");
					end = true;
				}
			}

		}
	}

}
