package navaletests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import model.CellState;
import model.Cellule;
import model.Position;

public class CelluleTest {
	
	@Test
	public void testConstructeur() {
		Cellule cellule1 = new Cellule();
		Cellule cellule2 = new Cellule(new Position(1,2));
		assertEquals(CellState.BLANK, cellule1.getState());
		assertEquals(CellState.BLANK, cellule2.getState());
		assertEquals(false, cellule2.isAssignedShip());
		assertEquals(false, cellule1.isAssignedShip());
		assertEquals(1,cellule2.getPosition().getX());
		assertEquals(2,cellule2.getPosition().getY());
		
		
		
	}

}
