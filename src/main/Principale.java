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
				Scanner sc2 = new Scanner(System.in);
				System.out.print("voulez-vous charger la partie ? oui/non : ");
				String partie = sc2.nextLine();
				if (partie.equals("oui")) {
					p = p.charger("src\\Sauvegardes\\partieSolo");
					p.reprendrePartie();
				}else {
					Grille g = new Grille(10,10);
					Joueur j = new Joueur(g, "loick");
					p = new PartieSolo(j);
					p.lancerPartie();
				}
				sc2.close();
			} catch (IOException e) {
				System.out.println("probleme a l’ouverture du fichier");
				throw(e);
			}
		}else if (num == 2) {
			PartieDuo p = new PartieDuo();
			try {
				Scanner sc2 = new Scanner(System.in);
				System.out.print("voulez-vous charger la partie ? oui/non : ");
				String partie = sc2.nextLine();
				if (partie.equals("oui")) {
					p = p.charger("src\\Sauvegardes\\partieDuo");
					p.reprendrePartie();
				}else {
					Grille g = new Grille(10,10);
					Grille g2 = new Grille(10,10);
					Joueur j1 = new Joueur(g, "loick");
					Joueur j2 = new Joueur(g2, "Léandre");
					p = new PartieDuo(j1,j2);
					p.lancerPartie();
				}
				sc2.close();
			} catch (IOException e) {
				System.out.println("probleme a l’ouverture du fichier");
				throw(e);
			}
			
		}else if (num == 3) {
			PartieIA p = new PartieIA();
			try {
				Scanner sc2 = new Scanner(System.in);
				System.out.print("voulez-vous charger la partie ? oui/non : ");
				String partie = sc2.nextLine();
				if (partie.equals("oui")) {
					p = p.charger("src\\Sauvegardes\\partieIA");
					p.reprendrePartie();
				}else {
					Grille g = new Grille(10,10);
					Joueur j = new Joueur(g, "loick");
					p = new PartieIA(j);
					p.lancerPartie();
				}
				sc2.close();
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
