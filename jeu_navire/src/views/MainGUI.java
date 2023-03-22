package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

// import model.Game;
// import model.Grid;

public class MainGUI extends JFrame {
	private static final long serialVersionUID = 7376825297884956163L;
    Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWith = (tailleEcran.width*2/3);
    int screenheight = (tailleEcran.height*2/3);

	public RenduPlayer panelHumain,panelRandom;
	public ControleGame panelControl;

	public MainGUI(){

		JPanel content = (JPanel) this.getContentPane();
		content.setLayout(new BorderLayout());

		this.panelHumain = new RenduPlayer();
		this.panelRandom = new RenduPlayer();
		this.panelControl = new ControleGame();
		
		//modification de label par rapport au joueur
		this.panelHumain.titlePlayer.setText("grille du joueur:humain");
		this.panelRandom.titlePlayer.setText("grille du joueur:aleatoir");
		
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(20,0));

		content.add(this.panelHumain,BorderLayout.WEST);
		content.add(this.panelRandom,BorderLayout.EAST);
		content.add(this.panelControl,BorderLayout.SOUTH);
		content.add(center,BorderLayout.CENTER);
		// this.setLayout(new BorderLayout());
		this.setSize(screenWith,screenheight);
		// this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}
}
