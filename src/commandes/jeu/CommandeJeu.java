package commandes.jeu;

import commandes.Commande;
import jeu.Jeu;
import jeu.Joueur;

public abstract class CommandeJeu extends Commande {

    public CommandeJeu(String alias) {
        super(alias);
    }

    public abstract void executer(String[] args, Jeu jeu);

}
