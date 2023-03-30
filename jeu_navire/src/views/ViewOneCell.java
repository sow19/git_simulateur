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
        super();
        this.setBackground(Color.WHITE);
        this.cellOfGrid = cell;
        this.setBorder(BorderFactory.createLineBorder(new Color(179, 68, 223), 1));
        this.setPreferredSize(new Dimension(50,50));
    }


    public void assignToShip(boolean horizontal, int orientation, boolean last, boolean first) {
        int borderTop = 0;
        int borderBottom = 0;
        int borderLeft = 0;
        int borderRight = 0;

        int borderValue = 4;

        if (horizontal) {
            borderTop = borderValue;
            borderBottom = borderValue;

            if(orientation == borderValue) {
                if(first) borderLeft = borderValue;
                if(last) borderRight = borderValue;
            } else {
                if(first) borderRight = borderValue;
                if(last) borderLeft = borderValue;
            }

        } else {
            borderLeft = borderValue;
            borderRight = borderValue;

            if(orientation == borderValue) {
                if(first) borderBottom = borderValue;
                if(last) borderTop = borderValue;
            } else {
                if(first) borderTop = borderValue;
                if(last) borderBottom = borderValue;
            }
        }

        this.setBorder(BorderFactory.createMatteBorder(borderTop, borderLeft, borderBottom, borderRight, Color.BLACK));
        // this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        
    }


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