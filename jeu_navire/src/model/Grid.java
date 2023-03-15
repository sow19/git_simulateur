package model;



public class Grid {
	private Dimension dimension;
	private Cellule [][] board;

	//constructeur
	public Grid(Dimension dimension) {
		this.dimension = dimension;
		for(int i=0;i<this.dimension.getRows();i++){
			for(int j=0; j< this.dimension.getCols();j++){
				this.board[i][j] = new Cellule();
			} 
		}

	//getters et setters

	
		
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Cellule[][] getBoard() {
		return board;
	}

	public void setBoard(Cellule[][] board) {
		this.board = board;
	}

	//renvoyer la cellule correspondant à une position

	public Cellule getCellulePosition(Position position){
		return this.board[position.getX()][position.getY()];
	}

	//Affichage de la grille 


	public void afficher() {
		
		for (int i = 0; i < this.dimension.getRows(); i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < this.dimension.getCols(); j++) {
				//s'il ya un bateau sur une cellule
				if (this.board[i][j].getState() == CellState.BLANK && this.board[i][j].isAssignedShip()) {
					System.out.print("n");
				}
				// si une cellule est touché
				else if (this.board[i][j].getState() == CellState.HIT) {
					System.out.print("X ");

				
					// si une cellule est ratéé
				} else if(this.board[i][j].getState() == CellState.MISSED) {
					System.out.print("! ");

				// s'il nya pas de bateau	
				}
				else{
					System.out.print("*");

				}
			}
			System.out.println();
		}
	}



	
	
}
