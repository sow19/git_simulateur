package navaletests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Position;

public class PositionTest {
	
	
	@Test
	public void testConstructeur() {
		Position position = new Position(0,0);
		assertEquals(0,position.getX(), "valeur x OK");
		assertEquals(0,position.getY(), "valeur y OK");
	}

}
