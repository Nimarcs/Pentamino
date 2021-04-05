package jeu;

import commandes.Commande;

import java.util.Arrays;

public abstract class Joueur implements Comparable<Joueur> {

    //attributs

    private Partie[] parties;

    private String prenom;

    private int score;

    //contructeurs
    public Joueur(String prenom) {
        this.prenom = prenom;
        this.parties = new Partie[0];
        this.score = 0;
    }

    //getter et setter

    public int getScore() {
        return this.score;
    }

    public Partie[] getParties() {
        return this.parties;
    }

    public Partie getPartie(int index){
        if (index < this.parties.length && index > 0){
            return this.parties[index];
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
        Partie[] temp = new Partie[this.parties.length + 1];

        for (int i = 0; i < this.parties.length; i++){
            temp[i] = this.parties[i];
        }

        //TODO que faire si partie est null ?
        temp[temp.length -1] = partie;

        this.parties = temp;

    }

    public int compareTo(Joueur o) {
        if(this.score > o.score) return 1;
        if(this.score == o.score) return 0;
        return -1;
    }

    public abstract void calculerScore();

    public abstract void ajouterPiece(int num, int x, int y);

    @Override
    public String toString() {
        return this.prenom + " (" + this.score + ")";
    }

    public String getPrenom() {
        return prenom;
    }
}
