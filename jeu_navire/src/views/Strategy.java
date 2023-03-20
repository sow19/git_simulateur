package views;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Grid;
import model.HumanPlayer;
import model.Dimension;

public class Strategy extends JPanel {
	PageManager pageManager;
	
	public Strategy(PageManager pageManager, HumanPlayer hplayer) {
		super();
		this.pageManager = pageManager;
		
		this.setBackground(Color.WHITE);
		
		this.setLayout(new GridLayout(1, 2, 15, 5));
		this.add(new JButton("heelo"));
		
		
		GridView gridView = new GridView(hplayer.getGrid());
		this.add(gridView);
		
		setVisible(true);
	}
}
