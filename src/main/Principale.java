package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import classes.*;

public class Principale {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		

	
		System.out.println("---------- Bataille Navale NOSAL Loïck S2E ---------- ");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Partie 1 joueur (contre soi-même) ");
		System.out.println("2) Partie 2 joueurs ");
		System.out.println("3) Partie VS l'IA ");
		System.out.println();
		System.out.print("Selectionnez une partie (1,2 ou 3) : ");
		int num = sc.nextInt();
		if (num == 1) {
			PartieSolo p = new PartieSolo();
			try {
				sc.nextLine();
				System.out.print("voulez-vous charger la partie ? oui/non : ");
				String partie = sc.nextLine();
				if (partie.equals("oui")) {
					p = p.charger("src\\Sauvegardes\\partieSolo");
					p.reprendrePartie();
				}else {
					System.out.print("Taille de la grille en X (de 5 à 100) : ");
					int tailleGX = sc.nextInt();
					System.out.print("Taille de la grille en Y (de 5 à 100) : ");
					int tailleGY = sc.nextInt();
					sc.nextLine();
					System.out.print("Nom du joueur : ");
					String nomJ = sc.nextLine();
					Grille g = new Grille(tailleGX,tailleGY);
			 		Joueur j = new Joueur(g, nomJ);
					p = new PartieSolo(j);
					p.lancerPartie();
				}
				sc.close();
			} catch (IOException e) {
				System.out.println("probleme a l’ouverture du fichier");
				throw(e);
			}
		}else if (num == 2) {
			PartieDuo p = new PartieDuo();
			try {
				sc.nextLine();
				System.out.print("voulez-vous charger la partie ? oui/non : ");
				String partie = sc.nextLine();
				if (partie.equals("oui")) {
					p = p.charger("src\\Sauvegardes\\partieDuo");
					p.reprendrePartie();
				}else {
					System.out.print("Taille de la grille en X (de 5 à 100) : ");
					int tailleGX = sc.nextInt();
					System.out.print("Taille de la grille en Y (de 5 à 100) : ");
					int tailleGY = sc.nextInt();
					sc.nextLine();
					System.out.print("Nom du joueur 1 : ");
					String nomJ1 = sc.nextLine();
					System.out.print("Nom du joueur 2 : ");
					String nomJ2 = sc.nextLine();
					Grille g = new Grille(tailleGX,tailleGY);
					Grille g2 = new Grille(tailleGX,tailleGY);
					Joueur j1 = new Joueur(g, nomJ1);
					Joueur j2 = new Joueur(g2, nomJ2);
					p = new PartieDuo(j1,j2);
					p.lancerPartie();
				}
				sc.close();
			} catch (IOException e) {
				System.out.println("probleme a l’ouverture du fichier");
				throw(e);
			}
			
		}else if (num == 3) {
			PartieIA p = new PartieIA();
			try {
				sc.nextLine();
				System.out.print("voulez-vous charger la partie ? oui/non : ");
				String partie = sc.nextLine();
				if (partie.equals("oui")) {
					p = p.charger("src\\Sauvegardes\\partieIA");
					p.reprendrePartie();
				}else {
					System.out.print("Taille de la grille en X (de 5 à 100) : ");
					int tailleGX = sc.nextInt();
					System.out.print("Taille de la grille en Y (de 5 à 100) : ");
					int tailleGY = sc.nextInt();
					sc.nextLine();
					System.out.print("Nom du joueur : ");
					String nomJ = sc.nextLine();
					Grille g = new Grille(tailleGX,tailleGY);
					Joueur j = new Joueur(g, nomJ);
					p = new PartieIA(j);
					p.lancerPartie();
				}
				sc.close();
			} catch (IOException e) {
				System.out.println("probleme a l’ouverture du fichier");
				throw(e);
			}
			
		}else {
			System.out.println("numéro de partie incorrect");
		}
		

		
		
		sc.close();
		
	}
	
	

}
