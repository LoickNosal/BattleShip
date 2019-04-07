package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lo�ck Nosal 
 * Classe qui mod�lise les bateaux du jeu
 */
public class Bateau implements Serializable {

	/**
	 * nom du bateau
	 */
	private String nom;
	/**
	 * grille � laquelle le Bateau appartient
	 */
	private Grille gri;
	/**
	 * position x initiale du bateau (bord haut droit du bateau)
	 */
	private int posX;
	/**
	 * position y initiale du bateau (bord haut droit du bateau)
	 */
	private int posY;
	/**
	 * taille du bateau (en nombre de cases)
	 */
	private int taille;
	/**
	 * vie du bateau. Au d�part sa vie correspond au nombre de cases qu'il occupe
	 */
	private int vie;
	/**
	 * boolean permettant de savoir l'orientation du bateau le bateau est vertical
	 * si l'orientation est � true le bateau est horizontal si l'orientation est �
	 * false
	 */
	private boolean orientation;
	/**
	 * boolean indiquant si le bateau � �t� d�truit ou non
	 */
	private boolean estEnVie;

	/**
	 * Liste regroupant toutes les cases ou se situe le bateau
	 */
	ArrayList<Case> posBateau;

	public String getNom() {
		return nom;
	}

	public Grille getGri() {
		return gri;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getTaille() {
		return taille;
	}

	public int getVie() {
		return vie;
	}

	public boolean isOrientation() {
		return orientation;
	}

	public boolean isEstEnVie() {
		return estEnVie;
	}

	public ArrayList<Case> getPosBateau() {
		return posBateau;
	}

	/**
	 * @param n nom du bateau
	 * @param g grille sur laquelle se trouve le bateau
	 * @param x position x de d�part du bateau (bord haut droit)
	 * @param y position y de d�part du bateau (bord haut droit)
	 * @param t taille du bateau en nombre de cases
	 * @param o orientation du bateau
	 */
	public Bateau(String n, Grille g, int x, int y, int t, boolean o) {
		// la taille du bateau doit �tre comprise entre 1 et 5 cases maximum
		if (t > 5) {
			t = 5;
		} else if (t < 1) {
			t = 1;
		}
		// on initialise les param�tres ne n�cessitant pas de v�rifications
		this.estEnVie = true;
		this.nom = n;
		this.gri = g;
		this.taille = t;
		this.orientation = o;
		this.vie = this.taille;

		// On v�rifie si les cases sont deja occup�s par un bateau
		// ou si le bateau est hors de la grille

		boolean placementPossible = true;
		if (o == true) { // orientation verticale
			// test si hors grille
			for (int i = 0; i < taille; i++) {

				if (x > gri.getTailleX() - 1 || y + i > gri.getTailleY() - 1 || x < 0 || y < 0) {
					System.out.println("placement du " + this.nom + " impossible car hors grille");
					placementPossible = false;
					this.replacer();
					return; // break tout le constructeur
				}
			}
			// test si un bateau est d�j� pr�sent sur l'une des cases
			for (int i = 0; i < taille; i++) {

				if (gri.getTabCa()[x][y + i].isEstOccupe() == true) {
					System.out.println("placement du " + this.nom + " impossible car deja bateau");
					placementPossible = false;
					this.replacer();
					return;
				}

			}

		} else if (o == false) { // orientation horizontale
			// test si hors grille
			for (int i = 0; i < taille; i++) {
				if (y > gri.getTailleY() - 1 || x + i > gri.getTailleX() - 1 || x < 0 || y < 0) {
					System.out.println("placement du " + this.nom + " impossible car hors grille");
					placementPossible = false;
					this.replacer();
					return;
				}
			}
			// test si un bateau est d�j� pr�sent sur l'une des cases
			for (int i = 0; i < taille; i++) {

				if (gri.getTabCa()[x + i][y].isEstOccupe() == true) {
					System.out.println("placement du " + this.nom + " impossible car deja bateau");
					placementPossible = false;
					this.replacer();
					return;
				}

			}
		}
		// si le placement est possible (pas sur des cases deja occup�es ni hors de la
		// grille)
		if (placementPossible == true) {

			this.posX = x;
			this.posY = y;
			this.posBateau = new ArrayList<Case>();

			if (o == true) { // orientation verticale
				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x][y + i].occupation(true); // on change l'occupation de la grille

				}

				for (int i = this.posY; i < this.taille + this.posY; i++) {

					this.posBateau.add(new Case(posX, i)); // on indique les positions du bateau
				}

			} else if (o == false) { // orientation horizontale

				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x + i][y].occupation(true); // on change l'occupation de la grille
				}

