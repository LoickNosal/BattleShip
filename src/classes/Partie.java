package classes;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Loïck Nosal
 * interface permettant de donner la structure des 3 modes de jeu (partie) différentes
 */
public interface Partie{


	/**
	 * Permet de sauvegarder la partie
	 * @param dest fichier où sauvegarder
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract void sauvegarder(String dest) throws FileNotFoundException, IOException;
	
	/**
	 * permet de charger une partie
	 * @param source fichier à charger
	 * @return la partie à charger
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
