package  views;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Cellule;
public  class ViewOneCell extends  JPanel{
    private static final long serialVersionUID = 1L;
    public Cellule cellOfGrid;
    public ViewOneCell(Cellule cell) {
        this.cellOfGrid = cell;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.setPreferredSize(new Dimension(50,50));
    }
//    public ViewOneCell() {
//        this(new Cellule());
//    }

//    public  void stateOfCell(CellState state){
//        if(state==CellState.BLANK){
//            this.setBackground(Color.WHITE);
//        } else if(state==CellState.HIT){
//            this.setBackground(Color.RED);
//        } else if(state==CellState.MISSED){
//            this.setBackground(Color.GREEN);
//        }
//    }
}