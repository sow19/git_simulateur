package views;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Cellule;
import util.ListeningModel;
import util.notifications.CellNotification;

public class ViewOneCell extends JPanel implements ListeningModel {
    // private static final long serialVersionUID = 1L;
    public Cellule cellOfGrid;

    protected int borderTop = 0;
    protected int borderBottom = 0;
    protected int borderLeft = 0;
    protected int borderRight = 0;
    protected int borderValue = 4;
    protected Color defaultColor = new Color(179, 68, 223);

    public ViewOneCell(Cellule cell) {
        super();
        this.setBackground(Color.WHITE);

        this.cellOfGrid = cell;
        this.cellOfGrid.addListening(this);

        this.setBorder(BorderFactory.createLineBorder(defaultColor, 1));
        this.setPreferredSize(new Dimension(50, 50));
    }

    public void setDefaultColor() {
        System.out.println("vue: cell def");
        this.setBorder(BorderFactory.createLineBorder(defaultColor, 1));
        // this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }

    public void assignToShip(boolean horizontal, int orientation, boolean last, boolean first) {
        this.borderTop = 0;
        this.borderBottom = 0;
        this.borderLeft = 0;
        this.borderRight = 0;

        if (horizontal) {
            borderTop = borderValue;
            borderBottom = borderValue;

            if (orientation == 1) {
                if (first)
                    borderLeft = borderValue;
                if (last)
                    borderRight = borderValue;
            } else {
                if (first)
                    borderRight = borderValue;
                if (last)
                    borderLeft = borderValue;
            }

        } else {
            borderLeft = borderValue;
            borderRight = borderValue;

            if (orientation == 1) {
                if (first)
                    borderBottom = borderValue;
                if (last)
                    borderTop = borderValue;
            } else {
                if (first)
                    borderTop = borderValue;
                if (last)
                    borderBottom = borderValue;
            }
        }
    }

    public void showBorder() {
        this.setBorder(BorderFactory.createMatteBorder(borderTop, borderLeft, borderBottom, borderRight, new Color(148, 39, 191)));
    }

    @Override
    public void modeleMIsAJour(Object source, Object notification) {
        if (notification instanceof CellNotification) {

        } else {
            System.out.println("Unhandled notification for ViewOneCell:  " + notification);
        }
    }

    // public void stateOfCell(CellState state){
    // if(state==CellState.BLANK){
    // this.setBackground(Color.WHITE);
    // } else if(state==CellState.HIT){
    // this.setBackground(Color.RED);
    // } else if(state==CellState.MISSED){
    // this.setBackground(Color.GREEN);
    // }
    // }
}