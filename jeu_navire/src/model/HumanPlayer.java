package model;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe représentant un joueur humain du jeu de bataille navale.
 */
public class HumanPlayer  extends AbstractPlayer{
	
	/**
	 * Constructeur de la classe.
	 * Initialise le joueur avec un nom, une grille de jeu vide et une flotte vide.
	 * @param name Le nom du joueur.
	 * @param grid la grille du joueur
	 */
	public HumanPlayer(Grid grid,String name) {
		super(grid,name);	
	}


	/**
    * Cette méthode permet de demander à l'utilisateur de choisir une position pour tirer.
    *Elle lit l'entrée de utilisateur depuis la console et retourne la position correspondante.
    *Si l'entrée n'est pas sous la forme 'x,y', elle lance une exception InputMismatchException.
    * @return la position choisie par l'utilisateur
    * @throws InputMismatchException si l'entrée n'est pas sous la forme 'x,y'
    */
	
	public Position shoot(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choisissez une case (ex : 1,2) : ");
		String entree = scanner.nextLine();
		if (!entree.matches("\\d+,\\d+")) {
			throw new InputMismatchException("L'entrée doit être de la forme '1,2'.");
		}
		int x = Integer.parseInt(entree.split(",")[0]);
		int y = Integer.parseInt(entree.split(",")[1]);
		return new Position(x,y);
	}
	/**
	 * met tous les navires du joueur en mode visible
	 */
	public void putShipVisible(){
		for(Ship ship : this.fleet){
			ship.setVisible(true);	
		}
	}
	
}
