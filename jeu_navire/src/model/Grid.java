package modele;

public class Grid {
	private Dimension dimension;
	private Cellule [][] boord;
	private Ship [][] fleet;
	public Grid(Dimension dimension, Cellule[][] boord, Ship[][] fleet) {
		super();
		this.dimension = dimension;
		this.boord = boord;
		this.fleet = fleet;
	}
	
	
}
