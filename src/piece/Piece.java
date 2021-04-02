package piece;
import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;
import jeu.Carre;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Piece {

    //attributs

    /**
     * coordonnee du coin en haut a gauche de la piece
     * x est ordonne, y est abscisse (a cause des tableau)
     */
    private int x, y;

    /**
     * lettre d'identification
     */
    private char lettre;

    /**
     * carres qui composent la piece
     */
    private List<Carre> carres;

    //constructeurs
    public Piece (int pX, int pY, char pLettre, String nomFichier) throws CoordonneeInvalide, IOException, CharInvalide, ValeurNonTraite {

        //coordonnees
        if (pX < 0)
            throw new CoordonneeInvalide(pX, pY);
        if (pY < 0)
            throw new CoordonneeInvalide(pX, pY);
        this.x =pX;
        this.y = pY;

        //lettre
        if (!Character.isLetter(pLettre)){
            throw new CharInvalide(pLettre);
        }
        this.lettre = Character.toUpperCase(pLettre);
        this.carres = lireFichier(nomFichier);


    }

    //getter et setter

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public char getLettre() {
        return lettre;
    }

    public List<Carre> getCarres() {
        return carres;
    }

    //methode

    /**
     * methode qui lit les fichier contenant la forme de la piece
     * @param nomFichier nom du fichier contenant la forme
     * @return Liste avec tous les carres qui compose la piece
     * @throws IOException erreur de lecture
     * @throws Exception erreur dans le fichier
     */
    public static List<Carre> lireFichier(String nomFichier) throws IOException, CoordonneeInvalide, ValeurNonTraite {

        FileReader fileReader =  new FileReader(("fichiers/"+nomFichier));

        boolean fin = false;
        int x= 0;
        int y = 0;
        List<Carre> carreList = new ArrayList<Carre>();

        while(! fin){
            int curChar = fileReader.read();
            switch (curChar){

                case -1:
                    //fin fichier
                    fin=true;
                    break;
                case 10:
                    break;
                case 13:
                    //retour chariot
                    x++;
                    y = 0;
                    break;
                case 35:
                    //# represente un carre
                    carreList.add(new Carre(x, y));
                case 95:
                    //_ represente du vide
                    y++;
                    break;
                default:
                    throw new ValeurNonTraite((char) curChar);
            }
        }

        return carreList;

    }

    @Override
    public String toString() {
        return "Piece{" +
                "  lettre=" + lettre +
                ", carres=" + carres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (x != piece.x) return false;
        if (y != piece.y) return false;
        return (lettre != piece.lettre);
    }
}
