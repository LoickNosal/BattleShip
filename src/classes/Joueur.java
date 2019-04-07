package classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Loïck Nosal
 *Classe qui modélise un Joueur de la bataille navale
 */
public class Joueur implements Serializable{
	
	/**
	 * Grille du joueur
	 */
	protected Grille gJoueur;
	/**
	 * liste des bateaux du joueur
	 */
	protected ArrayList<Bateau> listeBateau;
	/**
	 * nom du joueur
	 */
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

	
	/**
	 * Constructeur simple utile pour la classe de test
	 * @param g grille du joueur
	 */
	public Joueur(Grille g) {
		
		this.nomJoueur = "Joueurtest";
		this.gJoueur = g;
		this.listeBateau = new ArrayList<Bateau>();
	}
	
	/**
	 * @param g grille du joueur
	 * @param n nom du joueur
	 */
	public Joueur(Grille g, String n) {
		
		this.nomJoueur = n;
		this.gJoueur = g;
		this.listeBateau = new ArrayList<Bateau>();
		creationBateaux();
	}
	

	/**
	 * methode utile pour la classe de test
	 * @param b bateau à ajouter à la liste
	 */
	public void ajouterBateauListe(Bateau b) {
		
		this.listeBateau.add(b);
	}
	
	/**
	 * methode qui creer les 5 bateaux du joueur
	 * Les bateaux sont repris du jeu de bataille navale de base
	 */
	public void creationBateaux() {
		
		System.out.println("--Placement des bateaux de " + this.nomJoueur + "--");
		this.afficherGrillePlacementBateaux();
		Scanner sc = new Scanner(System.in);
		System.out.print("Voulez-vous placez vos bateaux de facon aléatoire ? oui/non : ");
		String reponse = sc.nextLine();
		if (reponse.equals("oui")) {
			Bateau porteAvion = new Bateau("porte-avion", gJoueur,5);
			listeBateau.add(porteAvion);
			Bateau croiseur = new Bateau("croiseur", gJoueur,4);
			listeBateau.add(croiseur);
			Bateau contreTorpilleur = new Bateau("contre torpilleur", gJoueur,3);
			listeBateau.add(contreTorpilleur);
			Bateau sousMarin = new Bateau("sous-marin", gJoueur,3);
			listeBateau.add(sousMarin);
			Bateau torpilleur = new Bateau("torpilleur", gJoueur,2);
			listeBateau.add(torpilleur);
		}else {
			System.out.print("orientation du porte-avion (taille 5) : ");
			boolean o = sc.nextBoolean();
			System.out.print("position x de depart du porte-avion : ");
			int posX = sc.nextInt();
			System.out.print("position y de depart du porte-avion : ");
			int posY = sc.nextInt();
			Bateau porteAvion = new Bateau("porte-avion", gJoueur, posX,posY,5,o);
			listeBateau.add(porteAvion);
			this.afficherGrillePlacementBateaux();
			System.out.print("orientation du croiseur (taille 4) : ");
			o = sc.nextBoolean();
			System.out.print("position x de depart du croiseur : ");
			posX = sc.nextInt();
			System.out.print("position y de depart du croiseur : ");
			posY = sc.nextInt();
			Bateau croiseur = new Bateau("croiseur", gJoueur, posX,posY,4,o);
			listeBateau.add(croiseur);
			this.afficherGrillePlacementBateaux();
			System.out.print("orientation du contre torpilleur (taille 3) : ");
			o = sc.nextBoolean();
			System.out.print("position x de depart du contre torpilleur : ");
			posX = sc.nextInt();
			System.out.print("position y de depart du contre torpilleur : ");
			posY = sc.nextInt();
			Bateau contreTorpilleur = new Bateau("contre torpilleur", gJoueur, posX,posY,3,o);
			listeBateau.add(contreTorpilleur);
			this.afficherGrillePlacementBateaux();
			System.out.print("orientation du sous-marin (taille 3) : ");
			o = sc.nextBoolean();
			System.out.print("position x de depart du sous-marin : ");
			posX = sc.nextInt();
			System.out.print("position y de depart du sous-marin : ");
			posY = sc.nextInt();
			Bateau sousMarin = new Bateau("sous-marin", gJoueur, posX,posY,3,o);
			listeBateau.add(sousMarin);
			this.afficherGrillePlacementBateaux();
			System.out.print("orientation du torpilleur (taille 2) : ");
			o = sc.nextBoolean();
			System.out.print("position x de depart du torpilleur : ");
			posX = sc.nextInt();
			System.out.print("position y de depart du torpilleur : ");
			posY = sc.nextInt();
			Bateau torpilleur = new Bateau("torpilleur", gJoueur, posX,posY,2,o);
			listeBateau.add(torpilleur);
			this.afficherGrillePlacementBateaux();
		}
		System.out.println("--Bateaux du joueur " + this.nomJoueur + " placés. Voici votre grille --");
		this.afficherGrillePlacementBateaux();
	}
	
	/**
	 * Methode pour replacer tout les bateaux du joueur
	 */
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
	
	
	/**
	 * Methode qui affiche les bateaux du joueur dans l'ordre
	 * de la liste (utile pour les tris)
	 */
	public void afficherBateau() {
		
		for(Bateau b : listeBateau) {
			System.out.println(b.toString());
		}
	}
	
