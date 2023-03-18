package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Grid {
	private Dimension dimension;
	private Cellule [][] board;

	//constructeur
	public Grid(Dimension dimension) {
		this.dimension = dimension;
		this.board = new Cellule[dimension.getRows()][dimension.getCols()];
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

	/**
	 * cette méthode renvoie la cellule correspondant à une position de la grille
	 * @param position
	 * @return
	 */

	public Cellule getCellulePosition(Position position){
		return this.board[position.getX()][position.getY()];
	}

	/**
	 * cette méthode permet d'afficher la grille
	 */


	public void afficher() {
		
		for (int i = 0; i < this.dimension.getRows(); i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < this.dimension.getCols(); j++) {
				if(this.board[i][j].isAssignedShip() && this.board[i][j].getState() == CellState.BLANK){
					System.out.print("n ");

				}else if (this.board[i][j].isAssignedShip() && this.board[i][j].getState() == CellState.HIT) {
					System.out.print("X "); // si une cellule est touché
				
				
				

				
				// si une cellule est ratéé
				} else if( this.board[i][j].getState() == CellState.MISSED) {
					System.out.print("! ");

				// s'il nya pas de bateau	
				/* }else if (this.board[i][j].isAssignedShip()) {
					System.out.print("n ");*/
				}
				else{
					System.out.print("* ");

				}
			}
			System.out.println();
		}
	}

	public List <Position> gridPosition(){
		List <Position> positions = new ArrayList<>();
		for(int i=0;i<this.getBoard().length;i++){
			for(int j =0;j<this.getBoard()[0].length;j++){
				positions.add(new Position(i, j));
			}
		}
		
		Collections.shuffle(positions);
		return positions;
	}



	
	
}
