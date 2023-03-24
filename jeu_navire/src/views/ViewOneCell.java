package  views;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Cellule;
import model.CellState;

public  class ViewOneCell extends  JPanel{
    public Cellule cellOfGrid;
    public CellState state;
    public ViewOneCell(Cellule cell){
        this.cellOfGrid = cell;
        this.state = CellState.BLANK;
        this.stateOfCell(this.state);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//        JButton button = new JButton();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(state==CellState.MISSED){
                    setEnabled(false);
                    System.out.println("click"+state);
                } else if (state==CellState.HIT){
                    setEnabled(false);
                    System.out.println("click"+state);
                } else if (state==CellState.BLANK){
                    state = CellState.MISSED;
                }
                stateOfCell(state);
//                System.out.println("click"+state);
            }
            public void mouseExited(MouseEvent arg0) {
                // Ba faire ce que tu veux

            }
            public void mousePressed(MouseEvent arg0) {
                // TODO Ba faire ce que tu veux

            }

            public void mouseReleased(MouseEvent arg0) {
                // TODO Ba faire ce que tu veux

            }

            public void mouseEntered(MouseEvent arg0) {
                // TODO Ba faire ce que tu veux

            }

        });
        this.repaint();
        this.setPreferredSize(new Dimension(50,50));
    }

    public ViewOneCell() {
        this(new Cellule());
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