package views;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import model.Game;

public class PageManager extends JPanel{
    public final static long serialVersionUID = 1L;
    final static String WELCOME_PAGE = "WELCOME";
    final static String STRATEGY_PAGE = "STRATEGY";
    protected Game game;


    public PageManager(Game game) {
        super();
        this.game = game;
        this.setLayout(new CardLayout());
        this.setBackground(Color.WHITE);
        
        // add welcome page
        Welcome welcome = new Welcome(this);
        this.add(welcome, WELCOME_PAGE);
        
        // add the main game board page
        ControleGame gameBoard = new ControleGame(this, game);
        this.add(gameBoard, STRATEGY_PAGE);
        setVisible(true);
    }

    public void nextPage() {
        CardLayout cl = (CardLayout) this.getLayout();
        cl.next(this);
    }

    public void prev() {
        this.prev();
    }
}