	/**
	 * Methode pour tirer sur un autre joueur (ou sois même en mode solo)
	 * @param posX position x où tirer
	 * @param posY position y où tirer
	 * @param j joueur sur lequel tirer
	 */
	public void tirer(int posX, int posY, Joueur j) {
		
		if (posX > j.getgJoueur().getTailleX()-1 || posY > j.getgJoueur().getTailleY()-1) {
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.println("Impossible de tirer à l'exterieur de la grille. Retirez : ");
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(this.nomJoueur + " , position x où tirer : ");
			posX = sc.nextInt();
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(this.nomJoueur + " position y où tirer : ");
			posY = sc.nextInt();
			this.tirer(posX, posY, j);
			return;
		}
		if (j.gJoueur.getTabCa()[posX][posY].isEstVide() == false) {
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
		}else {
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.println("Vous avez déjà tiré sur cette case. Retirez : ");
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(this.nomJoueur + " , position x où tirer : ");
			posX = sc.nextInt();
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.print(this.nomJoueur + " position y où tirer : ");
			posY = sc.nextInt();
			this.tirer(posX, posY, j);
			return;
		}
	}
	
	
	/**
	 * permet de savoir si tout les bateaux du joueur ont ete coules
	 * @return true si le joueur n'a plus de bateaux en vie
	 */
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
			for (int i = 0; i < this.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.println("tout les bateaux ont ete coules");
		}
		return perdu;
	}	
	
	
	/**
	 * Methode de tri des bateaux en fonction de leur taille
	 */
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
	
	/**
	 * methode de tri des bateaux en fonction de leur poucentage d'impact
	 */
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
	
	
	/**
	 * permet de savoir si un bateau est présent sur une case ou non
	 * @param x position x à tester
	 * @param y position y à tester
	 * @return true si le bateau est présent sur cette case
	 */
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
	
	/**
	 * permet d'afficher la grille unique (seule), utilisé lors du placement
	 * des bateaux du joueur
	 */
	public void afficherGrillePlacementBateaux(){
		
		String s = "--Grille de " + this.nomJoueur + "--";
		System.out.println(s);
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
				if (this.bateauPresent(j, i) == true) {
					if (this.gJoueur.getTabCa()[j][i].isEstOccupe() == false) {
						System.out.print("X  ");
					}else {
						System.out.print("O  ");
					}
					
				}else {
					if (this.gJoueur.getTabCa()[j][i].isEstVide() == true) {
						System.out.print("#  ");
					}else {
						System.out.print("-  ");
					}
					
				}
				
			}
			System.out.print(i);
			System.out.println();
		}
	}
	
	/**
	 * methode qui permet d'afficher sa grille, une légende et la grille de son adversaire
	 * utilisé durant toute la partie.
	 * @param jo joueur adverse à afficher la grille (peut être sois-même)
	 */
	public void afficherGrilleJoueur(Joueur jo) {
		
		String s = "--Grille de " + jo.nomJoueur + "--";
		System.out.print(s);
		for (int i = 0; i < (this.gJoueur.getTailleX()*3)-s.length() + 60 + 1; i++) {
			System.out.print(" ");
		}

		System.out.println("--Grille de " + this.nomJoueur + "--");
		for (int i = 0; i < jo.gJoueur.getTailleX(); i++) {
			if(i>9) {
			 System.out.print(i+" ");
			}else {
				System.out.print(i+"  ");
			}	
		}
		
		System.out.print("                                                                ");
		
		for (int i = 0; i < this.gJoueur.getTailleX(); i++) {
			if(i>9) {
			 System.out.print(i+" ");
			}else {
				System.out.print(i+"  ");
			}	
		}
		
		System.out.println();
		for (int i = 0; i < jo.gJoueur.getTailleY(); i++) {
			for (int j = 0; j < jo.gJoueur.getTailleX(); j++) {
				if (jo.bateauPresent(j, i) == true) {
					if (jo.gJoueur.getTabCa()[j][i].isEstOccupe() == false) {
						System.out.print("X  ");
					}else {
						System.out.print("O  ");
					}
					
				}else {
					if (jo.gJoueur.getTabCa()[j][i].isEstVide() == true) {
						System.out.print("#  ");
					}else {
						System.out.print("-  ");
					}
					
				}
				
			}
				System.out.print(i);
				if (i == 0) {
					System.out.print("                   --Legendes--");
					System.out.print("                             ");
					
				}else if(i == 1) {
					System.out.print("               O : vos bateaux");
					System.out.print("                              ");
				}else if(i == 2) {
					System.out.print("               X : bateaux touchés");
					System.out.print("                          ");
				}else if(i == 3) {
					System.out.print("               - : cases inconnus");
					System.out.print("                           ");
				}else if(i == 4) {
					System.out.print("               # : cases vides sans bateau");
					System.out.print("                  ");
				}else if(i>9) {
					System.out.print("                                                           ");
				}else {
					System.out.print("                                                            ");
				}
				if (i<10) {
					System.out.print(i + "  ");
				}else {
					System.out.print(i + " ");
				}
				
				
				for (int j = 0; j < this.gJoueur.getTailleX(); j++) {
					if (this.bateauPresent(j, i) == true) {
						if (this.gJoueur.getTabCa()[j][i].isEstOccupe() == false) {
							System.out.print("X  ");
						}else {
							//Si "O" on voit les bateaux adverses
							//Si "-" on ne voit pas les bateaux adverses
							System.out.print("-  ");
						}
						
					}else {
						if (this.gJoueur.getTabCa()[j][i].isEstVide() == true) {
							System.out.print("#  ");
						}else {
							System.out.print("-  ");
						}
						
					}
					
				}
				
				System.out.println();
		}
		System.out.println();
	}
	
	
	
	

}
