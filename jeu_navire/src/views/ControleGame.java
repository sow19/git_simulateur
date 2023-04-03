package views;

import java.awt.Color;
// import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
// import java.io.IOException;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.AbstractPlayer;
import model.Game;
import model.HumanPlayer;
import model.Ship;
import util.ListeningModel;
import util.notifications.GameNotification;

public class ControleGame extends JPanel implements ListeningModel {
	protected PageManager pageManager;
	protected GridBagConstraints gbc;
	protected Game game;

	protected GridView humanGridView;
	protected GridView randomGridView;

	protected JPanel buttonPanel;
	protected JButton randomButton;
	protected JButton playButton;
	protected JButton restartButton;

	protected ArrayList<ViewShip> viewShipsHuman = new ArrayList<ViewShip>();
	protected ArrayList<ViewShip> viewShipsRandom = new ArrayList<ViewShip>();

	public ControleGame(PageManager pageManager, Game game) {
		super();
		this.setBackground(Color.WHITE);
		this.pageManager = pageManager;
		this.game = game;
		this.game.addListening(this);

		// Creating the grids
		humanGridView = new GridView(game.getHumainPlayer().getGrid(), "Moi", true);
		randomGridView = new GridView(game.getRandomPlayer().getGrid(), "Jouer aléatoire", false);

		// Setting the layout
		this.setLayout(new GridBagLayout());

		// creates a constraints object
		this.gbc = new GridBagConstraints();

		// natural height, maximum width
		this.gbc.fill = GridBagConstraints.HORIZONTAL;

		this.gbc.insets = new Insets(10, 0, 0, 0);

		// column 0
		this.gbc.gridx = 0;

		// row 0
		this.gbc.gridy = 0;

		// increases components width by 150 pixels
		// this.gbc.ipadx = 50;

		// increases components height by 150 pixels
		// this.gbc.ipady = 50;

		// Adding the grids
		this.add(humanGridView, this.gbc);

		// column 1
		this.gbc.gridx = 1;

		// row 0
		this.gbc.gridy = 0;
		this.gbc.weightx = 1;

		this.add(randomGridView, this.gbc);

		// column 0
		this.gbc.gridx = 0;

		// row 1
		this.gbc.gridy = 1;
		this.gbc.insets = new Insets(80, 0, 0, 0);

		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		randomButton = new JButton("Placer mes navires");
		playButton = new JButton("Jouer");
		restartButton = new JButton("Recommencer");
		buttonPanel.add(randomButton);
		buttonPanel.add(playButton);
		buttonPanel.add(restartButton);

		this.add(buttonPanel, this.gbc);

		// Create human fleet
		createHumanFleet();

		// Event binding
		manageEvent();

	}

	public void createHumanFleet() {
		// Add ships randomly on the model
		if(game.isStarted()) {
			new MessageDialog("Vous ne pouvez pas placez vos navires en pleine partie",
			JOptionPane.WARNING_MESSAGE).showMessageDialog();
		} else {
			this.game.humanAddShipRandomLy();
		}
		
	}

	public void endGame() {
		// @todo: Maybe we will do some stuffs in the game model
		if(game.isOver()) {
			// Game is over, who's the winner ?
			AbstractPlayer winner = game.getWinner();
			String endMsg = "";

			if (winner instanceof HumanPlayer) {
				endMsg = "T'es un champion \uD83E\uDD29. T'as gagné. T'es le roi des mers \uD83D\uDC51 .";
			} else {
				endMsg = "T'as perdu \uD83D\uDE16. Retente ta chance";
			}

			int result = new MessageDialog(endMsg, JOptionPane.INFORMATION_MESSAGE)
			.showConfirmationMessageDialog("Recommener", "Quitter");

			if (result == JOptionPane.OK_OPTION) {
				// Restart the game 
			} else {
				// quit application
				System.exit(0);
			}
		}
		
	}

	public void startGameClicked() {
		if(game.isStarted()){
			new MessageDialog("La partie est déjà en cours \uD83D\uDE16", JOptionPane.INFORMATION_MESSAGE).showMessageDialog();
		} else {
			this.game.startGame();
		}
		
	}

	// public void createRandomFleet() {
	// 	// Add ships randomly on the model
	// 	this.game.randomAddShip();
	// }

	public void handleHumanFleetCreated() {
		// Assign a view for each ship
		ArrayList<Ship> fleet = this.game.getHumainPlayer().getFleet();

		for (Ship ship : fleet) { // @todo: do we need this ?

			new ViewShip(ship, this.humanGridView);
			// viewShipsHuman.add(new ViewShip(ship, this.humanGridView, true));
		}
	}

	public void handleRandomFleetCreated() {
		// Assign a view for each ship
		ArrayList<Ship> fleet = this.game.getRandomPlayer().getFleet();

		for (Ship ship : fleet) { // @todo: do we need this ?
			viewShipsRandom.add(new ViewShip(ship, this.randomGridView));
		}
	}

	public void handleGameStarted() {
		new MessageDialog("La partie peu commencer", JOptionPane.INFORMATION_MESSAGE).showMessageDialog();
	}

	@Override
	public void modeleMIsAJour(Object source, Object notification) {
        if (notification instanceof GameNotification) {

			if(notification == GameNotification.HUMAN_FLEET_CREATED) {
				this.handleHumanFleetCreated();
			} else if(notification == GameNotification.RANDOM_FLEET_CREATED) {
				this.handleRandomFleetCreated();
			} else if(notification == GameNotification.GAME_STARTED) {
				this.handleGameStarted();
			}

        } else {
            System.out.println("Unhandled notification for ViewOneCell:  " + notification);
        }
    }

	public void manageEvent() {
		// Randomly add ship for humane
		randomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createHumanFleet();
			}
		});

		// Start the game
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameClicked();
			}
		});
	}

}