				for (int i = this.posX; i < this.taille + this.posX; i++) {

					this.posBateau.add(new Case(i, posY)); // on indique les positions du bateau
				}
			}
			System.out.println("placement du " + this.nom + " effectu�");
		}
	}

	/**
	 * Constructeur avec placement al�atoire du bateau
	 * @param n nom du bateau
	 * @param g grille du bateau
	 * @param t taille du bateau
	 */
	public Bateau(String n, Grille g, int t) {
		
		if (t > 5) {
			t = 5;
		} else if (t < 1) {
			t = 1;
		}

		this.estEnVie = true;
		this.nom = n;
		this.gri = g;
		this.taille = t;
		this.vie = this.taille;
		int x, y;
		int orien = nombreRandom(1);
		boolean o;
		if (orien == 1) {
			o = true;
			x = nombreRandom(this.gri.getTailleX() - 1);
			y = nombreRandom(this.gri.getTailleY() - this.taille - 1);
		} else {
			o = false;
			x = nombreRandom(this.gri.getTailleX() - this.taille - 1);
			y = nombreRandom(this.gri.getTailleY() - 1);
		}

		boolean placementPossible = true;
		if (o == true) { // orientation verticale
			// test si un bateau est d�j� pr�sent sur l'une des cases
			for (int i = 0; i < taille; i++) {

				if (gri.getTabCa()[x][y + i].isEstOccupe() == true) {
					placementPossible = false;
					this.replacerAleatoire();
					return;
				}

			}

		} else if (o == false) { // orientation horizontale
			// test si un bateau est d�j� pr�sent sur l'une des cases
			for (int i = 0; i < taille; i++) {

				if (gri.getTabCa()[x + i][y].isEstOccupe() == true) {
					placementPossible = false;
					this.replacerAleatoire();
					return;
				}

			}
		}
		// si le placement est possible (pas sur des cases deja occup�es ni hors de la
		// grille)
		if (placementPossible == true) {

			this.posX = x;
			this.posY = y;
			this.posBateau = new ArrayList<Case>();

			if (o == true) { // orientation verticale
				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x][y + i].occupation(true); // on change l'occupation de la grille

				}

				for (int i = this.posY; i < this.taille + this.posY; i++) {

					this.posBateau.add(new Case(posX, i)); // on indique les positions du bateau
				}

			} else if (o == false) { // orientation horizontale

				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x + i][y].occupation(true); // on change l'occupation de la grille
				}

				for (int i = this.posX; i < this.taille + this.posX; i++) {

					this.posBateau.add(new Case(i, posY)); // on indique les positions du bateau
				}
			}
		}

	}

	/**
	 * @param max nombre maximum g�n�r�
	 * @return un nombre al�atoire entre 0 et max
	 */
	public int nombreRandom(int max) {
		
		int x = (int) (Math.random() * (max + 1));
		return x;
	}

	/**
	 * Methode qui reinitialise les cases occup�s par le bateau methode appeller
	 * dans repositioner bateau car toutes les positions doivent etre remise � zero
	 */
	public void reinitialiserPos() {
		// on indique que toutes les cases de la grille anciennement occup�es par le
		// bateau
		// redeviennent non occup�es
		if (this.orientation == true) {
			for (int i = 0; i < taille; i++) {
				gri.getTabCa()[posX][posY + i].occupation(false);

			}
		} else if (this.orientation == false) {

			for (int i = 0; i < taille; i++) {
				gri.getTabCa()[posX + i][posY].occupation(false);

			}
		}

	}

	/**
	 * Methode qui permet de replacer les bateaux aleatoirement si
	 * le placement ne convient pas
	 */
	public void replacerAleatoire() {
		
		int x, y;
		int orien = nombreRandom(1);
		boolean o;
		if (orien == 1) {
			o = true;
			x = nombreRandom(this.gri.getTailleX() - 1);
			y = nombreRandom(this.gri.getTailleY() - this.taille - 1);
		} else {
			o = false;
			x = nombreRandom(this.gri.getTailleX() - this.taille - 1);
			y = nombreRandom(this.gri.getTailleY() - 1);
		}

		// m�me instructions que le constructeurs avec m�me v�rifications.

		boolean placementPossible = true;
		if (o == true) { // orientation verticale
			for (int i = 0; i < taille; i++) {
				if (gri.getTabCa()[x][y + i].isEstOccupe() == true) {
					placementPossible = false;
					this.replacerAleatoire(); // r�cursivit� de la m�thode
					return;
				}
			}
		} else if (o == false) { // orientation horizontale
			for (int i = 0; i < taille; i++) {
				if (gri.getTabCa()[x + i][y].isEstOccupe() == true) {
					placementPossible = false;
					this.replacerAleatoire(); // r�cursivit� de la m�thode
					return;
				}

			}
		}
		// si le placement est possible, meme instructions que dans le constructeur
		if (placementPossible == true) {

			this.posX = x;
			this.posY = y;
			this.orientation = o;
			this.posBateau = new ArrayList<Case>();

			if (o == true) {
				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x][y + i].occupation(true);
				}

				for (int i = this.posY; i < this.taille + this.posY; i++) {
					this.posBateau.add(new Case(posX, i));
				}

			} else if (o == false) {

				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x + i][y].occupation(true);
				}

				for (int i = this.posX; i < this.taille + this.posX; i++) {
					this.posBateau.add(new Case(i, posY));
				}
			}
		}

	}

	/**
	 * Methode qui appel�e si le placement est impossible ou pour pouvoir replacer
	 * ses bateaux comme on veut la m�thode est globalement identique aux
	 * instructions du constructeurs M�thode r�cursive qui peut s'appeller elle m�me
	 */
	public void replacer() {

		// permet de lire la nouvelle orientation, posX et posY de d�part
		Scanner sc = new Scanner(System.in);
		System.out.print("orientation du " + this.nom + " (taille " + this.taille + ") : ");
		boolean o = sc.nextBoolean();
		System.out.print("position x de depart du " + this.nom + ": ");
		int x = sc.nextInt();
		System.out.print("position y de depart du " + this.nom + ": ");
		int y = sc.nextInt();

		// m�me instructions que le constructeurs avec m�me v�rifications.

		boolean placementPossible = true;
		if (o == true) { // orientation verticale
			for (int i = 0; i < taille; i++) {
				if (x > gri.getTailleX() - 1 || (y + i) > gri.getTailleY() - 1 || x < 0 || y < 0) {
					System.out.println("placement du " + this.nom + " impossible car hors grille");
					placementPossible = false;
					this.replacer(); // r�cursivit� de la m�thode
					return;
				}
			}
			for (int i = 0; i < taille; i++) {
				if (gri.getTabCa()[x][y + i].isEstOccupe() == true) {
					System.out.println("placement du " + this.nom + " impossible car deja bateau");
					placementPossible = false;
					this.replacer(); // r�cursivit� de la m�thode
					return;
				}
			}
		} else if (o == false) { // orientation horizontale
			for (int i = 0; i < taille; i++) {
				if (y > gri.getTailleY() - 1 || x + i > gri.getTailleX() - 1 || x < 0 || y < 0) {
					System.out.println("placement du " + this.nom + " impossible car hors grille");
					placementPossible = false;
					this.replacer(); // r�cursivit� de la m�thode
					return;
				}
			}
			for (int i = 0; i < taille; i++) {
				if (gri.getTabCa()[x + i][y].isEstOccupe() == true) {
					System.out.println("placement du " + this.nom + " impossible car deja bateau");
					placementPossible = false;
					this.replacer(); // r�cursivit� de la m�thode
					return;
				}

			}
		}
		// si le placement est possible, meme instructions que dans le constructeur
		if (placementPossible == true) {

			this.posX = x;
			this.posY = y;
			this.orientation = o;
			this.posBateau = new ArrayList<Case>();

			if (o == true) {
				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x][y + i].occupation(true);
				}

				for (int i = this.posY; i < this.taille + this.posY; i++) {
					this.posBateau.add(new Case(posX, i));
				}

			} else if (o == false) {

				for (int i = 0; i < taille; i++) {
					gri.getTabCa()[x + i][y].occupation(true);
				}

				for (int i = this.posX; i < this.taille + this.posX; i++) {
					this.posBateau.add(new Case(i, posY));
				}
			}
			System.out.println("placement du " + this.nom + " effectu�");
		}

	}

	/**
	 * methode appell�e pour savoir si le bateau est touch� ou non
	 * 
	 * @param x position x o� l'ennemi tire
	 * @param y position y o� l'ennemi tire
	 */
	public void touche(int x, int y) {

		for (Case c : this.posBateau) {
			if (c.getCaseX() == x && c.getCaseY() == y) {
				for (int i = 0; i < this.gri.getTailleX() * 3 + 10; i++) {
					System.out.print(" ");
				}
				System.out.println("bateau " + this.nom + " touch� en (" + x + "," + y + ")");
				gri.getTabCa()[x][y].occupation(false);
				// on r�duit la vie du bateau de 1 car la case est touch�
				this.vie -= 1;
				// on test si tout le bateau est d�truit ou non
				gri.getTabCa()[posX][posY].vider(true);
				this.coule();
				return;
			}
		}

	}

	/**
	 * m�thode qui permet de savoir si toute les cases du bateaux ont ete touch�
	 */
	public void coule() {
		// si toutes les cases sont d�truites, le bateau est coul�
		if (this.vie <= 0) {
			this.estEnVie = false;
			for (int i = 0; i < this.gri.getTailleX() * 3 + 10; i++) {
				System.out.print(" ");
			}
			System.out.println("bateau " + this.nom + " coul�");
		}
	}

	/**
	 * m�thode qui permet de calcul� le pourcentage d'impact du bateau en fonction
	 * de ses cases d�truites Si il n'a pas �t� touch� le pourcentage est de 100.0
	 * 
	 * @return pourcentage d'impact du bateau
	 */
	public double pourcentageImpact() {

		double d = ((double) this.vie / (double) this.taille) * 100;
		return d;
	}

	/**
	 * red�finition de la m�thode toString On affiche des informations sur le bateau
	 * telles que son nom, sa taille, ses points de vie, s'il est d�truit ou non,
	 * son orientation, et les cases qu'il occupe sur la grille.
	 * 
	 * @return informations sur le bateau
	 */
	public String toString() {
		String cases = "";
		for (Case c : this.posBateau) {
			cases = cases + "(" + c.getCaseX() + "," + c.getCaseY() + ") ";
		}

		String orien;
		if (this.orientation == true) {
			orien = "verticale";
		} else {
			orien = "horizontale";
		}
		String v;
		if (this.estEnVie) {
			v = "en vie";
		} else {
			v = "detruit";
		}
		String s = this.nom + " de taille : " + this.taille + " et a " + this.vie + " points de vie et est " + v
				+ " a une orientation " + orien + " occupe les cases " + cases;

		return s;
	}

}
