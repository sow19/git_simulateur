package modele;

public class Cellule {
	private Position position;
	private Cell_State state = Cell_State.BLANK;
	public Cellule(Position position, Cell_State state) {
		super();
		this.position = position;
		this.state = state;
	}
	
	


}
