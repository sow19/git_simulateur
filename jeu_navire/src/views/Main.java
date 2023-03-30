package views;
 import model.Dimension;
 import model.Game;
 import model.Grid;
 import model.HumanPlayer;
import model.RandomPlayer;


public class Main{
	public static void main(String[] args){
		 Grid grid = new Grid(new Dimension(10, 10)); // todo take from config
		 HumanPlayer hplayer = new HumanPlayer(grid, "Melas");
		 RandomPlayer rplayer = new RandomPlayer(grid);
		 Game game =  new Game(hplayer, rplayer);
		MainGUI gui = new MainGUI(game);

//		GridView gridView = new GridView(new Game(hplayer,null),hplayer);
	}

}
