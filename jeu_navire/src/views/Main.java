package views;
import model.Dimension;
import model.Game;
import model.Grid;
import model.HumanPlayer;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Grid grid = new Grid(new Dimension(10, 10));
		HumanPlayer hplayer = new HumanPlayer(grid, "Melas");
		Game game =  new Game(hplayer, null);
		MainGUI gui =  new MainGUI(game);
	}

}
