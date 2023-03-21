package model;
import java.util.Scanner;
import config.Config;

/**
 * Classe représentant un joueur humain du jeu de bataille navale.
 */
public class HumanPlayer  extends AbstractPlayer{
	
	/**
	 * Constructeur de la classe.
	 * Initialise le joueur avec un nom, une grille de jeu vide et une flotte vide.
	 * @param name Le nom du joueur.
	 * @param grid la grille du joueur
	 */
	public HumanPlayer(Grid grid,String name) {
		super(grid,name);	
	}


/**
 * Demande à l'utilisateur de choisir une position sur le plateau
 * et retourne la position choisie sous forme d'objet Position.
 * La méthode s'assure que la position choisie est valide (de forme A1, A2, ..., J10),
 * et lève une exception si la position choisie n'est pas valide.
 * @return l'objet Position correspondant à la position choisie par l'utilisateur
 * @throws IllegalArgumentException si la position choisie n'est pas valide
 */
	public Position shoot(){
		//initialisation des variables
		Scanner scanner = new Scanner(System.in);
		String entree="";
		int x =0, y =0;
		
		// Boucle tant que l'entrée n'est pas de forme A1
		do {
			System.out.println("Choisissez une case (ex : A1) : ");
			entree = scanner.nextLine();
			//verifie si l'entree est de la forme A1
			if (entree.length() == 2 && Character.isLetter(entree.charAt(0)) && Character.isDigit(entree.charAt(1)) && Character.isUpperCase(entree.charAt(0))) {
				x = entree.charAt(0) - 'A';
				y = Character.getNumericValue(entree.charAt(1));
				//lève une exception si la premiere lettre est un caractère
			}else if (Character.isDigit(entree.charAt(0))) {
				throw new IllegalArgumentException("La première lettre doit être une lettre majuscule");

				//lève une exception si la deuxième lettre est un caractère
			}else if(Character.isLetter(entree.charAt(1))){
				throw new IllegalArgumentException("La deuxième lettre doit être un entier");
			}else{
				System.out.println("entrée invalide");
			} 
			
		} while (!(entree.length() == 2 && Character.isLetter(entree.charAt(0)) && Character.isDigit(entree.charAt(1)) && Character.isUpperCase(entree.charAt(0))));
		
		return new Position(x,y);

	}

	


	/**
	 * met tous les navires du joueur en mode visible
	 */
	public void putShipVisible(){
		for(Ship ship : this.fleet){
			ship.setVisible(true);	
		}
	}
	
	/**
	 * cette méthode permet au joueur humain d'ajouter ses navires
	 */

	public void humainAddShip(){
		 // création d'un objet Scanner pour lire les entrées de l'utilisateur
		Scanner entree = new Scanner(System.in);
		// initialisation de la variable pour stocker les caractéristiques du navire
		String carac = "";

		 // boucle pour chaque taille de navire dans le tableau Config.sizeShips
		
		for(int i = 0; i < Config.sizeShips.length;i++){
			 // variable booléenne pour vérifier si le navire a été ajouté à la grille
			boolean added = false;
			while(!added){	
				//saisi des coordonnees
				System.out.print("choisissez une coordonnée X  pour votre navire " +(i+1)+" ");
				int x = entree.nextInt();
				System.out.print("choisissez une coordonnée Y  pour votre navire  "+(i+1)+" ");
				int y = entree.nextInt();
				//horizontale ou verticale
				do{		
				System.out.print("votre navire est verticale ou horizontale(ve/ho)");
				carac = entree.nextLine();
				}while (!carac .equals("ve") && !carac.equals("ho"));
				//ajout du navire
				if(carac.equals("ve")){
					added = this.addShip(x,y, new Ship(Config.sizeShips[i]), true);
					
				}else{
					added = this.addShip(x,y, new Ship(Config.sizeShips[i]), false);		
				}
				if(added){
					System.out.print("ajouté\n");
					this.grid.afficher();
				}else{
					System.out.print("non ajouté\n");
				}

			}
				
			

		}

	}
}
