import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur implements Serializable{
	
	protected Grille gJoueur;
	protected ArrayList<Bateau> listeBateau;
	protected String nomJoueur;
	
	public String getNomJoueur() {
		return nomJoueur;
	}
	public Grille getgJoueur() {
		return gJoueur;
	}
	public ArrayList<Bateau> getListeBateau() {
		return listeBateau;
	}

	
	
	public Joueur(Grille g, String n) {
		this.nomJoueur = n;
		this.gJoueur = g;
		this.listeBateau = new ArrayList<Bateau>();
		creationBateaux();
	}
	
	public void creationBateaux() {
		System.out.println("--Placement des bateaux de " + this.nomJoueur + "--");
		afficherGrilleJoueur();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("orientation du porte-avion (taille 5) : ");
		boolean o = sc.nextBoolean();
		System.out.print("position x de depart du porte-avion : ");
		int posX = sc.nextInt();
		System.out.print("position y de depart du porte-avion : ");
		int posY = sc.nextInt();
		Bateau porteAvion = new Bateau("porte-avion", gJoueur, posX,posY,5,o);
		listeBateau.add(porteAvion);
		afficherGrilleJoueur();
		System.out.print("orientation du croiseur (taille 4) : ");
		o = sc.nextBoolean();
		System.out.print("position x de depart du croiseur : ");
		posX = sc.nextInt();
		System.out.print("position y de depart du croiseur : ");
		posY = sc.nextInt();
		Bateau croiseur = new Bateau("croiseur", gJoueur, posX,posY,4,o);
		listeBateau.add(croiseur);
		afficherGrilleJoueur();
		System.out.print("orientation du contre torpilleur (taille 3) : ");
		o = sc.nextBoolean();
		System.out.print("position x de depart du contre torpilleur : ");
		posX = sc.nextInt();
		System.out.print("position y de depart du contre torpilleur : ");
		posY = sc.nextInt();
		Bateau contreTorpilleur = new Bateau("contre torpilleur", gJoueur, posX,posY,3,o);
		listeBateau.add(contreTorpilleur);
		afficherGrilleJoueur();
		System.out.print("orientation du sous-marin (taille 3) : ");
		o = sc.nextBoolean();
		System.out.print("position x de depart du sous-marin : ");
		posX = sc.nextInt();
		System.out.print("position y de depart du sous-marin : ");
		posY = sc.nextInt();
		Bateau sousMarin = new Bateau("sous-marin", gJoueur, posX,posY,3,o);
		listeBateau.add(sousMarin);
		afficherGrilleJoueur();
		System.out.print("orientation du torpilleur (taille 2) : ");
		o = sc.nextBoolean();
		System.out.print("position x de depart du torpilleur : ");
		posX = sc.nextInt();
		System.out.print("position y de depart du torpilleur : ");
		posY = sc.nextInt();
		Bateau torpilleur = new Bateau("torpilleur", gJoueur, posX,posY,2,o);
		listeBateau.add(torpilleur);

		System.out.println("--Bateaux du joueur " + this.nomJoueur + " placés--");
	}
	public void replacerBateaux() {
		System.out.println("--Replacement des bateau de " + this.nomJoueur + "--");
		for(Bateau b : listeBateau) {
			b.reinitialiserPos();
		}
		for (Bateau b : listeBateau) {
			b.replacer();
		}
		System.out.println("--Bateaux du joueur " + this.nomJoueur + " placés--");
	}
	
	public void afficherBateau() {
		for(Bateau b : listeBateau) {
			System.out.println(b.toString());
		}
	}
	
	public void tirer(int posX, int posY, Joueur j) {
		for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
			System.out.print(" ");
		}
		System.out.println(this.nomJoueur + " tire en (" + posX + "," + posY + ")");
		if (j.gJoueur.getTabCa()[posX][posY].isEstOccupe() == true) {
			for(Bateau b : j.listeBateau) {
				b.touche(posX, posY);
			}
			
			
		}else {
			j.gJoueur.getTabCa()[posX][posY].vider(true); //on a l'info sur la case, on dit qu'elle 
			//est vraiment vide
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.println(this.nomJoueur + " n'a touché aucun bateau adverse");
		}
		
	}
	
	public boolean aucunBateau() {
		boolean perdu = false;
		for(Bateau b : this.listeBateau) {
			if (b.isEstEnVie() == true) {
				perdu = false;
				break;
			}else {
				perdu = true;
			}
		}
		if (perdu) {
			System.out.println("tout les bateaux adverses ont ete coules");
		}
		return perdu;
	}
	
	public void afficherOrdreBateau() {
		for(Bateau b : this.listeBateau) {
			System.out.println(b.getNom());
		}
	}
	
	public void triBateauTaille() {
		ArrayList<Bateau> lf = new ArrayList<Bateau>();	
		while(this.listeBateau.isEmpty() == false) {
			int t = 0;
			Bateau ba = null;
			int indice = 0;
			int parcours = 0;
			for(Bateau b : this.listeBateau) {
				if (b.getTaille()>t) {
					t = b.getTaille();
					ba = b;
					indice = parcours;
				}
				parcours +=1;
			}
			this.listeBateau.remove(indice);
			lf.add(ba);
		}	
		this.listeBateau = lf;
	}
	
	public void triBateauImpact() {
		ArrayList<Bateau> lf = new ArrayList<Bateau>();	
		while(this.listeBateau.isEmpty() == false) {
			double t = -1;
			Bateau ba = null;
			int indice = 0;
			int parcours = 0;
			for(Bateau b : this.listeBateau) {
				if (b.pourcentageImpact()>t) {
					t = b.pourcentageImpact();
					ba = b;
					indice = parcours;
				}
				parcours +=1;
			}
			this.listeBateau.remove(indice);
			lf.add(ba);
		}	
		this.listeBateau = lf;
	}
	
	public boolean bateauPresent(int x, int y) {
		boolean present = false;
		for (Bateau b : listeBateau) {
			for(Case c : b.getPosBateau())
			if (c.getCaseX() == x && c.getCaseY() == y) {
				present = true;
				break;
			}
		}
		return present;
	}
	
	public void afficherGrilleJoueur() {
		System.out.println("      --Grille de " + this.nomJoueur + "--");
		for (int i = 0; i < this.gJoueur.getTailleX(); i++) {
			if(i>9) {
			 System.out.print(i+" ");
			}else {
				System.out.print(i+"  ");
			}	
		}
		System.out.println();
		for (int i = 0; i < this.gJoueur.getTailleY(); i++) {
			for (int j = 0; j < this.gJoueur.getTailleX(); j++) {
				if (bateauPresent(j, i) == true) {
					if (gJoueur.getTabCa()[j][i].isEstOccupe() == false) {
						System.out.print("X  ");
					}else {
						System.out.print("O  ");
					}
					
				}else {
					if (gJoueur.getTabCa()[j][i].isEstVide() == true) {
						System.out.print("#  ");
					}else {
						System.out.print("-  ");
					}
					
				}
				
			}
			
			if (i == 0) {
				System.out.print(i);
				System.out.println("                 --Legendes--");
				
			}else if(i == 1) {
				System.out.print(i);
				System.out.println("             O : vos bateaux");
			}else if(i == 2) {
				System.out.print(i);
				System.out.println("             X : vos bateaux touchés");
			}else if(i == 3) {
				System.out.print(i);
				System.out.println("             - : cases inconnus");
			}else if(i == 4) {
				System.out.print(i);
				System.out.println("             # : cases vides sans bateau");
			}else {
				System.out.println(i);
			}
			
		}
	}
	
	
	
	

}
