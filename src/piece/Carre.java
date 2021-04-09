package piece;


import exceptions.CoordonneeInvalide;

public class Carre {

    //attributs

    /**
     * coordonnee du carre par rapport au coin superieur gauche de la piece
     */
    private int x, y;

    //Contructeurs

    /**
     * Contructeur de piece.Carre
     * @param pX abcsisse du carre
     * @param pY ordonnee du carre
     */
    public Carre(int pX, int pY) throws CoordonneeInvalide {
        if (pX < 0)
            throw new CoordonneeInvalide(pX, pY);
        if (pY < 0)
            throw new CoordonneeInvalide(pX, pY);
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
    public void setX(int x) throws CoordonneeInvalide {
        if (x < 0)
            throw new CoordonneeInvalide(x, this.y);
        this.x = x;
    }

    /**
     * setter de y
     * @param y nouvelle valeur de y
     */
    public void setY(int y) throws CoordonneeInvalide {
        if (y < 0)
            throw new CoordonneeInvalide(this.x, y);
        this.y = y;
    }

    @Override
    public String toString() {
        return "Carre{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //methodes
}
