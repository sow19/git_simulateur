package navaletests;

import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class TestHmainPlayer {
	private Grid grid = new Grid(new Dimension(6,6));
	private HumanPlayer humain = new HumanPlayer(grid, "saoudatou");
	
	
	@Test
	public void testConstructeur() {
		assertEquals("saoudatou",humain.getName());
		assertEquals(grid,humain.getGrid());
		assertNotNull(humain.getGrid());
		assertEquals(true, humain.getFleet().isEmpty(),"flot du joueur ok");
	}
	
	@Test
	public void testShoot()  throws Exception {
		
		
		
		String entree = "1,2";
		
		InputStream in = new ByteArrayInputStream(entree.getBytes());
        System.setIn(in);
        
        Position resultat = humain.shoot();
        Position position = new Position(1,2);
        
        assertEquals(position.getX(),resultat.getX());
        assertEquals(position.getY(),resultat.getY());
        
        try {
            entree = "1 2";
            in = new ByteArrayInputStream(entree.getBytes());
            System.setIn(in);
            humain.shoot();
            fail("Une exception de type InputMismatchException aurait du etre levee");
          } catch (InputMismatchException ise) {
        		 in = new ByteArrayInputStream(entree.getBytes());
                System.setIn(in);
          }
		
	}
	
	@Test
	public void testPutShipVisible() {
		
		 Ship ship1 = new Ship(3);
		 Ship ship2 = new Ship(2);
		 humain.addShip(2, 2, ship1, false);
		 humain.addShip(3, 3, ship2,true);
		 
		 humain.getFleet().add(ship1);
		 humain.putShipVisible();
		 assertTrue(ship1.isVisible());
		 assertTrue(ship2.isVisible());
		
	}

}
