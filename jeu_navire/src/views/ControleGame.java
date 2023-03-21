package views;

// import java.awt.CardLayout;
import java.awt.Dimension;
// import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

// import model.Game;

public class ControleGame extends JPanel {
	// final static String WELCOME_PAGE = "WELCOME";
	// final static String STRATEGY_PAGE = "STRATEGY";
	
	public JButton addShip,play,backInit;

	public ControleGame() {
		super();
		//init attributs this class
		this.addShip = new JButton("ajout bateau");
		this.play = new JButton("play");
		this.backInit = new JButton("Back");
		
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setPreferredSize(new Dimension(600,100));
		this.add(this.addShip);
		this.add(this.play);
		this.add(backInit);
		JScrollPane jscp=new JScrollPane(this);
	
	// 	// add welcome page
	// 	Welcome welcome = new Welcome(this);
	// 	this.add(welcome, WELCOME_PAGE);
		
	// 	// add strategy page
	// 	Strategy strategy = new Strategy(this, game.getHumainPlayer());
	// 	this.add(strategy, STRATEGY_PAGE);
		
	// 	setVisible(true);
	// }
	
	// public void nextPage() {
	// 	CardLayout cl = (CardLayout) this.getLayout();
	// 	cl.next(this);
	// }
	
	// public void prev() {
	// 	this.prev();
	}
	
}
