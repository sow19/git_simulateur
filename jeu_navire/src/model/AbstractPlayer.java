package model;

import java.util.ArrayList;

public abstract class AbstractPlayer {
	protected Grid grid;
	protected String name;
	protected ArrayList<Ship> fleet;
	

	//Constructeurs

	public AbstractPlayer(Grid grid,String name) {
		this.grid = grid;
		this.name = name;
		this.fleet = new ArrayList<>();
	}

	//getters and setters

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Ship> getFleet() {
		return fleet;
	}

	public void setFleet(ArrayList<Ship> fleet) {
		this.fleet = fleet;
	}


	public boolean isPlaceable(int x, int y, Ship ship, boolean estVertical){

		// si on veut ajouter le navire de façon horizontale
		if (!estVertical) {

			if (y + ship.getSize() > this.grid.getDimension().getCols()) {
				return false;
			}
			for (int i = y; i < y + ship.getSize(); i++) {

				// si la cellule n'est pas déjà affectée à un bateau
				if (this.grid.getBoard()[x][i].isAssignedShip()) {
					return false;
				}
				
				
			}
		} else {
			if (x + ship.getSize() > this.grid.getDimension().getRows()) {
				return false;
			}
			for (int j = x; j < x + ship.getSize(); j++) {
				if (this.grid.getBoard()[j][y].isAssignedShip()) {
					return false;
				}
				
				
			}
		}
		return true;

	}


	/**
	 * Ajoute un navire à la grille du joueur aux coordonnées spécifiées, dans la direction spécifiée.
	 * 
	 * @param x la coordonnée en X de la position de départ du navire
	 * @param y la coordonnée en Y de la position de départ du navire
	 * @param ship le navire à ajouter
	 * @param estVertical true si le navire doit être ajouté verticalement, false s'il doit être ajouté horizontalement
	 * @return true si le navire a été ajouté avec succès, false sinon
	 */

	 public boolean addShip(int x, int y, Ship ship, boolean estVertical) {

		if(!isPlaceable(x, y, ship, estVertical)){
			return false;
		}else{

			if (!estVertical) {

				
				for (int i = y; i < y + ship.getSize(); i++) {
	
					this.grid.getBoard()[x][i].setAssignedShip(true);
					ship.getShipCell().add(this.grid.getBoard()[x][i]); // ajouter la cellule à la liste des cellules du bateau
				}
			} else {
				
				for (int j = x; j < x + ship.getSize(); j++) {

					this.grid.getBoard()[j][y].setAssignedShip(true);
					ship.getShipCell().add(this.grid.getBoard()[j][y]);
				}
			}
	 	}
		this.fleet.add(ship);
		return true;	
				
	 }
			 
		/**
		
		* Vérifie si tous les navires de la flotte ont été coulés.
		* @return true si tous les navires ont été coulés, false sinon.
		*/
		public boolean isLost(){
			for(Ship ship : this.fleet){
				if(!ship.isSank()){
					return false;

				}
			}
			return true;

		}
		
	




	
	/**
	 * permet à joueur de choisir la position sur laquelle il va effectuer son tir
	 * @return la position choisit par le joueur
	 */

	public abstract Position shoot();


		
	/**
	 * permet de rendre un navire visible
	 */
	public abstract void putShipVisible();

	@Override
	public String toString() {
		return "AbstractPlayer [name :" + name + "]";
	}


	
	

}
