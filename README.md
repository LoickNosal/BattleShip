# BattleShip
Bataille Navale java

Projet fait par Nosal Loïck classe S2E IUT Charlemagne Nancy
Lien du dépôt Git : 

Le jeu se déroule en console uniquement pour le moment.
Il y a trois modes de jeu : tout seul (jouer contre soi - même), à deux joueurs ou contre une intelligence artificielle.
L'intelligence artificielle est très basique pour le moment et se contente de tirer aléatoirement sur des cases. 
Il est toutefois impossible de tirer deux fois sur la même case.
L'IA place ces bateaux aléatoirement sur la grille de taille variable (de 5 à 100 cases en abscisse et en ordonée).
Le joueur peut placer ces bateaux "manuellement" en choisisant les positions sur la grille, ou aléatoirement si il préfère.

Ce projet comporte : des classes, une interface (Partie), de l'héritage (les différentes parties et IA), des exceptions qui sont attrapées principalement dans le main et dans les classes de partie, des entrées sorties avec sauvegarde, une belle sortie console avec la grille des deux joueurs et une legendes, des tests unitaires, une javadoc complète, un diagramme UML.
En option j'ai traité le multi-joueur et l'IA (bien que très basique elle est parfaitement fonctionnelle).
Je n'ai pas traité l'option de l'interface graphique ni des cases manquantes (terres).
Exécutez la classe Principale.java pour lancer le jeu

JUnit 4 est utilisé pour les tests
