package  views;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Cellule;
import model.CellState;

public  class ViewOneCell extends  JPanel{
    public Cellule cellOfGrid;
    public CellState state;
    public ViewOneCell(Cellule cell,CellState state){
        this.cellOfGrid = cell;
        this.state = state;
        this.stateOfCell(state);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setPreferredSize(new Dimension(50,50));
    }

    public ViewOneCell() {
        this(new Cellule(),CellState.BLANK);
    }

    public  void stateOfCell(CellState state){
        if(state==CellState.BLANK){
            this.setBackground(Color.WHITE);
        } else if(state==CellState.HIT){
            this.setBackground(Color.RED);
        } else if(state==CellState.MISSED){
            this.setBackground(Color.GREEN);
        }
    }
}