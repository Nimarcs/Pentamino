package partie;

import exceptions.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Joueur implements Comparable<Joueur>, Serializable {

    //attributs

    private List<Partie> parties;

    private double score;

    private String prenom;

    //contructeurs
    public Joueur(String prenom){
        this.prenom = prenom;
        this.parties = new ArrayList<Partie>();
        this.score = 0;
    }

    //getter et setter

    public String getPrenom() {
        return prenom;
    }

    public double getScore() {
        return this.score;
    }

    protected void setScore(double score) {
        this.score = score;
    }

    public List<Partie> getParties() {
        return this.parties;
    }

    /**
     * Méthode retournant la partie actuelle d'un joueur
     * @return partie actuelle d'un joueur
     * @throws PartieInconnue cas ou il n'a aucune partie
     */
    public Partie getLastPartie() throws PartieInconnue {
        if (this.parties.size() == 0)
            throw new PartieInconnue(-1);
        return this.parties.get(this.parties.size() -1);
    }

    //methodes

    public abstract void calculerScore();

    /**
     * Méthode pour ajouter une pièce dans sa dernière partie (partie en cours)
     * @param num numéro de pièce
     * @param x posX
     * @param y posY
     * @throws CoordonneeInvalide x ou y < 0 ou > taille du tableau
     * @throws NumeroInconnue num n'est pas un indice valide
     * @throws PartieInconnue le joueur n'a aucune partie
     * @throws PlacementInterdit le placement désiré est interdis par le mode de jeu
     */
    public abstract void ajouterPiece(int num, int x, int y) throws CoordonneeInvalide, NumeroInconnue, PartieInconnue, PlacementInterdit;

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
    }

    public int compareTo(Joueur o) {
        return Double.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        //%10s signifie que le string prendra 10 char dans tout les cas et rajoutera des ' ' si necessaire a gauche
        //%06.2f signifie que le score prendra 6 char (virgule comprise) dont deux apres la virgule
        // si ce n'est pas assez grand ça rajoute des 0
        return String.format("%10s (%06.2f)",this.prenom , this.score );
    }

}
