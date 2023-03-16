package navaletests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Dimension;

public class DimensionTest {
	
	@Test
	public void testConstructeur() {
		Dimension dimension = new Dimension(5,3);
		assertEquals(5, dimension.getRows(),"affectation de ligne Ok");
		assertEquals(3, dimension.getCols(),"affectation de colonne Ok");
	}

}
