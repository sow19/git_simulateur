package  views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.JPanel;

import java.util.ArrayList;

import model.Ship;

public class ViewShip extends JPanel{
    private static final long serialVersionUID = 1L;
    public final Ship ship;
//    public  ViewOneCell viewOneCell;

    public ViewShip(Ship ship) {
        this.ship = ship;
        this.setLayout(new GridLayout(1,this.ship.getSize()+5));
//        this.viewOneCell = viewOneCell;
        for (int i=0;i<this.ship.getSize();i++){
            this.add(new ViewOneCell());
        }
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(50,30));
    }

//    public ArrayList<ViewOneCell> createShip(int size) {
//        ArrayList<ViewOneCell> viewOneCells = new ArrayList<>();
//        for(int i=0;i<size;i++){
//            viewOneCells.add(new ViewOneCell());
//        }
//        return viewOneCells;
//    }
}