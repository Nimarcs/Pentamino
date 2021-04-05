package jeu;

public abstract class Joueur {

    //attributs

    private Partie[] parties;

    private int score;

    //contructeurs
    public Joueur(){
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
        Partie[] temp = new Partie[this.parties.length +1];

        for (int i = 0; i < this.parties.length; i++){
            temp[i] = this.parties[i];
        }

        //TODO que faire si partie est null ?
        temp[temp.length -1] = partie;

        this.parties = temp;

    }

    public abstract void calculerScore();


}
