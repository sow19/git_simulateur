package model;

public class Demo {
     public static void main(String[] args) {
        Grid grid1 = new Grid(new Dimension(100,100));
		 Grid grid2 = new Grid(new Dimension(20,20));
	        HumanPlayer player1 = new HumanPlayer(grid1, "Joueur humain");
	        RandomPlayer player2 = new RandomPlayer(grid2);
	        Game game = new Game(player1, player2);

            player2.addShipRandomLy();
            player2.addShipRandomLy();
            player1.addShip(0, 0,new Ship(20), false);
            player1.addShip(3, 3,new Ship(5), true);


            System.out.println("La taille de la flotte du random "+player2.getFleet().size());
            System.out.println("La taille de la flotte de l'humain "+player1.getFleet().size());

	        

       
        
    }
    
}
