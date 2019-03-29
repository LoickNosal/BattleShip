import java.io.Serializable;

/**
 * @author Loïck Nosal
 * Classe Case modèlisant une case de la grille de jeu.
 */
public class Case implements Serializable{
	
	
	/**
	 * position x de la case.
	 */
	private int CaseX;
	/**
	 * position y de la case.
	 */
	private int CaseY;
	/**
	 * indique si la case est occupé (par un bateau)
	 * Si un la case contient un bateau mais que le bateau est touché, alors
	 * la case n'est plus considéré comme occupé
	 */
	private boolean estOccupe;
	/**
	 * indique si la case est vraiment vide, c'est à dire s'il n'y a pas de bateau 
	 * sur cette case ( on ne peut le savoir qu'après avoir tirer sur la case).
	 */
	private boolean estVraimentVide;
	
	public int getCaseX() {
		return CaseX;
	}

	public int getCaseY() {
		return CaseY;
	}

	public boolean isEstOccupe() {
		return estOccupe;
	}
	
	public boolean isEstVide() {
		return estVraimentVide;
	}

	
	
	
	
	/**
	 * @param x position x de la case.
	 * @param y position y de la case.
	 */
	public Case(int x, int y) {
		this.CaseX = x;
		this.CaseY = y;
		//la case n'est pas occupé à l'initialisation
		this.estOccupe = false;
		//la case n'est pas vraiment à l'initialisation car on a pas d'information dessus.
		this.estVraimentVide = false;
		
	}
	
	/**
	 * permet de changer l'occupation de la case
	 * @param b true si la case est occupée
	 */
	public void occupation(boolean b) {
		
		this.estOccupe = b;
	}
	
	/**
	 * permet de changer l'etat de la case
	 * @param b true si la case est vide
	 */
	public void vider(boolean b) {
		this.estVraimentVide = b;
	}
	


}
