package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

import javax.swing.JPanel;

import java.util.ArrayList;

import model.Ship;
import util.ListeningModel;
import util.notifications.ShipNotification;
import model.Cellule;

public class ViewShip extends JPanel implements ListeningModel {
    // private static final long serialVersionUID = 1L;
    protected Ship ship;
    protected ViewOneCell[] shipCellViews;
    protected GridView parentGridView;

    public ViewShip(Ship ship, GridView parentGridView) {
        this.ship = ship;
        this.ship.addListening(this);

        this.parentGridView = parentGridView;

        createShip();

        if(this.ship.isVisible()) {
            System.out.println("visible");
            this.setVisibility(true);
        }

    }

    private ViewOneCell getViewCell(Cellule cell) {
        int x = cell.getPosition().getX();
        int y = cell.getPosition().getY();

        return this.parentGridView.getBoardView()[x][y];
    }

    public void createShip() {
        int index = 0;
        ArrayList<Cellule> shipCells = ship.getShipCell();
        boolean horizontalShip = true;
        int orientation = 1; // 1 if ship is oriented top or right, -1 if bottom or left
        String cellString = "[";

        for (Cellule cell : shipCells) {
            cellString += "(" + cell.getPosition().getX() + "," + cell.getPosition().getY() + "), ";

            ViewOneCell viewCell = this.getViewCell(cell);

            if (index < (shipCells.size() - 1)) {
                Cellule nextCell = shipCells.get(index + 1);
                if (index == 0) {
                    horizontalShip = nextCell.getPosition().getX() == cell.getPosition().getX();

                    if (horizontalShip) {
                        orientation = nextCell.getPosition().getY() > cell.getPosition().getY() ? 1 : -1;
                    } else {
                        orientation = nextCell.getPosition().getX() < cell.getPosition().getX() ? 1 : -1;
                    }
                }
            }

            boolean first = (index == 0);
            boolean last = (index == (shipCells.size() - 1));

            viewCell.assignToShip(horizontalShip, orientation, last, first);

            index++;
        }

        cellString += "]";
        System.out.println(cellString);
    }

    public void destroyShip() {
        this.setVisibility(false);
    }

    public void setVisibility(boolean show) {
        ArrayList<Cellule> shipCells = ship.getShipCell();
        int count = 0;
        if (show) {
            for (Cellule cell : shipCells) {
                ViewOneCell viewCell = this.getViewCell(cell);
                viewCell.showBorder();
            }
        } else {
            for (Cellule cell : shipCells) {
                ViewOneCell viewCell = this.getViewCell(cell);
                viewCell.setDefaultColor();
                count++;
            }

        }

        System.out.println("count: " + count);
    }

    @Override
    public void modeleMIsAJour(Object source, Object notification) {
        if (notification instanceof ShipNotification) {
            if (notification == ShipNotification.SHIP_DESTROYED) { // Support destroyed ship
                if (this.ship.isDestroyed()) {
                    this.destroyShip();
                }
            } else if(notification == ShipNotification.SHIP_VISIBILITY_CHANGED) {
                this.setVisibility(this.ship.isVisible());
            }

        } else {
            System.out.println("Unhandled notification for ViewShip:  " + notification);
        }

    }
}