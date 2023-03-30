package views;

import java.awt.Color;
// import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
// import java.io.IOException;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Game;
import model.Ship;

public class ControleGame extends JPanel {
	protected PageManager pageManager;
	protected GridBagConstraints gbc;
	protected Game game;

	protected GridView humanGridView;
	protected GridView randomGridView;

	protected JButton randomButton;
	protected JButton restartButton;

	public ControleGame(PageManager pageManager, Game game) {
		super();
		this.setBackground(Color.WHITE);
		this.pageManager = pageManager;
		this.game = game;


		// Creating the grids
		humanGridView = new GridView(game.getHumainPlayer().getGrid());
		randomGridView = new GridView(game.getRandomPlayer().getGrid());

		// Setting the layout
		this.setLayout(new GridBagLayout());
 
		// creates a constraints object
		this.gbc = new GridBagConstraints();

		// natural height, maximum width
        //this.gbc.fill = GridBagConstraints.HORIZONTAL;

		this.gbc.insets = new Insets(10, 0, 0, 0);

		 // column 0
		 this.gbc.gridx = 0;
 
		 // row 0
		 this.gbc.gridy = 0;

		 // increases components width by 150 pixels
        this.gbc.ipadx = 150;
 
        // increases components height by 150 pixels
        this.gbc.ipady = 150;

		// Adding the grids
		this.add(humanGridView, this.gbc);

		// column 1
		this.gbc.gridx = 1;
 
		// row 0
		this.gbc.gridy = 0;

		this.add(randomGridView, this.gbc);

		humanAddShipRandomLy();

		// column 0
		this.gbc.gridx = 0;
 
		// row 1
		this.gbc.gridy = 1;

		randomButton = new JButton("Placer navire aléatoire");
		restartButton = new JButton("Recommencer");
		// JPanel buttonPanel = new JPanel();
		// buttonPanel.add(randomButton);
		// buttonPanel.add(restartButton);
		
		this.gbc.insets = new Insets(0, 0, 0, 0);
		 // increases components width by 10 pixels
		 this.gbc.ipadx = 10;
		 this.gbc.ipady = 10;
		this.add(randomButton, this.gbc);
		

		// column 0
		this.gbc.gridx = 1;
 
		// row 1
		this.gbc.gridy = 1;
		this.add(restartButton, this.gbc);

		this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
	}

	public void humanAddShipRandomLy() {
		// Add ships randomly on the model
		this.game.humanAddShipRandomLy();

		// Assign a view for each ship
		ArrayList<Ship> fleet = this.game.getHumainPlayer().getFleet();

		for(Ship ship:fleet) {
			new ViewShip(ship, this.humanGridView);
		}

	}
	
}
