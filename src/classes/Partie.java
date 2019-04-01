package classes;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Partie{


	public abstract void sauvegarder(String dest) throws FileNotFoundException, IOException;
	
	public abstract Partie charger(String source) throws IOException, ClassNotFoundException;
	
	public abstract void lancerPartie() throws FileNotFoundException, IOException;
	
	public abstract void reprendrePartie() throws FileNotFoundException, IOException;
	

	
	
	
	
	

}
