package model;

public class Demo {
     public static void main(String[] args) {
        Grid grid1 = new Grid(new Dimension(5,5));
		 Grid grid2 = new Grid(new Dimension(5,5));
	        HumanPlayer player1 = new HumanPlayer(grid1, "Joueur humain");
	        RandomPlayer player2 = new RandomPlayer(grid2);
	        Game game = new Game(player1, player2);

	        // Vérifier que le gagnant est nul si aucun joueur n'a perdu
	       

           /*  System.out.println("grille du joueur humain  avant le jeu");
            grid1.afficher();
            System.out.println("grille du joueur Random  avant le jeu");
            grid2.afficher();*/
           // System.out.println("le gagant est : " +game.getWinner());
	        // Vérifier que le gagnant est le joueur humain si l'ordinateur a perdu
	        /*player2.addShip(0, 0, new Ship(1), false);
	        player2.getGrid().getBoard()[0][0].setState(CellState.HIT);
	        player2.putShipVisible();*/

            //System.out.println("le gagant est : " +game.getWinner());
            
        
	     

	        // Vérifier que le gagnant est l'ordinateur si le joueur humain a perdu
            Ship ship = new Ship(2);
	        
	         System.out.println(player1.addShip(0, 0, ship, false));
             //player1.grid.getBoard()[0][2].setAssignedShip(true);

             grid1.afficher();
	       
	       /*  player1.getGrid().getBoard()[1][0].setState(CellState.HIT);
	        player1.putShipVisible();
	        
        System.out.println("grille du joueur humain  apres le jeu");
        grid1.afficher();
        System.out.println("grille du joueur Random  apres le jeu");
        grid2.afficher();
        System.out.println("le gagant est : " +game.getWinner());*/

        player1.shoot();
        
    }
    
}
