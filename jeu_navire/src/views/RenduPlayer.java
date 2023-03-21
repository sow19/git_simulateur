package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// import model.RandomPlayer;
// import model.Grid;
// import model.AbstractPlayer;
// import model.Dimension;

public class RenduPlayer extends JPanel {
	public GridView gridView=new GridView();
	public JLabel titlePlayer;
	// public AbstractPlayer palyer;
	public RenduPlayer() {
		super();
		this.setLayout(new BorderLayout());
		this.titlePlayer = new JLabel("",SwingConstants.CENTER);
		this.titlePlayer.setPreferredSize(new Dimension(200,20));//definition de la taille du label
	
		this.setPreferredSize(new Dimension(600,50));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.add(gridView,BorderLayout.CENTER);
		this.add(this.titlePlayer,BorderLayout.SOUTH);
	}

}
