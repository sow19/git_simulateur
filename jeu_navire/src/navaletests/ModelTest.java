package navaletests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import model.*;

public class ModelTest {
	@Test
	public void testGetWinner() {
		
		 Grid grid1 = new Grid(new Dimension(5,5));
		 Grid grid2 = new Grid(new Dimension(5,5));
	        HumanPlayer humain = new HumanPlayer(grid1, "Joueur humain");
	        RandomPlayer random = new RandomPlayer(grid2);
	        Game game = new Game(humain, random);

	        // Vérifier que le gagnant est nul si aucun joueur n'a perdu
	       assertNull(game.getWinner());
	     
	        
	     /* // Vérifier que le gagnant est le joueur humain si l'ordinateur a perdu
	        random.addShip(0, 0, new Ship(1), false);
	        random.getGrid().getBoard()[0][0].setAssignedShip(true);
	        random.getGrid().getBoard()[0][0].setState(CellState.HIT);
	       
	        assertEquals(humain, game.getWinner());

	       // Vérifier que le gagnant est l'ordinateur si le joueur humain a perdu
	        
	       humain.addShip(0, 0, new Ship(1), false);
	       
	        humain.getGrid().getBoard()[0][0].setState(CellState.HIT);
	        random.getGrid().getBoard()[0][0].setAssignedShip(true);
	        assertEquals(random, game.getWinner());*/
	        
	    }
		
	}


