package commandes.jeu;

import jeu.Jeu;

public class ChoisirJoueurCommande extends CommandeJeu {

    public ChoisirJoueurCommande() {
        super("choisir_joueur");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -choisir_joueur <indice_du_joueur_choisis>: Choisis le joueur avec lequel on va jouer.");
    }

    @Override
    public void executer(String[] args, Jeu jeu) {
        if(args.length < 2) {
            this.afficherAide();
            return;
        }
        try {
            int indice = Integer.parseInt(args[1]);
            jeu.setJoueurCourant(indice);
        } catch (NumberFormatException ignored) {
            System.out.println("Erreur: " + args[1] + " n'est pas un entier");
            this.afficherAide();
        }
    }
}
