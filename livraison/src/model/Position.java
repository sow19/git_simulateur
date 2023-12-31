package model;
/**
 * classe representant les coordonnées d'une case d'un tableau
 */
public class Position{
    private int x;
    private int y;

    /**
     * Constructeur de la classe
     * @param x : represente la coordonnée en ligne
     * @param y : represente la coordonnée en colonne
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getters et setters
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
    }

    

    
}