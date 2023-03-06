package modele;

public class Cellule {
	private Position position;
	private CellState state = CellState.BLANK;
	public Cellule(Position position, CellState state) {
		super();
		this.position = position;
		this.state = state;
	}
	
	


}
