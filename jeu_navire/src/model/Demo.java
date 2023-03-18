package model;

public class Demo {
     public static void main(String[] args) {
        Grid grid1 = new Grid(new Dimension(2,2));
        Grid grid2 = new Grid(new Dimension(20,20));
        HumanPlayer humain = new HumanPlayer(grid1, "Joueur humain");
        RandomPlayer random = new RandomPlayer(grid2);
        Game game = new Game(humain, random);

        System.out.println("la grille du random avant la méthode ad");
        random.grid.afficher();
        random.addShipRandomLy(10);
        System.out.println("la grille du random après la méthode ad");
        random.grid.afficher();


         
      
          
          
          
         

	        

       
        
    }
    
}
