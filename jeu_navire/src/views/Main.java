	package views;
 import config.Config;
import model.Dimension;
 import model.Game;
 import model.Grid;
 import model.HumanPlayer;
import model.RandomPlayer;


public class Main{
	public static void main(String[] args){
		 Grid grid = new Grid(new Dimension(Config.GRID_Rows, Config.GRID_Cols)); // todo take from config
		 Grid gridRandom = new Grid(new Dimension(Config.GRID_Rows, Config.GRID_Cols)); // todo take from config
		 HumanPlayer hplayer = new HumanPlayer(grid, "Moi");
		 RandomPlayer rplayer = new RandomPlayer(gridRandom);
		 Game game =  new Game(hplayer, rplayer);
		MainGUI gui = new MainGUI(game);

//		GridView gridView = new GridView(new Game(hplayer,null),hplayer);
	}

}
