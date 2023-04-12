package navaletests;
/**
 * /**
 * La classe TestAbstractPlayer contient les tests unitaires pour la classe AbstractPlayer.
 * @author sow224
 *
 */

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class TestGame {
	
	private  Grid grid1 = new Grid(new Dimension(5,5));
	private  Grid grid2 = new Grid(new Dimension(5,5));
	private  HumanPlayer humain = new HumanPlayer(grid1, "Joueur humain");
    private  RandomPlayer random = new RandomPlayer(grid2);
    private  Game game = new Game(humain, random);
	
	@Test
	public void testConstructeur() {
		Grid grid = new Grid(new Dimension(7,7));
		HumanPlayer humain = new HumanPlayer(grid, "Alseiny");
		RandomPlayer random = new RandomPlayer(grid);
		Game game = new Game(humain,random);
		assertEquals(humain.getName(), game.getCurrentPlayer().getName());
		assertEquals(random.getName(), game.getRandomPlayer().getName());
		assertEquals(humain.getName(), game.getHumainPlayer().getName());
		
	}
	
	@Test
	public void testGetWinner() {
		
	       //deux joueurs ne peuvent pas gagner en même temps donc on teste pour chaque joueur à part
	     
	      // Vérifier que le gagnant est le joueur humain si l'ordinateur a perdu
	        random.addShip(0, 0, new Ship(1), false);
	        random.getGrid().getBoard()[0][0].setAssignedShip(true);
	        random.getGrid().getBoard()[0][0].setState(CellState.HIT);
	       
	        assertEquals(humain, game.getWinner());

	      
	        
	    }
	
	@Test
	public void testIsOver() {
		
		 Grid grid1 = new Grid(new Dimension(5,5));
		
	     HumanPlayer humain = new HumanPlayer(grid1, "Joueur humain");
	     RandomPlayer random = new RandomPlayer(grid2);
	     Game game = new Game(humain, random);

	       //deux joueurs ne peuvent pas gagner en même temps donc on teste pour chaque joueur à part
	     
	      // Vérifier que le gagnant est le joueur humain si l'ordinateur a perdu
	        random.addShip(0, 0, new Ship(1), false);
	        random.getGrid().getBoard()[0][0].setAssignedShip(true);
	        random.getGrid().getBoard()[0][0].setState(CellState.HIT);
	        assertTrue(game.isOver());
		
	}
	
	@Test
	public void testShootGridAdversaire() {
		random.addShip(0, 0, new Ship(1), false);
		random.getGrid().getBoard()[0][0].setAssignedShip(true);
		game.setCurrentPlayer(humain);
		game.shootGridAdversaire(new Position(0,0));
		assertEquals(random.getName(), game.getCurrentPlayer().getName());
		assertTrue( random.getGrid().getBoard()[0][0].getState() == CellState.HIT);
		
		
		
		
	}
	
	
	
	

}
