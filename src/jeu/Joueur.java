package jeu;

import exceptions.*;

import java.io.IOException;
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

    public abstract void ajouterPiece(int num, int x, int y);

    public void creerPartie(int x , int y) throws DimensionsInvalide, CharInvalide, CoordonneeInvalide, IOException, ValeurNonTraite {
        Partie partie = new Partie(x, y);
        this.parties.add(partie);
    }




}
