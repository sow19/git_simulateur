package model;

public class Demo {
     public static void main(String[] args) {
        Grid grid1 = new Grid(new Dimension(2,2));
        Grid grid2 = new Grid(new Dimension(2,2));
        HumanPlayer humain = new HumanPlayer(grid1, "Joueur humain");
        RandomPlayer random = new RandomPlayer(grid2);
        Game game = new Game(humain, random);

           // Vérifier que le gagnant est nul si aucun joueur n'a perdu
          
        
           Ship ship = new Ship(1);
         // Vérifier que le gagnant est le joueur humain si l'ordinateur a perdu
        random.addShip(0, 0, ship, false); 
        humain.addShip(0, 0, new Ship(1), false);
        game.play();
          
          
          
         

	        

       
        
    }
    
}
