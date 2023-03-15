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


	//cette méthode retourne la joueur courant

	public AbstractPlayer getWinner() {
        if (this.humainPlayer.isLost()) {
            return this.randomPlayer;
        } else if (this.randomPlayer.isLost()) {
            return this.humainPlayer;
        }
		return null; 
    }


	//cette méthode vérifie le gagant
    public boolean isOver() {
        return (getWinner() != null);
    }
	

	//cette méthode permet de changer le joueur courant
	public AbstractPlayer changeCurenPlayer(){
		if(this.currentPlayer == this.humainPlayer){
			return this.randomPlayer;
		}else if(this.currentPlayer == this.randomPlayer){
			return this.humainPlayer;
		}
		return null;
	}

	//cette methode permet de passer la grille d'un joueur à l'autre

	public void testShoot(Position position) {
		AbstractPlayer adversaire = (this.currentPlayer == this.humainPlayer) ? this.randomPlayer : this.humainPlayer;
	
		Cellule celluleAdversaire = adversaire.getGrid().getCellulePosition(position);
	
		if (celluleAdversaire.isAssignedShip()) {
			celluleAdversaire.setState(CellState.HIT);
		} else {
			celluleAdversaire.setState(CellState.MISSED);
		}
	
		this.currentPlayer = adversaire;
	}


	

	public void play() {
        while (!isOver()) {
            System.out.println(currentPlayer.getName() + " joue :");
            Position pos = currentPlayer.shoot();
            currentPlayer.getGrid().testShoot(pos);
            this.changeCurenPlayer();
			this.getWinner();
        }

        if (this.getWinner() != null) {
            System.out.println("Le joueur " + getWinner().getName() + " a gagné !");
        } else {
            System.out.println("Match nul !");
        }
    }

	




	

	

	
}
