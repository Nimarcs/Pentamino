package partie;

import exceptions.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Joueur implements Comparable<Joueur>, Serializable {

    //attributs

    /**
     * parties jouee (y compris la partie actuelle)
     */
    private List<Partie> parties;

    /**
     * partie en cours
     */
    private Partie partieActuelle;

    /**
     * score du joueur (calcule grace au parties)
     */
    private double score;

    /**
     * prenom choisi par le joueur
     */
    private String prenom;

    //contructeurs

    /**
     * Constructeur de Joueur
     * @param prenom prenom du joueur
     */
    public Joueur(String prenom){
        this.prenom = prenom;
        this.parties = new ArrayList<Partie>();
        this.score = 0;
    }

    //getter et setter

    /**
     * getter de prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * getter de score
     * @return score
     */
    public double getScore() {
        return this.score;
    }

    /**
     * setter de score
     * @param score score a inserer
     */
    protected void setScore(double score) {
        if (score > 0)
            this.score = score;
    }

    /**
     * getter de parties
     * @return parties
     */
    public List<Partie> getParties() {
        return this.parties;
    }

    //methodes

    /**
     * methode permettant de calculer/recalculer le score du joueur
     */
    public abstract void calculerScore();

    /**
     * Méthode pour ajouter une pièce dans sa dernière partie (partie en cours)
     * @param num numéro de pièce
     * @param x posX
     * @param y posY
     * @throws CoordonneeInvalide x ou y < 0 ou > taille du tableau
     * @throws NumeroInconnue num n'est pas un indice valide
     * @throws PlacementInterdit le placement désiré est interdis par le mode de jeu
     */
    public abstract void ajouterPiece(int num, int x, int y) throws CoordonneeInvalide, NumeroInconnue, PlacementInterdit, AucunePartie;

    /**
     * Méthode permettant de créer une partie avec une grille de x par y
     * @param x tailleX
     * @param y tailleY
     * @throws CharInvalide erreur interne lors du chargement des pièces
     * @throws CoordonneeInvalide x ou y < 0
     * @throws IOException erreur interne lors du chargement des pièces
     * @throws ValeurNonTraite erreur interne lors du chargement des pièces
     */
    public void creerPartie(int x , int y) throws CharInvalide, CoordonneeInvalide, IOException, ValeurNonTraite {
        Partie partie = new Partie(x, y);
        this.parties.add(partie);
        this.partieActuelle = partie;
    }

    /**
     * methode permettant de comparer deux joueur
     * utilise le score
     * @param o joueur avec qui le comparer
     * @return entier positif, nul ou negatif en fonction de si this est au dessous, equal ou au dessus du joueur donne
     */
    public int compareTo(Joueur o) {
        return Double.compare(o.score, this.score);
    }

    /**
     * methode retournant les informations liee au joueur formate
     * @return informations liee au joueur formate
     */
    @Override
    public String toString() {
        //%10s signifie que le string prendra 10 char dans tout les cas et rajoutera des ' ' si necessaire a gauche
        //%06.2f signifie que le score prendra 6 char (virgule comprise) dont deux apres la virgule
        // si ce n'est pas assez grand ça rajoute des 0
        return String.format("%10s (%06.2f)",this.prenom , this.score );
    }

    /**
     * getter de la partie actuelle
     * @return partie actuelle
     * @throws AucunePartie renvoye si il ni a pas de partie en cours
     */
    public Partie getPartieActuelle() throws AucunePartie {
        if(this.partieActuelle == null) throw new AucunePartie();
        return partieActuelle;
    }

    /**
     * setter de la partie actuelle
     * @param indice indice de la partie dans parties
     * @throws PartieInconnue renvoye si la partie n'est pas trouve
     */
    public void setPartieActuelle(int indice) throws PartieInconnue {
        if(indice < 0) throw new PartieInconnue(indice);
        if(indice >= this.parties.size()) throw new PartieInconnue(indice);
        this.partieActuelle = this.parties.get(indice);
    }
}
