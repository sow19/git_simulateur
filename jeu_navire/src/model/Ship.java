package model;

import java.util.ArrayList;

import util.AbstractListenableModel;
/**
 * classe représentant un navire
*/
public class Ship extends AbstractListenableModel {
	private ArrayList<Cellule> shipCell;
	private boolean visible;
	private int size;
	protected boolean isDestroyed = false;

	/**
	 * Constructeur de la classe initialise un ship avec une liste de cellule vide, un etat visible false et une taille du navire
	 * @param size : represente la taille du navire
	 */
	public Ship(int size) {
		this.shipCell = new ArrayList<>();
		this.visible = false;
		this.size = size;
	}

	//getters et setters

	public ArrayList<Cellule> getShipCell() {
		return shipCell;
	}

	public void destroy() {
		System.out.println("model: Ship destroyed " + shipCell.size());
		// Free ship cell
		for(Cellule cell: shipCell) {
			cell.setAssignedShip(false);
		}
		this.isDestroyed = true;
		this.fireChangement();
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

	/**
	 * vérifie si l'ensemble des cellules d'un navire sont touchés
	 * @return true si toutes les cellules sont touchées false sinon
	 */
	public boolean isSank(){
		for(Cellule cellule : shipCell){
			if(!cellule.getState().equals(CellState.HIT)){
				return false;
			}
		}
		return true;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}	
	
}