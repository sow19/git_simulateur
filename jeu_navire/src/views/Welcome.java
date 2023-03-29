package views;

import java.util.Random;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Game;
import model.HumanPlayer;
import model.Dimension;
import model.Grid;
import model.Ship;

public class Welcome extends JPanel {
	PageManager pageManager;
	JButton startButton,addShip;
//	JLabel welcomeLabel;
	public GridView gridView;
//	public ViewShip viewShip;
	public Game game;
	
	public Welcome(PageManager pageManager,Game game) {
		super();
		this.game = game;
		this.pageManager = pageManager;
		this.gridView = new GridView(this.game.getCurrentPlayer().getGrid());
		this.setPreferredSize(new java.awt.Dimension(FrameSize.HEAD_WIDTH, FrameSize.HEAD_HEIGHT));
		
		// set layout
		setLayout(new BorderLayout());
		// Create components
	    startButton = new JButton("Commencer");
		startButton.setFont(new Font("Arial", Font.BOLD, 20));
		addShip = new JButton("Ajouter un navire");
		addShip.setFont(new Font("Arial", Font.BOLD, 20));
		manageEvent();

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		buttonPanel.add(addShip);
		 JScrollPane scrollPane = new JScrollPane(buttonPanel);

		// Add components to panel
	     this.add(gridView, BorderLayout.CENTER);
	     this.add(scrollPane, BorderLayout.SOUTH);
	     
		 setVisible(true);
		
	}
	
	/**
	 * Our controller
	 */
	public void manageEvent() {
		startButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  startButtonClicked();
				  } 
				} );
		addShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				for(Ship ship : addShipButtonClicked()) {
//					addShip(new ViewShip(ship));
//					addShipButtonClicked().remove(ship);
//				}
				addShip(new ViewShip(new Ship(3)));
			}
			});
	}
	
	public void startButtonClicked() {
		pageManager.nextPage();
	}

	public ArrayList<Ship> addShipButtonClicked() {
		game.getCurrentPlayer().getFleet().add(new Ship(3));
		game.getCurrentPlayer().getFleet().add(new Ship(3));
		game.getCurrentPlayer().getFleet().add(new Ship(2));
		game.getCurrentPlayer().getFleet().add(new Ship(4));
		game.getCurrentPlayer().getFleet().add(new Ship(5));
		return game.getCurrentPlayer().getFleet();
	}
	
	
//	@Override
//	  protected void paintComponent(Graphics g) {
//	    super.paintComponent(g);
//	 // Load the background image
//        BufferedImage img = null;
//		try {
//			img = ImageIO.read(this.getClass().getResource("/assets/wp.jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	     g.drawImage(img, 0, 0, null);
//	}

	/**
	 * Vérifie si le navire peut être placé à la position donnée sur la grille
	 * @param x la coordonnée x de la position de départ du navire
	 * @param y la coordonnée y de la position de départ du navire
	 * @param ship e navire à placer
	 * @param estVertical estVertical true si le navire doit être placé verticalement, false s'il doit être placé horizontalement
	 * @return  true si le navire peut être placé à la position donnée, false sinon
	 */
	public boolean isPlaceable(int x, int y, ViewShip shipView, String estVertical){
			this.game.getCurrentPlayer().isPlaceable(x, y, shipView.ship, true);
		// si on veut ajouter le navire de façon horizontale
		if (!estVertical.equals("vertical")) {

			if (y + shipView.ship.getSize() > this.gridView.cols) {
				return false;
			}
			for (int i = y; i < y + shipView.ship.getSize(); i++) {

				// si la cellule n'est pas déjà affectée à un bateau
				if (this.gridView.grid[x][i].getBackground() == Color.BLUE) {
					return false;
				}
			}
		} else {
			if (x + shipView.ship.getSize() > this.gridView.rows) {
				return false;
			}
			for (int j = x; j < x + shipView.ship.getSize(); j++) {
				if (this.gridView.grid[j][y].getBackground() == Color.BLUE) {
					return false;
				}
			}
		}
		return true;
	}

	public void addShip(ViewShip viewShip) {
		Random r= new Random();
		Integer x=null;//r.nextInt(this.gridView.rows);
		Integer y=null;//r.nextInt(this.gridView.cols);
		String[] orientation={"horizontal","vertical"};
		String orientationChoice="";//orientation[r.nextInt(orientation.length)];
		do {
			x = r.nextInt(this.gridView.rows);
			y = r.nextInt(this.gridView.cols);
			orientationChoice = orientation[r.nextInt(orientation.length)];
			if (orientationChoice.equals("horizontal")) {
				if (isPlaceable(x, y, viewShip, orientationChoice)) {
					for (int i = 0; i < viewShip.ship.getSize(); i++) {
						this.gridView.grid[x][i].setBackground(viewShip.shipCells[i].getBackground());
						this.gridView.grid[x][i] = viewShip.shipCells[i];
					}
				}
			} else {
				if (isPlaceable(x, y, viewShip, orientationChoice)) {
					for (int i = 0; i < viewShip.ship.getSize(); i++) {
						this.gridView.grid[i][y].setBackground(viewShip.shipCells[i].getBackground());
						this.gridView.grid[i][y] = viewShip.shipCells[i];
					}
				}
			}
		}while(!isPlaceable(x,y,viewShip,orientationChoice));
	}

}
