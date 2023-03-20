package views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

import model.Game;

public class PageManager extends JPanel {
	final static String WELCOME_PAGE = "WELCOME";
	final static String STRATEGY_PAGE = "STRATEGY";
	
	public PageManager(Game game) {
		super();
		
		this.setLayout(new CardLayout());
		
		// add welcome page
		Welcome welcome = new Welcome(this);
		this.add(welcome, WELCOME_PAGE);
		
		// add strategy page
		Strategy strategy = new Strategy(this, game.getHumainPlayer());
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
