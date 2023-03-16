package navaletests;

import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GridTest {

	@Test
	public void testConstructeur() {
		  Dimension dimension = new Dimension(5, 5);
	        Grid grid = new Grid(dimension);
	        assertNotNull(grid);
	        assertEquals(grid.getDimension(), dimension);
	        assertEquals(grid.getBoard().length, dimension.getRows());
	        assertEquals(grid.getBoard()[0].length, dimension.getCols());
	        for (int i = 0; i < dimension.getRows(); i++) {
	            for (int j = 0; j < dimension.getCols(); j++) {
	                assertNotNull(grid.getBoard()[i][j]);
	            }
	        }
	    }
	
	@Test
	public void testAfficherGrid() {
		// on cree une grille et on teste l'affichage en fonction de l'état des cellules
		 	Dimension dimension = new Dimension(3, 3);
	        Grid grid = new Grid(dimension);
	       
	        grid.getBoard()[0][0].setState(CellState.HIT);
	        grid.getBoard()[0][2].setState(CellState.HIT);
	        
	        //on met l'etat des cellules à MISSED
	        grid.getBoard()[0][1].setState(CellState.MISSED);
	        grid.getBoard()[1][2].setState(CellState.MISSED);
	        
	        // Rediriger la sortie standard vers un ByteArrayOutputStream pour pouvoir recuperer la sortie de la fonction affichage
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outContent));
	        
	        String sortie = "A X ! X \n" +
                    		"B * * ! \n" +
                    		"C * * * \n" ;
	         grid.afficher();
	         
	         String afficher = outContent.toString();
                    		
                    
	        
	        
	        
	        // on vérifie que l'affichage est le même
	        
	        assertEquals(sortie, afficher);
	        
	}
	
	@Test
	public void testGetCellulePosition() {
		// on initialise la grille
		Dimension dimension = new Dimension(3, 3);
        Grid grid = new Grid(dimension);
        // on cree une position
        Position position = new Position(0,1);
        //on recupere la cellule à la position 
        Cellule cellule = grid.getCellulePosition(position);
        // on met l'etat de la cellule à HIT
        cellule.setState(CellState.HIT);
        // on verifie que cellule est bien égale à une cellule qui se trouve sur la position (0,1) dans la grille
        assertEquals(grid.getBoard()[0][1].getState(), cellule.getState());
        assertEquals(grid.getBoard()[0][1].isAssignedShip(), cellule.isAssignedShip());
        assertEquals(grid.getBoard()[0][1], cellule);
		
		
	}
		
	}

