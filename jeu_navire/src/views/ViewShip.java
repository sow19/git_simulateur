package  views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;


import javax.swing.JPanel;

import java.util.ArrayList;

import model.Ship;

public class ViewShip extends JPanel{
    private static final long serialVersionUID = 1L;
    public final Ship ship;
//    public  ViewOneCell viewOneCell;

    public ViewShip(Ship ship) {
        this.ship = ship;
//        this.setLayout(new GridLayout(1,this.ship.getSize()+5));
        this.add(this.createShip(this.ship.getSize()));
        JScrollPane scrollPane = new JScrollPane(this);
        this.setBackground(Color.WHITE);
        this.setEnabled(true);
//        this.setPreferredSize(new Dimension(200,20));
    }

    public JPanel createShip(int size) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,size));
        for(int i=0;i<size;i++){
            panel.add(new ViewOneCell());
        }
        return panel;
    }
}