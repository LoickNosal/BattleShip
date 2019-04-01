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
			
		}else if (num == 2) {
			
		}else if (num == 3) {
			PartieIA p = new PartieIA();
			try {
				Scanner sc2 = new Scanner(System.in);
				System.out.print("voulez-vous charger la partie ? oui/non : ");
				String partie = sc2.nextLine();
				if (partie.equals("oui")) {
					p = p.charger("test");
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
