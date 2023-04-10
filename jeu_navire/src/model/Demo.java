package model;

import config.Config;

public class Demo {
     public static void main(String[] args) {
        Grid grid1 = new Grid(new Dimension(Config.GRID_Rows,Config.GRID_Cols));
        Grid grid2 = new Grid(new Dimension(Config.GRID_Rows,Config.GRID_Cols));
        HumanPlayer humain = new HumanPlayer(grid1, "Joueur humain");
        RandomPlayer random = new RandomPlayer(grid2, grid1);
        Game game = new Game(humain, random);

        /*System.out.println("la grille du random avant la méthode ad");
        random.grid.afficher();*/


        //random.addShipRandomLy();
     

      humain.humainAddShip();

      
      //System.out.println(humain.shoot());

      //game.play();


	 

      
        
    }
    
}
