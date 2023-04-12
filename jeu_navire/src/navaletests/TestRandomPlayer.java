package navaletests;
/**
 * /**
 * La classe TestAbstractPlayer contient les tests unitaires pour la classe AbstractPlayer.
 * @author sow224
 *
 */

import org.junit.jupiter.api.Test;



import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class TestRandomPlayer {
	
	//creation de variables commune à toutes les méthodes
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
		//on verifie également les positions sont différentes
		  List<Position> positions = new ArrayList<>();
		    for (int i = 0; i < 200; i++) {
		        Position position = random.shoot();
		        assertTrue(position.getX() >= 0 && position.getX() < 20);
		        assertTrue(position.getY() >= 0 && position.getY() < 20);
		        assertFalse(positions.contains(position));
		        positions.add(position);
		    }
	}
	
	@Test
	public void testAddShipRandomly() {
		//on verifie que la méthode a bien ajouté 5 navires
		    random.addShipRandomLy();
		    int nbreNavire = random.getFleet().size();
		    assertTrue(nbreNavire == 5);	
	}

}
