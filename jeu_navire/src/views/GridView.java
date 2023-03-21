package views;

import java.awt.*;
import javax.swing.*;
// import model.Grid;

public class GridView extends JPanel {
    
    private int rows = 10;
    private int cols = 10;
    private int cellSize = 30;
    
    public GridView() {
    	rows =10; //gridModel.getDimension().getRows();
    	cols =10; //gridModel.getDimension().getCols();
    	this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(rows * cellSize, cols * cellSize));
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(new Color(51, 178, 255)); // modification de la couleur
        
        // On augmente la taille de la grille pour noter les lettres et les numeros
        int newRows = rows++;
        int newCols = cols++;
        
        for (int row = 0; row < newRows; row++) {
            for (int col = 0; col < newCols; col++) {
                int x = col * cellSize + cellSize;
                int y = row * cellSize + cellSize;
                
                boolean drawRect = true;
                
                if (row == 0 && col > 0) {
                    g.drawString(String.valueOf((char) ('A' + (col-1))), x+cellSize/2, y+cellSize-5);
                    drawRect = false;
                }
                
                if (col == 0 && row > 0) {
                    g.drawString(String.valueOf(row), x+cellSize-15, y+cellSize/2);
                    drawRect = false;
                }
                
                if (col == 0 && row == 0)
                	drawRect = false;
                
                if(drawRect) {
                	g.drawRect(x, y, cellSize, cellSize);
                }
                
            }
        }
    }
    
}
