package piece;
import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui permet de creer des pieces
 * sert de modele pour differentes pieces
 */
public class Piece implements Serializable {

    //attributs

    /**
     * coordonnee du coin en haut a gauche de la piece
     * x est l'ordonne (vertical), y est l'abscisse (horizontal) (a cause des tableau)
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

    /**
     * Constructeur de piece
     * @param pX coordonee du l'ordonnee du coin supérieur droit de la piece
     * @param pY coordonee du l'abscisse du coin supérieur droit de la piece
     * @param pLettre lettre correspondant a la piece pose
     * @param nomFichier nom du fichier correspondant a la piece
     * @throws CoordonneeInvalide renvoye si les coordonnee sont hors du terrain
     * @throws IOException renvoye en cas d'erreur dans lireFichier
     * @throws CharInvalide renvoye si pLettre n'est pas un char valide
     * @throws ValeurNonTraite revoye en cas d'erreur dans lireFichier
     */
    protected Piece (int pX, int pY, char pLettre, String nomFichier) throws CoordonneeInvalide, IOException, CharInvalide, ValeurNonTraite {

        //coordonnees
        //les coordonees ne peuvent pas être completement verifier ici et doivent etre fournit correcte
        //si les coordonees sortent de la grille en positif ce n'est pas traite
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

    public void setCoordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * getteur de Y
     * @return abscisse du coin superieur gauche de la piece
     */
    public int getY() {
        return y;
    }

    /**
     * getteur de X
     * @return ordonnee du coin superieur gauche de la piece
     */
    public int getX() {
        return x;
    }

    /**
     * getteur de lettre
     * @return lettre representant la piece
     */
    public char getLettre() {
        return lettre;
    }

    /**
     * getteur de carres
     * @return liste de Carre composant la piece
     */
    public List<Carre> getCarres() {
        return carres;
    }

    //methode


    /**
    * methode qui lit les fichier contenant la forme de la piece
    * @param nomFichier nom du fichier contenant la forme
    * @return Liste avec tous les carres qui compose la piece
    * @throws IOException erreur de lecture
    * @throws CoordonneeInvalide renvoye en cas d'erreur dans Carre
    * @throws ValeurNonTraite erreur car le fichier contient des carateres non pris en compte
    */
    public static List<Carre> lireFichier(String nomFichier) throws IOException, CoordonneeInvalide, ValeurNonTraite {

        //ouverture du fichier
        FileReader fileReader =  new FileReader(("fichiers/"+nomFichier));

        //Creation de variable de traitement
        boolean fin = false;
        int x= 0;
        int y = 0;
        List<Carre> carreList = new ArrayList<Carre>();

        //boucle tant que le fichier n'est pas fini
        while(! fin){

            int curChar = fileReader.read();

            //teste le dernier char lus
            switch (curChar){

                case -1:
                    //fin fichier
                    fin=true;
                    break;

                case 10:
                    //retour a la ligne
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
                    //char non traite remonte une erreur
                    throw new ValeurNonTraite((char) curChar);
            }
        }

        return carreList;

    }

    @Override
    public String toString() {
        //initalisation
        String res = "";
        int maxX = this.carres.get(0).getX(), maxY =  this.carres.get(0).getY(); //determine la taille de la piece
        //on recupere la taille de la piece
        for(int i = 1; i < this.carres.size(); i++){
            if (maxX < this.carres.get(i).getX())
                maxX = this.carres.get(i).getX();
            if (maxY < this.carres.get(i).getY())
                maxY = this.carres.get(i).getY();
        }
        //on initalise le string de la piece
        for (int i = 0; i<= maxX;  i++){
            for (int j = 0; j <= maxY; j++){
                res += "_";
            }
            res += "\n";
        }
        //on transforme res en tableau de char pour travailler dessus
        char [] tab =  res.toCharArray();
        //on place les #
        for (int i = 0; i < this.carres.size(); i++){
            int pos = this.carres.get(i).getY();
            if (this.carres.get(i).getX() > 0)
                pos += (maxY+2) * this.carres.get(i).getX();

            tab[pos] = '#';
        }
        //on retransforme en String
        res = new String(tab);
        //on retire le retour a la ligne en trop
        res = res.substring(0, res.length()-1);
        return res;
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
