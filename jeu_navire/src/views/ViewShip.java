package  views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;


import javax.swing.JPanel;

import java.util.ArrayList;

import model.Ship;
import model.Cellule;

public class ViewShip extends JPanel{
    private static final long serialVersionUID = 1L;
    public Ship ship;
    public  ViewOneCell [] shipCells;
    public GridView gridView;
    public ViewShip(Ship ship) {
        this.ship = ship;
        this.shipCells = new ViewOneCell[this.ship.getSize()];
        this.add(this.createShip(this.ship.getSize()));
//        this.setPreferredSize(new Dimension(100, 100));
    }
//    public ViewShip() {
//        this(new Ship(this.ship.getSize()));
//    }
    public JPanel createShip(int size) {
        JPanel ship = new JPanel();
        for (int i = 0; i < this.ship.getSize(); i++) {
            ViewOneCell cell = new ViewOneCell(new Cellule());
            cell.setBackground(Color.BLUE);
            cell.setPreferredSize(new Dimension(50, 50));
            this.shipCells[i] = cell;
            ship.add(this.shipCells[i]);
        }
        return ship;
    }
}