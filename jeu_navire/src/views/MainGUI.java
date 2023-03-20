package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;

public class MainGUI extends JFrame {
	PageManager pageManager;
	
	public MainGUI(Game game) {
		pageManager = new PageManager(game);
		
		// Add pages
		this.setLayout(new BorderLayout());
		this.add(pageManager);
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}
