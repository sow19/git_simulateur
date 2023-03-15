package model;

public class Ship {
	private Cellule [][] shipcell;
	private Dimension dimension;
	private boolean visible = false;
	public Ship(Cellule[][] shipcell, Dimension dimension, boolean visible) {
		super();
		this.shipcell = shipcell;
		this.dimension = dimension;
		this.visible = visible;
	}
	
	
}
