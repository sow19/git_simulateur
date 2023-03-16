package model;

import java.util.ArrayList;



public class Ship {
	private ArrayList<Cellule> shipCell;
	private boolean visible;
	private int size;



	//constructeurs

	public Ship(int size) {
		this.shipCell = new ArrayList<>();
		this.visible = false;
		this.size = size;
	}

	//getters et setters

	public ArrayList<Cellule> getShipCell() {
		return shipCell;
	}

	public void setShipCell(ArrayList<Cellule> shipCell) {
		this.shipCell = shipCell;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// verifie si un bateau est coulé

	public boolean isSank(){
		for(Cellule cellule : shipCell){
			if(cellule.getState()!=CellState.HIT){
				return false;
			}
		}
		return true;
	}

	


	
	
}
