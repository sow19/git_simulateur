package  views;

import java.awt.CardLayout;

import javax.swing.JPanel;

import model.Game;

public class PageManager extends JPanel{
    public final static long serialVersionUID = 1L;
     final static String WELCOME_PAGE = "WELCOME";
     final static String STRATEGY_PAGE = "STRATEGY";

     public Game game;

    public PageManager(Game game) {
        super();
        this.game = game;
        this.setLayout(new CardLayout());
        // add welcome page
        Welcome welcome = new Welcome(this,this.game);
        this.add(welcome, WELCOME_PAGE);
        // add strategy page
        ControleGame strategy = new ControleGame(this);
        this.add(strategy, STRATEGY_PAGE);
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