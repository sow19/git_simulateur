package model;

import util.AbstractListenableModel;

/**
 * classe representant une cellule de la grille d'un joueur
 */

public class Cellule extends AbstractListenableModel {
	private Position position;
	private CellState state;
	private boolean isAssignedShip;

	/**
	 * constructeur de la classe initialise une cellule avec une position ,l'etat de la cellule à BLANK,et dit qu'elle n'appartient pas à un navire
	 * @param position
	 */
	public Cellule(Position position) {
		this.position = position;
		this.state = CellState.BLANK;
		this.isAssignedShip = false;
		
	}

	/**
	 * constructeur de la classe initialise une cellule  avec l'etat de la cellule à BLANK,et dit qu'elle n'appartient pas à un navire
	 * @param position
	 */
	public Cellule() {
		this.state = CellState.BLANK;
		this.isAssignedShip = false;
		
	}

	//getters et setters

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public CellState getState() {
		return state;
	}

	public void setState(CellState state) {
		this.state = state;
	}

	public boolean isAssignedShip() {
		return isAssignedShip;
	}

	public void setAssignedShip(boolean isAssignedShip) {
		this.isAssignedShip = isAssignedShip;
	}


	

	
	


	
	


}
