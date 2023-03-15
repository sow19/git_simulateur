package model;

public class Game {
	private HumanPlayer humainPlayer;
	private RandomPlayer randomPlayer;
	private AbstractPlayer currentPlayer;


	//constructeurs

	public Game(HumanPlayer humainPlayer, RandomPlayer randomPlayer) {
		this.humainPlayer = humainPlayer;
		this.randomPlayer = randomPlayer;
		this.currentPlayer = humainPlayer;
	}


	//getters and setters

	public HumanPlayer getHumainPlayer() {
		return humainPlayer;
	}


	public void setHumainPlayer(HumanPlayer humainPlayer) {
		this.humainPlayer = humainPlayer;
	}


	public RandomPlayer getRandomPlayer() {
		return randomPlayer;
	}



	public void setRandomPlayer(RandomPlayer randomPlayer) {
		this.randomPlayer = randomPlayer;
	}

	public AbstractPlayer getCurrentPlayer() {
		return currentPlayer;
	}


	public void setCurrentPlayer(AbstractPlayer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * cette méthode retourne le gagnat de la partie
	 * @return retourne le joueur dont tous les navires ont été coulé
	 */

	public AbstractPlayer getWinner() {
        if (this.humainPlayer.isLost()) {
            return this.randomPlayer;
        } else if (this.randomPlayer.isLost()) {
            return this.humainPlayer;
        }
		return null; 
    }


	/**
	 * vérifie si le jeu est terminé
	 * @return true si
	 */
    public boolean isOver() {
        return (getWinner() != null);
    }
	

	

	/**

    * Cette méthode permet à un joueur de tirer sur la grille de son adversaire.
    * Elle prend en paramètre la position à laquelle le joueur souhaite tirer.
    * L'adversaire est choisi en fonction du joueur courant.
    * Si la cellule visée contient un bateau, sa cellule est mise à jour en tant que HIT, sinon elle est mise à jour en tant que MISSED.
    * La méthode putShipVisible est appelée sur l'adversaire pour mettre à jour l'état des bateaux.
    * Enfin, le joueur courant est changé pour passer à l'adversaire.
    @param position la position visée par le joueur
    */

	public void shootGridAdversaire(Position position) {
		AbstractPlayer adversaire = (this.currentPlayer == this.humainPlayer) ? this.randomPlayer : this.humainPlayer;
	
		Cellule celluleAdversaire = adversaire.getGrid().getCellulePosition(position);
	
		if (celluleAdversaire.isAssignedShip()) {
			celluleAdversaire.setState(CellState.HIT);
		} else {
			celluleAdversaire.setState(CellState.MISSED);
		}
		adversaire.putShipVisible();
	
		this.currentPlayer = adversaire;
	}

	public void shipRandomVisible(){
		if(this.currentPlayer == this.randomPlayer){
			this.currentPlayer.putShipVisible();
		}
	}



	/**

    * Joue une partie complète de bataille navale entre les deux joueurs.
    * Tant que la partie n'est pas terminée, le joueur en cours demande une position
    * pour tirer sur la grille de l'adversaire, puis l'autre joueur joue à son tour.
   
    */
	

	public void play() {
        while (!isOver()) {
            System.out.println(currentPlayer.getName() + " joue :");
            Position pos = currentPlayer.shoot();
            this.shootGridAdversaire(pos);
			this.getWinner();
        }

        System.out.println("Le joueur " + getWinner().getName() + " a gagné !");
		
    }

	




	

	

	
}