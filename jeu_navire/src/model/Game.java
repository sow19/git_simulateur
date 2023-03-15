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
	

	

	//cette methode permet de passer la grille d'un joueur à l'autre

	public void shootGridAdversaire(Position position) {
		AbstractPlayer adversaire = (this.currentPlayer == this.humainPlayer) ? this.randomPlayer : this.humainPlayer;
	
		Cellule celluleAdversaire = adversaire.getGrid().getCellulePosition(position);
	
		if (celluleAdversaire.isAssignedShip()) {
			celluleAdversaire.setState(CellState.HIT);
		} else {
			celluleAdversaire.setState(CellState.MISSED);
		}
	
		this.currentPlayer = adversaire;
	}

	public void shipRandomVisible(){
		if(this.currentPlayer == this.randomPlayer){
			this.currentPlayer.putShipVisible();
		}
	}


	

	public void play() {
        while (!isOver()) {
            System.out.println(currentPlayer.getName() + " joue :");
            Position pos = currentPlayer.shoot();
            this.shootGridAdversaire(pos);
			this.getWinner();
        }

        if (this.getWinner() != null) {
            System.out.println("Le joueur " + getWinner().getName() + " a gagné !");
        } else {
            System.out.println("Match nul !");
        }
    }

	




	

	

	
}
