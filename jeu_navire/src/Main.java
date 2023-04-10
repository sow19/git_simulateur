
import config.Config;
import model.Dimension;
import model.Game;
import model.Grid;
import model.HumanPlayer;
import model.RandomPlayer;
import views.MainGUI;

public class Main {
	public static void main(String[] args) {
		// Creating human player grid object
		Grid grid = new Grid(new Dimension(Config.GRID_Rows, Config.GRID_Cols));

		// Creating random player grid object
		Grid gridRandom = new Grid(new Dimension(Config.GRID_Rows, Config.GRID_Cols));

		// Creating human player and random player object
		HumanPlayer hplayer = new HumanPlayer(grid, "Moi");
		RandomPlayer rplayer = new RandomPlayer(gridRandom);

		// Create the game object and launch GUI
		Game game = new Game(hplayer, rplayer);
		MainGUI gui = new MainGUI(game);

	}

}
