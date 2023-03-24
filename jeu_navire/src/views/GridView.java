package views;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;

import model.CellState;
import model.Cellule;
import model.Ship;

public class GridView extends JPanel {
    private static final long serialVersionUID = 1L;
    private int rows = 10;
    private int cols = 10;
    private int cellSize = 30;
    public final ViewOneCell viewOneCell;
//    public final GridModel gridModel;
//    public final AbstracPlayer player;
    public GridView() {
//        this.player = player;


        this.setLayout(new BorderLayout());
        this.viewOneCell = new ViewOneCell();
    	rows =10; //gridModel.getDimension().getRows();
    	cols =10; //gridModel.getDimension().getCols();
    	this.setBackground(Color.WHITE);
        this.add(this.createGrid(),BorderLayout.CENTER);
//        this.add(this.createFleet(),BorderLayout.EAST);
//        this.setPreferredSize(new Dimension(1000, 100));
    }
    public JPanel createFleet() {
        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(5,1));
        panel.add(new ViewShip(new Ship(5)));
        panel.add(new ViewShip(new Ship(4)));
        panel.add(new ViewShip(new Ship(3)));
        panel.add(new ViewShip(new Ship(3)));
        panel.add(new ViewShip(new Ship(2)));
        panel.setPreferredSize(new Dimension(100,0));
        JScrollPane scrollPane = new JScrollPane(panel);
        return panel;
    }
    public JPanel createGrid() {
//        int newRows = rows++;
//        int newCols = cols++;
        CellState state = null;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellSize + cellSize;
                int y = row * cellSize + cellSize;

                boolean drawRect = true;

//                if (row == 0 && col > 0) {
////                    g.drawString(String.valueOf((char) ('A' + (col-1))), x+cellSize/2, y+cellSize-5);
//                    drawRect = false;
//                }
//
//                if (col == 0 && row > 0) {
////                    g.drawString(String.valueOf(row), x+cellSize-15, y+cellSize/2);
//                    drawRect = false;
//                }
//
//                if (col == 0 && row == 0)
//                    drawRect = false;

                if(drawRect) {
                    panel.add(new ViewOneCell(new Cellule()));
                }

            }
        }
        panel.setBackground(Color.BLACK);
        return panel;
    }
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        g.setColor(new Color(51, 178, 255)); // modification de la couleur
//
//        // On augmente la taille de la grille pour noter les lettres et les numeros
//        int newRows = rows++;
//        int newCols = cols++;
//
//        for (int row = 0; row < newRows; row++) {
//            for (int col = 0; col < newCols; col++) {
//                int x = col * cellSize + cellSize;
//                int y = row * cellSize + cellSize;
//
//                boolean drawRect = true;
//
//                if (row == 0 && col > 0) {
//                    g.drawString(String.valueOf((char) ('A' + (col-1))), x+cellSize/2, y+cellSize-5);
//                    drawRect = false;
//                }
//
//                if (col == 0 && row > 0) {
//                    g.drawString(String.valueOf(row), x+cellSize-15, y+cellSize/2);
//                    drawRect = false;
//                }
//
//                if (col == 0 && row == 0)
//                	drawRect = false;
//
//                if(drawRect) {
//                    if((row%2==0) && (col%2==0)){
//                        g.setColor(Color.BLACK);
//                        g.fillRect(x,y,cellSize,cellSize);
//                    }else{
//                        g.setColor(new Color(51, 178, 255));
//                        g.drawRect(x, y, cellSize, cellSize);
//                    }
//                }
//
//            }
//        }
    //}
    
}
