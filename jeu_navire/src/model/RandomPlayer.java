package model;

import java.util.Random;
import config.Config;


/**
 * Classe représentant un joueur aléatoire du jeu de bataille navale.
 * Un joueur possède une grille de jeu, une flotte de bateaux et un nom.
 */

public class RandomPlayer extends AbstractPlayer {

	private Random random;

	/**
	 * Constructeur de la classe.
	 * Initialise le joueur avec un nom, une grille de jeu vide et une flotte vide.
	 * @param grid La grille du joueur.
	 */
	public RandomPlayer(Grid grid) {
		super(grid, "Random");
		this.random = new Random();
		//this.addShipRandomLy();
	}

	/**
	 * constructeur sans argument
	 */
	public RandomPlayer(){
		super();
	}

	//getters and setters
	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	/**

    * Méthode  qui génère une position aléatoire pour un tir sur la grille de l'adversaire.
    * @return La position aléatoire générée.
    */
	public Position shoot(){
		int x = random.nextInt(this.grid.getDimension().getRows());
        int y = random.nextInt(this.grid.getDimension().getCols());
        return new Position(x, y);
	}
		
	
	/**
    Met à jour la visibilité des navires coulés de la flotte pour les rendre visibles.
    Parcourt chaque navire de la flotte, et si le navire est coulé, définit sa visibilité à true.
    */
	public void putShipVisible(){
		for(Ship ship : this.fleet){
			if(ship.isSank()){
				ship.setVisible(true);
			}
		}

	}
		
	

	
	
	
}
