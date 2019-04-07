package classes;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author Loïck Nosal
 *classe qui dérive de Joueur représente une intelligence artificielle 
 *qui tire aléatoirement sur les cases et ne peut pas tirer deux fois sur la meme case
 */
public class IA extends Joueur implements Serializable {
	
	
	/**
	 * coordonne x maximum pour l'aléatoire
	 */
	private int maxX;
	/**
	 * coordonne y maximum pour l'aléatoire
	 */
	private int maxY;
	
	
	/**
	 * @param g grille de l'IA
	 * @param n nom de l'IA
	 */
	public IA(Grille g, String n) {
		
		super(g, n);
		this.maxX = this.gJoueur.getTailleX() - 1;
		this.maxY = this.gJoueur.getTailleY() - 1;
	}
	
	/**
	 * @param max nombre maximum à générer
	 * @return un nombre entre 0 et max
	 */
	public int nombreRandom(int max) {
		
		int x = (int)(Math.random() * (max+1));
		return x;
	}
	
	@Override
	public void creationBateaux() {
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
	}
	
	/**
	 * permet de tirer aleatoirement sur la grille d'une joueur adverse
	 * @param j joueur sur lequel tirer
	 */
	public void tirer(Joueur j) {
		int posX = nombreRandom(maxX);
		int posY = nombreRandom(maxY);
		boolean peutTirer = true;
		while(peutTirer == true) {
		if (j.gJoueur.getTabCa()[posX][posY].isEstVide() == false) {
			for (int i = 0; i < j.gJoueur.getTailleX()*3+10; i++) {
				System.out.print(" ");
			}
			System.out.println("L'IA tire en (" + posX + "," + posY + ")");
			if (j.gJoueur.getTabCa()[posX][posY].isEstOccupe() == true) {
				for(Bateau b : j.listeBateau) {
					b.touche(posX, posY);
				}
		
			}else {
				j.gJoueur.getTabCa()[posX][posY].vider(true); //on a l'info sur la case, on dit qu'elle 
				//est vraiment vide
				for (int i = 0; i < j.gJoueur.getTailleX()*3+10; i++) {
					System.out.print(" ");
				}
				System.out.println("l'IA n'a touché aucun bateau adverse");
			}	
			peutTirer = false;
		}else {
			posX = nombreRandom(maxX);
			posY = nombreRandom(maxY);
		}
	}

	}
	
	
	/* 
	 * permet d'afficher la grille du joueur et de l'IA
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
					System.out.print("                             "); //46 56 58
					
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
