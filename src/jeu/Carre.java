package jeu;

public class Carre {

    //attributs

    /**
     * coordonnee du carre par rapport au coin superieur gauche de la piece
     */
    private int x, y;

    //Contructeurs

    /**
     * Contructeur de jeu.Carre
     * @param pX abcsisse du carre
     * @param pY ordonnee du carre
     */
    public Carre(int pX, int pY){
        this.x = pX;
        this.y = pY;
    }

    //getters et setters

    /**
     * getter de x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter de y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * setter de x
     * @param x nouvelle valeur de x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setter de y
     * @param y nouvelle valeur de y
     */
    public void setY(int y) {
        this.y = y;
    }

    //methodes
}
