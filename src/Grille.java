import java.io.Serializable;


/**
 * @author Loïck Nosal
 * classe Grille qui modèlise le plateau de jeu.
 */
public class Grille implements Serializable{
	
	/**
	 * Taille en abcisse de la grille
	 */
	private int tailleX;
	/**
	 * Taille en ordonnee de la grille
	 */
	private int tailleY;
	/**
	 * nombre de cases totales de la grile
	 */
	private int nbCases;
	/**
	 * Tableau de cases qui composent la grille.
	 */
	private Case[][] tabCa;
	
	public int getTailleX() {
		return tailleX;
	}


	public int getTailleY() {
		return tailleY;
	}


	public int getNbCases() {
		return nbCases;
	}


	public Case[][] getTabCa() {
		return tabCa;
	}


	
	
	
	/**
	 * @param x Taille en abcisse de la grille
	 * @param y Taille en ordonnee de la grille
	 */
	public Grille(int x, int y) {
		if (x>100) {
			x = 100;
		}
		if (y>100) {
			y = 100;
		}
		if (x<5) {
			x = 5;
		}
		if(y<5) {
			y = 5;
		}
		this.tailleX = x;
		this.tailleY = y;
		this.nbCases = this.tailleX * this.tailleY;
		
		tabCa = new Case[tailleX][tailleY];
		
		for (int i = 0; i < tailleX; i++) {
	
			for (int j = 0; j < tailleY; j++) {
				
				tabCa[i][j] = new Case(i,j);
			}			
		}		
	}

	
	
	
}
