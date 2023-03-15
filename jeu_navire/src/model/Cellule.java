package model;

public class Cellule {
	private Position position;
	private CellState state;
	private boolean isAssignedShip;

	//constructeur

	public Cellule(Position position) {
		this.position = position;
		this.state = CellState.BLANK;
		this.isAssignedShip = false;
		
	}

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
