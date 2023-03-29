package views;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;

import model.Cellule;
import model.Game;
import model.AbstractPlayer;
import model.Grid;

public class GridView extends JPanel {
    private static final long serialVersionUID = 1L;
    public int rows = 10;
    public int cols = 10;
    private int cellSize = 30;
    public Game game;
    public ViewOneCell[][] grid;
   public  Grid gridModel;
//    public final AbstracPlayer player;
    public GridView(Grid gridModel) {
        this.gridModel = gridModel;
//        this.game=game;
        //initialisation de la grille et des attributs
    	this.rows =this.gridModel.getDimension().getRows();
    	this.cols =this.gridModel.getDimension().getCols();
        this.grid = new ViewOneCell[this.rows][this.cols];
//    	this.setBackground(Color.BLACK);
        this.add(this.createGrid(),BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(100, 100));
        this.setVisible(true);
    }
    public JPanel createGrid() {
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(this.rows, this.cols));
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.grid[i][j] = new ViewOneCell(this.gridModel.getBoard()[i][j]);
                grid.add(this.grid[i][j]);
            }
        }
        return grid;
    }
}
