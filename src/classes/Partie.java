package classes;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Lo�ck Nosal
 * interface permettant de donner la structure des 3 modes de jeu (partie) diff�rentes
 */
public interface Partie{


	/**
	 * Permet de sauvegarder la partie
	 * @param dest fichier o� sauvegarder
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract void sauvegarder(String dest) throws FileNotFoundException, IOException;
	
	/**
	 * permet de charger une partie
	 * @param source fichier � charger
	 * @return la partie � charger
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public abstract Partie charger(String source) throws IOException, ClassNotFoundException;
	
	/**
	 * permet de lancer une partie
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public abstract void lancerPartie() throws FileNotFoundException, IOException, ClassNotFoundException;
	
	/**
	 * permet de reprendre une partie sauvegarder
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract void reprendrePartie() throws FileNotFoundException, IOException;
	

	
	
	
	
	

}
