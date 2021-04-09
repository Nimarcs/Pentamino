package commandes.jeu;

import commandes.Commande;
import jeu.Jeu;

public abstract class CommandeJeu extends Commande {

    public CommandeJeu(String alias) {
        super(alias);
    }

    /**
     * Méthode servant à exécuter une commande sur un jeu
     * @param args commande avec arguments
     * @param jeu jeu
     */
    public abstract void executer(String[] args, Jeu jeu);

}
