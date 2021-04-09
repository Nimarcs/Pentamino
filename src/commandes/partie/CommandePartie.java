package commandes.partie;

import commandes.Commande;
import partie.Joueur;

public abstract class CommandePartie extends Commande {

    public CommandePartie(String alias) {
        super(alias);
    }

    /**
     * Méthode abstraite pour exécuter la commande.
     * @param args commandes avec ses arguments
     * @param joueur joueur qui exécute la commande
     */
    public abstract void executer(String[] args, Joueur joueur);

}
