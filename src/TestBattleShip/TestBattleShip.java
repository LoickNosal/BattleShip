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
	public void testCasesGrille() {
		Grille g = new Grille(10,10);
		Case c[][] = g.getTabCa();
	}
	

}
