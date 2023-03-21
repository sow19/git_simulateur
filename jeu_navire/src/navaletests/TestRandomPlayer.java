package navaletests;

import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class TestRandomPlayer {
	
	private Grid grid = new Grid(new Dimension(20,20));
	private RandomPlayer random = new RandomPlayer(grid);
	
	@Test
	public void testConstructeur() {
		assertEquals("Random",random.getName());
		assertEquals(grid,random.getGrid());
		assertNotNull(random.getGrid());
		assertEquals(true, random.getFleet().isEmpty(),"flot du joueur ok");
		assertEquals(20, random.getGrid().getDimension().getRows());
        assertEquals(20, random.getGrid().getDimension().getCols());
	}
	
	@Test
	public void testShoot() {
		
		//on appelle la methode shoot 200 fois pour vérifier que les positions générée aléatoirement à chaque itération sont bien inférieurs aux dimensions de la grille
		  for (int i = 0; i < 200; i++) {
	            Position position = random.shoot();
	            assertTrue(position.getX() >= 0 && position.getX() < 20);
	            assertTrue(position.getY() >= 0 && position.getY() < 20);
	        }
	}
	
	@Test
	public void testAddShipRandomly() {
		    random.addShipRandomLy();
		    int nbreNavire = random.getFleet().size();
		    assertTrue(nbreNavire == 5);	
	}

}
