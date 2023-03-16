package navaletests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import model.*;

public class ShipTest {
	
	@Test
	public void testConstructeur() {
		Ship ship = new Ship(10);
		assertEquals(10,ship.getSize(),"taille OK" );//verifie que la taille du navire est bien initialisé à 10
		assertEquals(false, ship.isVisible(),"isVisible OK"); // verifie que isvisible est bien initialisé à false
		assertEquals(true, ship.getShipCell().isEmpty(),"cellule du navire ok");// verifie que la liste est bien une liste vide
	}
	
	
	@Test
	public void testIsSank() {
		Ship ship = new Ship(10);
		ArrayList<Cellule> cellules = new ArrayList<>();
		ship.setShipCell(cellules);
		//on met létat de tous les cellules à Hit pour tester le retour de la méthode
		for(Cellule cellule : ship.getShipCell()) {
			cellule.setState(CellState.HIT);
		}
		boolean verif = ship.isSank();
		assertEquals(true,verif );
		
		// on met l'etat d'aumoins une à missed ou Blank
		Cellule cellule1 = new Cellule();
		cellule1.setAssignedShip(true);
		cellule1.setState(CellState.MISSED);
		ship.getShipCell().add(cellule1);
		//une autre cellule qui a BLANK comme etat
		Cellule cellule2 = new Cellule();
		cellule2.setAssignedShip(true);
		cellule2.setState(CellState.BLANK);
		ship.getShipCell().add(cellule2);
		boolean verif2 = ship.isSank();
		assertEquals(false,verif2 );
		
	}

}
