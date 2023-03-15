package model;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer  extends AbstractPlayer{
	

	public HumanPlayer(Grid grid,String name) {
		super(grid,name);
		
	}

	//cette methode permet au joueur de tirer sur une position
	public Position shoot(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choisissez une case (ex : 1,2) : ");
		String entree = scanner.nextLine();
		if (!entree.matches("\\d+,\\d+")) {
			throw new InputMismatchException("L'entrée doit être de la forme '1,2'.");
		}
		int x = Integer.parseInt(entree.split(",")[0]);
		int y = Integer.parseInt(entree.split(",")[1]);
		return new Position(x, y);

	}
	
	
}
