import java.io.Serializable;
import java.util.ArrayList;


public class IA extends Joueur implements Serializable {
	
	private int maxX;
	private int maxY;
	
	public IA(Grille g, String n) {
		super(g, n);
		this.maxX = this.gJoueur.getTailleX() - 1;
		this.maxY = this.gJoueur.getTailleY() - 1;
	}
	
	public int nombreRandom(int max) {
		int x = (int)(Math.random() * (max+1));
		return x;
	}
	
	public void tirer(Joueur j) {
		int posX = nombreRandom(maxX);
		int posY = nombreRandom(maxY);
		boolean peutTirer = true;
		while(peutTirer == true) {
		if (j.gJoueur.getTabCa()[posX][posY].isEstVide() == false) {
			System.out.println("                                            L'IA tire en (" + posX + "," + posY + ")");
			if (j.gJoueur.getTabCa()[posX][posY].isEstOccupe() == true) {
				for(Bateau b : j.listeBateau) {
					b.touche(posX, posY);
				}
		
			}else {
				j.gJoueur.getTabCa()[posX][posY].vider(true); //on a l'info sur la case, on dit qu'elle 
				//est vraiment vide
				System.out.println("                                            l'IA n'a touché aucun bateau");
			}	
			peutTirer = false;
		}else {
			posX = nombreRandom(maxX);
			posY = nombreRandom(maxY);
		}
	}

	}
	
	public void afficherGrilleJoueur(Joueur jo) {
		for (int i = 0; i < (jo.gJoueur.getTailleX()*3)/2; i++) {
			System.out.print(" ");
		}
		System.out.print("--Grille de " + jo.nomJoueur + "--");
		for (int i = 0; i < (this.gJoueur.getTailleX()*3)/2 + (jo.gJoueur.getTailleX()*3)/2 + 60; i++) {
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
		
		System.out.print("                                                              ");
		
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
					System.out.print("                 --Legendes--");
					System.out.print("                             ");
					
				}else if(i == 1) {
					System.out.print("             O : vos bateaux");
					System.out.print("                              ");
				}else if(i == 2) {
					System.out.print("             X : vos bateaux touchés");
					System.out.print("                      ");
				}else if(i == 3) {
					System.out.print("             - : cases inconnus");
					System.out.print("                           ");
				}else if(i == 4) {
					System.out.print("             # : cases vides sans bateau");
					System.out.print("                  ");
				}else if(i>9) {
					System.out.print("                                                         ");
				}else {
					System.out.print("                                                          ");
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
				
				System.out.println();
		}
	}



}
