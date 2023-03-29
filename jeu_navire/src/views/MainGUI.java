package views;

import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Dimension;
import model.Game;
import model.Grid;
import model.HumanPlayer;

public class MainGUI extends JFrame {
	private static final long serialVersionUID = 7376825297884956163L;
	java.awt.Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWith = (tailleEcran.width*2/3);
    int screenheight = (tailleEcran.height*2/3);

	PageManager pageManager;
	public Game game;
	public MainGUI(Game game) {
		this.game = game;
		this.pageManager = new PageManager(this.game);
		// Add pages
		this.setLayout(new BorderLayout());
		this.add(pageManager,BorderLayout.CENTER);

		this.setSize(screenWith,screenheight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}
}
