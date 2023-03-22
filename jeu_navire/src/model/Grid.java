package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * cette classe représente la grille d'un joueur
 */

public class Grid {
	private Dimension dimension;
	private Cellule [][] board;

	/**
	 * Constructeur de la classe permet d'initialiser la grille
	 * @param dimension représente les dimensions de la grille du joueur
	 */
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
	/**
	 * Constructeur sans argument
	 */

	public Grid() {
		
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

		System.out.print("  ");
        for (int i = 0; i < dimension.getRows(); i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

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
				}
				else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

	/**
    * Cette méthode retourne une liste aléatoire de toutes les positions de la grille de jeu.
    * Elle parcourt chaque cellule de la grille de jeu et crée une Position correspondante
    * qu'elle ajoute à la liste de positions. Ensuite, elle mélange aléatoirement la liste de positions
    * pour que l'ordre dans lequel les positions sont parcourues ne soit pas toujours le même.
    * @return une liste de positions aléatoire pour la grille de jeu
    */
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
