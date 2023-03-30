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
    protected Ship ship;
    protected  ViewOneCell [] shipCellViews;
    protected GridView parentGridView;

    public ViewShip(Ship ship, GridView parentGridView) {
        this.ship = ship;
        this.parentGridView = parentGridView;
        createShip();
    }

    public void createShip() {
        int index = 0;
        ArrayList<Cellule> shipCells = ship.getShipCell();
        boolean horizontalShip = true;
        int orientation = 1; // 1 if ship is oriented top or right, -1 if bottom or left
        String cellString = "[";

        for(Cellule cell:shipCells) {
            int x = cell.getPosition().getX();
            int y = cell.getPosition().getY();

            cellString += "("+x+","+y+"), ";

            ViewOneCell viewCell = this.parentGridView.getBoardView()[x][y];
            
            if(index < (shipCells.size() - 1)) {
                Cellule nextCell = shipCells.get(index+1);
                if(index == 0) {
                    horizontalShip = nextCell.getPosition().getX() == cell.getPosition().getX();

                    if(horizontalShip) {
                        orientation = nextCell.getPosition().getX() > cell.getPosition().getX() ? 1 : -1;
                    } else {
                        orientation = nextCell.getPosition().getY() < cell.getPosition().getY() ? 1 : -1;
                    }
                }
            }


            boolean first = (index == 0);
            boolean last = (index == (shipCells.size()-1));

            viewCell.assignToShip(horizontalShip, orientation, last, first);
            
            index++;
        }

        cellString += "]";
        System.out.println(cellString);
    }
}