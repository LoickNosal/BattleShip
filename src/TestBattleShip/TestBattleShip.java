package TestBattleShip;
import static org.junit.Assert.*;
import org.junit.Test;
import classes.*;

/**
 * @author Loïck Nosal
 *Classe de test du jeu Bataille Navale
 *Beaucoup de méthode (placement des bateaux par exemples)
 *ont été testé à la main car elle necessite des entrées et sorties consoles
 *et cela n'est pas adapté à Junit.
 *JUnit 4 est utilisé ici.
 */
public class TestBattleShip {

	@Test
	public void testCaseConstructeur() {
		Case c = new Case(0,0);
		assertEquals("la case x est 0", 0, c.getCaseX());
		assertEquals("la case y est 0", 0, c.getCaseY());
		assertEquals("la case n'est pas occupé", false, c.isEstOccupe());
		assertEquals("la case n'est pas vraiment vide car on a pas l'information", false, c.isEstVide());
	}
	
	@Test
	public void testCaseMethodes() {
		Case c = new Case(0,0);
		assertEquals("la case y n'est pas occupé", false, c.isEstOccupe());
		assertEquals("la case y n'est pas vraiment vide car on a pas l'information", false, c.isEstVide());
		c.occupation(true);
		c.vider(true);
		assertEquals("la case est occupé", true, c.isEstOccupe());
		assertEquals("la case est vraiment vide", true, c.isEstVide());
	}
	
	@Test
	public void testGrilleConstructeur() {
		Grille g = new Grille(10,10);
		assertEquals("la taille x est 10", 10, g.getTailleX());
		assertEquals("la taille y est 10", 10, g.getTailleY());
		assertEquals("la grille a 100 cases", 100, g.getNbCases());
	}
	
	@Test
	public void testGrilleCTropGrande() {
		Grille g = new Grille(200,200);
		assertEquals("la taille x est 100", 100, g.getTailleX());
		assertEquals("la taille y est 100", 100, g.getTailleY());
		assertEquals("la grille a 10000 cases", 10000, g.getNbCases());
	}
	@Test
	public void testGrilleCTropPetite() {
		Grille g = new Grille(1,1);
		assertEquals("la taille x est 5", 5, g.getTailleX());
		assertEquals("la taille y est 5", 5, g.getTailleY());
		assertEquals("la grille a 25 cases", 25, g.getNbCases());
	}

	@Test
	public void testConstructeurBateauCoordonees() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test", g, 0 , 0, 5, true);
		assertEquals("la position x de depart est 0", 0,b.getPosX());
		assertEquals("la position y de depart est 0", 0,b.getPosY());
		assertEquals("le bateau est ne vie", true,b.isEstEnVie());
		assertEquals("le nom du bateau est test", "test",b.getNom());
		assertEquals("la grille du bateau est g", g,b.getGri());
		assertEquals("la taille du bateau est 5", 5,b.getTaille());
		assertEquals("l'orientation du bateau est verticale (true)", true,b.isOrientation());
		assertEquals("le bateau a 5 points de vie", 5,b.getVie());
		
	}
	
	@Test
	public void testConstructeurBateauTropGrand() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test", g, 0 , 0, 10, true);
		assertEquals("la taille du bateau est 5", 5,b.getTaille());		
	}
	
	@Test
	public void testConstructeurBateauTropPetit() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test", g, 0 , 0, -5, true);
		assertEquals("la taille du bateau est 1", 1,b.getTaille());		
	}
	
	@Test
	public void testConstructeurBateauAleatoire() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test", g, 5);
		assertEquals("la taille du bateau est 5", 5,b.getTaille());	
		//retourne vrai si b.getPosX est dans l'intervalle [5-5;5+5] soit [0;10]
		assertEquals("la position x de depart est entre 0 et 10", 5,b.getPosX(),5);
		//retourne vrai si b.getPosX est dans l'intervalle [5-5;5+5] soit [0;10]
		assertEquals("la position y de depart est entre 0 et 10", 5,b.getPosY(),5);
	}
	
	@Test
	public void testPourcentageImpactBateau() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test", g, 5);
		//le 0.001 permet de savoir la precision pour comparer deux double
		assertEquals("le pourcentage d'impact du bateau est de 100% (pas touché)", 100.0,b.pourcentageImpact(),0.001);
		//on touche ensuite le bateau et on recalcule le pourcentage.
		b.touche(b.getPosX(), b.getPosY());
		assertEquals("le pourcentage d'impact du bateau est de 80%", 80.0,b.pourcentageImpact(),0.001);

	}
	
	@Test
	public void testBateauCoule() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test", g, 1);
		assertEquals("le bateau n'est pas coule", true,b.isEstEnVie());
		b.touche(b.getPosX(), b.getPosY());
		assertEquals("le bateau est coule", false,b.isEstEnVie());
	}
	
	@Test
	public void testJoueurBateaux() {
		Grille g = new Grille(10,10);
		//on test avec une IA qui dérive de joueur car les bateaux sont placés automatiquement
		IA j = new IA(g, "JoueurTest");
		assertEquals("tous les bateaux n'ont pas été coulés", false,j.aucunBateau());
		//on tire sur toutes les cases
		for (int i = 0; i < g.getTailleX(); i++) {
			for (int k = 0; k < g.getTailleY(); k++) {
				j.tirer(i,k,j);
			}
		}
		assertEquals("tous les bateaux ont été coulés", true,j.aucunBateau());
	}
	
	@Test
	public void testJoueurBateauPresent() {
		Grille g = new Grille(10,10);
		Joueur j = new Joueur(g);
		Bateau b = new Bateau("BateauTest", g, 0, 0, 5, true);
		j.ajouterBateauListe(b);
		assertEquals("aucun bateau sur cette case", false,j.bateauPresent(9, 9));
		assertEquals("bateau present sur cette case", true,j.bateauPresent(0, 0));
		
	}
	
	
	
	
	

}
