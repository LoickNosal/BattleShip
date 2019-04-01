package TestBattleShip;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.*;

class TestBattleShip {

	@Test
	void test_Cases() {
		Case c = new Case(0,0);
		assertEquals("position x de la case", 0, c.getCaseX());
		assertEquals("position y de la case", 0, c.getCaseY());
		assertEquals("occupation de la case", false, c.isEstOccupe());
		c.occupation(true);
		assertEquals("occupation de la case apres changement", true, c.isEstOccupe());
	}
	
	@Test
	void test_Grille() {
		Grille g = new Grille(10,10);
		assertEquals("taille x de la grille", 10, g.getTailleX());
		assertEquals("taille y de la grille", 10, g.getTailleY());
		assertEquals("nombre de cases", 100, g.getNbCases());
	}
	
	@Test
	void test_Cases_Grille(){
		Grille g = new Grille(10,10);
		assertEquals("test case 0,0", false, g.getTabCa()[0][0].isEstOccupe());
		assertEquals("test case 6,3", false, g.getTabCa()[6][3].isEstOccupe());
		g.getTabCa()[6][3].occupation(true);
		assertEquals("test case 6,3 apres changement", true, g.getTabCa()[6][3].isEstOccupe());
	}
	
	@Test
	void test_Bateau_normal() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test",g, 0,0,3,true);
		assertEquals("test posX bateau", 0, b.getPosX());
		assertEquals("test posY bateau", 0, b.getPosY());
		assertEquals("test taille bateau", 3, b.getTaille());
		assertEquals("vivant", true, b.isEstEnVie());
		assertEquals("vie", 3, b.getVie());


		assertEquals("test orientation bateau", true, b.isOrientation());
		//positions avec bateau
		assertEquals("test case 0,0", true, b.getGri().getTabCa()[0][0].isEstOccupe());
		assertEquals("test case 0,1", true, b.getGri().getTabCa()[0][1].isEstOccupe());
		assertEquals("test case 0,2", true, b.getGri().getTabCa()[0][2].isEstOccupe());
		//position sans bateau
		assertEquals("test case 1,0", false, b.getGri().getTabCa()[1][0].isEstOccupe());
	}
	
	@Test
	void test_Bateau_hors_grille() {
		Grille g = new Grille(10,10);
		Bateau b = new Bateau("test",g, 10,9,3,true);
		//appelle de la methode replacer : saisir à nouveau orientation, posX et posY
		assertEquals("test posX bateau", 0, b.getPosX());
		assertEquals("test posY bateau", 0, b.getPosY());
		//appelle de la methode replacer : saisir à nouveau orientation, posX et posY
		Bateau b2 = new Bateau("test",g, -1,5,3,true);
		assertEquals("test posX bateau", 7, b2.getPosX());
		assertEquals("test posY bateau", 7, b2.getPosY());
	}
	//placer un bateau alors que l'emplacement est deja occupé

}
