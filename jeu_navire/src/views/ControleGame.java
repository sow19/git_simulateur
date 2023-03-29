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
	public JButton addShip,play,backInit;
	public PageManager pageManager;
	public ControleGame(PageManager pageManager) {
		super();
		this.pageManager = pageManager;
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
	}
	
}
