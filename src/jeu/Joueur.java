package jeu;

import exceptions.PartieInconnue;

import java.util.ArrayList;
import java.util.List;

public abstract class Joueur {

    //attributs

    private List<Partie> parties;

    private int score;

    //contructeurs
    public Joueur(){
        this.parties = new ArrayList<Partie>();
        this.score = 0;
    }

    //getter et setter

    public int getScore() {
        return this.score;
    }

    public List<Partie> getParties() {
        return this.parties;
    }

    public Partie getPartie(int index) throws PartieInconnue {
        if (index < this.parties.size() && index > 0){
            return this.parties.get(index);
        } else{
            return null;
        }
    }

    public Partie getLastPartie(){
        if (this.parties.length == 0)
            return null;
        return this.parties[this.parties.length -1];
    }

    //methodes

    public void ajouterPartie(Partie partie){
        this.parties.add(partie);
    }

    public abstract void calculerScore();

    public abstract void ajouterPiece(int num, int x, int y);




}
