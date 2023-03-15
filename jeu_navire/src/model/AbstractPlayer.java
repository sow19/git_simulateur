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


		/**
	 * Ajoute un navire à la grille du joueur aux coordonnées spécifiées, dans la direction spécifiée.
	 * 
	 * @param x la coordonnée en X de la position de départ du navire
	 * @param y la coordonnée en Y de la position de départ du navire
	 * @param ship le navire à ajouter
	 * @param estVertical true si le navire doit être ajouté verticalement, false s'il doit être ajouté horizontalement
	 * @return true si le navire a été ajouté avec succès, false sinon
	 */

	public boolean addShip(int x, int y, Ship ship,boolean estVertical) {
		// si on veut ajouter le navire de façon horizontale
		if(!estVertical){

			if (x + ship.getSize() > this.grid.getDimension().getRows()) {
				return false;
			}
			for(int i=x;i<y+ship.getSize();i++){
				//si la cellule n'est pas déja affecté à un bateau
				if(this.grid.getBoard()[i][y].isAssignedShip()){
					return false;
					
				}
				this.grid.getBoard()[x][i].setAssignedShip(true);
				fleet.add(ship);
				ship.getShipCell().add(this.grid.getBoard()[x][i]); // ajouter la cellule à la liste des cellules du bateau
			}
		}else{

			if (y + ship.getSize() > this.grid.getDimension().getCols()) {
				return false;
			}
			for(int j=y;j<x+ship.getSize();j++){
				if(this.grid.getBoard()[x][j].isAssignedShip()){
					return false;

				}
				this.grid.getBoard()[j][y].setAssignedShip(true);
				fleet.add(ship);
				ship.getShipCell().add(this.grid.getBoard()[j][y]); 

			}
		}
		return true;
	}


	public boolean isLost(){
		for(Ship ship : this.fleet){
			if(!ship.isSank()){
				return false;
			}
		}
		return true;
	}


	


	public abstract Position shoot();
	

}
