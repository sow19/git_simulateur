package views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.text.Position;

import model.CellState;
import model.Cellule;
import model.Game;
import model.Grid;
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

        manageEvent();

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
        this.setBorder(BorderFactory.createMatteBorder(borderTop, borderLeft, borderBottom, borderRight,
                new Color(148, 39, 191)));
    }

    public void cellClicked() { 
        // Manage click event only on random player grid cells, human cannot hit himself
        Container parent = this.getParent();
        if(parent instanceof GridView) {
            GridView gridViewparent = (GridView) parent;
            
            if(!gridViewparent.isHumanGrid()) {
                 // Get game model from grand-parent component
                ControleGame grandParent = (ControleGame) gridViewparent.getParent();
                Game game = grandParent.game;

                // @todo: should we make sure human is the current player ?
                game.setCurrentPlayer(game.getHumainPlayer());
                game.shootGridAdversaire(cellOfGrid.getPosition());

                // make the random player shoot 
                game.shootGridAdversaire(game.getRandomPlayer().shoot());
            }
        } else {
            System.out.println("DEBUG: CELL HAVE NOT PARENT GRID");
        }
        

       
    }

    public void handleStateChanged() {
        if (cellOfGrid.getState() == CellState.BLANK) {
            this.setBackground(Color.WHITE);
        } else if (cellOfGrid.getState() == CellState.HIT) {
            this.setBackground(Color.RED);
        } else if (cellOfGrid.getState() == CellState.MISSED) {
            this.setBackground(Color.GREEN);
        }
    }


    @Override
    public void modeleMIsAJour(Object source, Object notification) {
        if (notification instanceof CellNotification) {
            if (notification == CellNotification.STATE_CHANGED) {
                handleStateChanged();
            }
        } else {
            System.out.println("Unhandled notification for ViewOneCell:  " + notification);
        }
    }

    public void manageEvent() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cellClicked();
            }
        });
    }

}