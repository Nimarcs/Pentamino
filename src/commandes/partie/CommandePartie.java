package commandes.partie;

import commandes.Commande;
import jeu.Joueur;

public abstract class CommandePartie extends Commande {

    public CommandePartie(String alias) {
        super(alias);
    }

    public abstract void executer(String[] args, Joueur joueur);

}
