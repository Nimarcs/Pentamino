package piece;
import jeu.Carre;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    //attributs

    /**
     * coordonnee du coin en haut a gauche de la piece
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
    public Piece (int pX, int pY, char pLettre, String nomFichier) throws IOException, Exception{

        //coordonnees
        this.x =pX; // voir les execeptions
        this.y = pY;

        //lettre
        if (!Character.isLetter(pLettre)){
            //lancer erreur
        }
        this.lettre = Character.toUpperCase(pLettre);
        this.carres = lireFichier(nomFichier , pX ,pY);


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
     * @param pX abscisse du coin superieur gauche de la piece
     * @param pY ordonnee du coin superieur gauche de la piece
     * @return Liste avec tous les carres qui compose la piece
     * @throws IOException erreur de lecture
     * @throws Exception erreur dans le fichier
     */
    public static List<Carre> lireFichier(String nomFichier, int pX , int pY) throws IOException, Exception {

        FileReader fileReader =  new FileReader(nomFichier);

        boolean fin = false;
        int x= pX;
        int y = pY;
        List<Carre> carreList = new ArrayList<Carre>();

        while(! fin){
            int curChar = fileReader.read();
            switch (curChar){

                case -1:
                    //fin fichier
                    fin=true;
                    break;

                case 10:
                case 13:
                    //retour chariot
                    y++;
                    break;
                case 35:
                    //# represente un carre
                    carreList.add(new Carre(x, y));
                case 95:
                    //_ represente du vide
                    x++;
                    break;
                default:
                    throw new Exception ("Valeur non traite dans le fichier");
            }
        }

        return carreList;

    }

}
