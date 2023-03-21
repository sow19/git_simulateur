package model;

import config.Config;

public class Demo {
     public static void main(String[] args) {
        Grid grid1 = new Grid(new Dimension(Config.Rows,Config.Cols));
        Grid grid2 = new Grid(new Dimension(Config.Rows,Config.Cols));
        HumanPlayer humain = new HumanPlayer(grid1, "Joueur humain");
        RandomPlayer random = new RandomPlayer(grid2);
        Game game = new Game(humain, random);

        /*System.out.println("la grille du random avant la méthode ad");
        random.grid.afficher();*/


        //random.addShipRandomLy();
     

      //humain.humainAddShip();

      
      System.out.println(humain.shoot());

      //game.play();


	 

       
        
    }
    
}
