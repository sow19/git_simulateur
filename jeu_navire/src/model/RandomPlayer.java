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



	//cette méthode permet au joueur de choisir une position alétoire

	public Position shoot(){
		int x = random.nextInt(this.grid.getDimension().getRows());
        int y = random.nextInt(this.grid.getDimension().getCols());
        return new Position(x, y);
	}


	//cette méthode permet au joueur de placer ses navires de façons aléatoire

	public boolean addShipRandomLy() {
			boolean navirePlace = false;
			while (!navirePlace) {
				int x = random.nextInt(this.getGrid().getDimension().getRows());
				int y = random.nextInt(this.getGrid().getDimension().getCols());
				boolean estVertical = random.nextBoolean();
				this.addShip(x, y, new Ship(5), estVertical); // modifier la taille du bateau
				navirePlace = true;
				return true;
				
			}

			return false;
		}
		
	

	
	
	
}
