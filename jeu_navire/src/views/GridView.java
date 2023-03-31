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
    public ViewOneCell[][] boardView;
    public Grid gridModel;
    protected GridBagConstraints gbc;

    public GridView(Grid gridModel) {
        super();
        this.setBackground(Color.WHITE);
        this.gridModel = gridModel;

        // initialisation de la grille et des attributs
        this.rows = this.gridModel.getDimension().getRows();
        this.cols = this.gridModel.getDimension().getCols();
        this.boardView = new ViewOneCell[this.rows][this.cols];
        // this.add(this.createGrid(),BorderLayout.CENTER);
        //this.setSize(new Dimension(6000,1000));

        // Setting the layout
        this.setLayout(new GridBagLayout());

        // creates a constraints object
        this.gbc = new GridBagConstraints();

        // natural height, maximum width
        this.gbc.fill = GridBagConstraints.BOTH;

        this.gbc.gridx = 0;

        // col j
        this.gbc.gridy = 0;
        this.gbc.gridwidth = 10;

        this.add(new JTextField("Jouer humain"), this.gbc);

        this.gbc.gridwidth = 1;
        this.gbc.ipadx = 30;
        this.gbc.ipady = 30;
        this.gbc.weightx = 0;
        this.gbc.weighty = 0;
        createGrid();

        //this.setVisible(true);

        //this.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
    }

    public void createGrid() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                // row i
                this.gbc.gridx = j;

                // col j
                this.gbc.gridy = i + 1;

                this.boardView[i][j] = new ViewOneCell(this.gridModel.getBoard()[i][j]);
                this.add(this.boardView[i][j], this.gbc);
            }
        }
    }

    public ViewOneCell[][] getBoardView() {
        return boardView;
    }

    public void setBoardView(ViewOneCell[][] boardView) {
        this.boardView = boardView;
    }

    
}
