package model;

import java.util.Random;

public class RandomPlayer extends AbstractPlayer {

	private Random random;



	//constructeur
	public RandomPlayer(Grid grid, String name) {
		super(grid, "Random");
		this.random = new Random();
	}

	//getters and setters



	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}



	/**

    Méthode qui génère une position aléatoire pour un tir sur la grille de l'adversaire.
    * @return La position aléatoire générée.
    */

	public Position shoot(){
		int x = random.nextInt(this.grid.getDimension().getRows());
        int y = random.nextInt(this.grid.getDimension().getCols());
        return new Position(x, y);
	}


	
	/**
	 * Place un navire aléatoirement sur la grille.
	 * s'exécute tant que le navire n'est pas bien placé
	 */
	public void addShipRandomLy() {
		boolean navirePlace = false;
		while (!navirePlace) {
			int x = random.nextInt(this.getGrid().getDimension().getRows());
			int y = random.nextInt(this.getGrid().getDimension().getCols());
			boolean estVertical = random.nextBoolean();
			boolean added = this.addShip(x, y, new Ship(5), estVertical); // modifier la taille du bateau
			if (added) {
				navirePlace = true;
			}
		}
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
