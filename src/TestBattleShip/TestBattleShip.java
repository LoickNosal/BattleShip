package TestBattleShip;
import static org.junit.Assert.*;
import org.junit.Test;
import classes.*;

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

}
