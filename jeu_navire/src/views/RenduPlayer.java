package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.RandomPlayer;
import model.Grid;
import model.AbstractPlayer;
// import model.Dimension;

public class RenduPlayer extends JPanel {
	public GridView gridView;
	public JLabel titlePlayer;
	public AbstractPlayer palyer;
	public RenduPlayer(AbstractPlayer player) {
		super();
		//initialisation des attribut
		if(player instanceof RandomPlayer){
			this.gridView = new GridView(player.getGrid());
			this.titlePlayer = new JLabel("Aleatoir");
		}
		this.titlePlayer = new JLabel(player.getName());
		this.titlePlayer.setPreferredSize(new Dimension(55,20));//definition de la taille du label

		this.setPreferredSize(new Dimension(400,400));
		this.setBorder(BorderFactory.createLineBorder(getBackground(), 1));
		this.add(gridView,BorderLayout.CENTER);
		this.add(titlePlayer,BorderLayout.SOUTH);
	}

}
