import java.io.IOException;
import java.util.Scanner;

public class Principale {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		Grille g = new Grille(20,20);
//		Grille g2 = new Grille(10,10);
		Joueur j1 = new Joueur(g,"Loick");
//		Joueur j2 = new Joueur(g2,"Leandre");
		Partie p = new Partie(j1,j1);
	
//		
		//p.PartieSolo();
		p.PartieVsIA();
		
		
//		j1.afficherBateau();
//		j1.tirer(1, 6, j1);
//		j1.tirer(2, 6, j1);
//		j1.tirer(3, 6, j1);µµ
//		j1.tirer(4, 6, j1);
//		j1.tirer(5, 6, j1);
//		j1.sauvegarder("test");
//		Joueur j2 = j1.charger("test");
//		j2.afficherBateau();
		
//		Joueur j2 = new Joueur(10,10);
//		j2.afficherOrdreBateau();
//		j1.tirer(1, 3, j2);
//		j1.tirer(1, 4, j2);
//		j1.tirer(1, 5, j2);
//		j2.triBateauImpact();
//		j2.afficherOrdreBateau();
		

//		Bateau porteAvion = new Bateau("porte avion", gJoueur, 1,6,5,false);
//		Bateau croiseur = new Bateau("croiseur", gJoueur, 7,0,4,true);
//		Bateau contreTorpilleur = new Bateau("contre torpilleur", gJoueur, 7,8,3,false);
//		Bateau sousMarin = new Bateau("sous-marin", gJoueur, 1,3,3,true);
//		Bateau torpilleur = new Bateau("torpilleur", gJoueur, 2,1,2,false);
//		
//		listeBateau.add(porteAvion);
//		listeBateau.add(croiseur);
//		listeBateau.add(contreTorpilleur);
//		listeBateau.add(sousMarin);
//		listeBateau.add(torpilleur);

		
//		boolean end = false;
//		Scanner sc = new Scanner(System.in);
//		while(end == false) {
//			System.out.println("joueur 1 , position x où tirer : ");
//			int posX = sc.nextInt();
//			System.out.println("joueur 1 , position y où tirer : ");
//			int posY = sc.nextInt();
//			j1.tirer(posX, posY, j2);
//			
//			if (j2.aucunBateau() == true) {
//				System.out.println("joueur 1 gagne");
//				end = true;
//			}
//			
//			if(end == false) {
//				System.out.println("joueur 2 , position x où tirer : ");
//				posX = sc.nextInt();
//				System.out.println("joueur 2 , position y où tirer : ");
//				posY = sc.nextInt();
//				j2.tirer(posX, posY, j1);
//				
//				if (j1.aucunBateau() == true) {
//					System.out.println("joueur 2 gagne");
//					end = true;
//				}
//			}
//
//			
//	
//		}
		


	}

}
