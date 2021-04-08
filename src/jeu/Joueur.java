package jeu;

import commandes.jeu.CommandeJeu;
import exceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Joueur implements Comparable<Joueur> {

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

    public Partie getPartie(int index) throws PartieInconnue {
        if (index < this.parties.size() && index > 0){
            return this.parties.get(index);
        } else{
            throw new PartieInconnue(index);
        }
    }

    public Partie getLastPartie() throws PartieInconnue {
        if (this.parties.size() == 0)
            throw new PartieInconnue(-1);
        return this.parties.get(this.parties.size() -1);
    }

    //methodes

    public abstract void calculerScore();

    public abstract void ajouterPiece(int num, int x, int y) throws CoordonneeInvalide, NumeroInconnue, PartieInconnue, PlacementInterdit;

    public void creerPartie(int x , int y) throws CharInvalide, CoordonneeInvalide, IOException, ValeurNonTraite {
        Partie partie = new Partie(x, y);
        this.parties.add(partie);
    }

    public int compareTo(Joueur o) {
        return Double.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return this.prenom + " (" + this.score + ")";
    }

}
