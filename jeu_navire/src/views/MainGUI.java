package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;
import model.Grid;

public class MainGUI extends JFrame {
	private static final long serialVersionUID = 7376825297884956163L;
    Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWith = (tailleEcran.width*2/3)+150;
    int screenheight = (tailleEcran.height*2/3)+100;

	public RenduPlayer panelHumain,panelRandom;
	public ControleGame panelControl;

	public MainGUI(Game game){
		JPanel content = (JPanel) this.getContentPane();
		this.panelHumain = new RenduPlayer(game.getHumainPlayer());
		this.panelRandom = new RenduPlayer(game.getRandomPlayer());
		this.panelControl = new ControleGame(game);
		
		//modification de label par rapport au joueur
		this.panelHumain.titlePlayer.setText("grille du joueur:"+game.getHumainPlayer().getName());
		this.panelRandom.titlePlayer.setText("grille du joueur:"+game.getHumainPlayer().getName());
		
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(20,0));

		content.add(this.panelHumain,BorderLayout.WEST);
		content.add(this.panelRandom,BorderLayout.EAST);
		content.add(this.panelControl,BorderLayout.SOUTH);
		content.add(center,BorderLayout.CENTER);
		
		this.setSize(screenWith,screenheight);
		// this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}
}
