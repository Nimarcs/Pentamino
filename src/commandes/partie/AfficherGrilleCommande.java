package commandes.partie;

import jeu.Joueur;

public class AfficherGrilleCommande extends CommandePartie {

    public AfficherGrilleCommande() {
        super("afficher_grille");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        joueur.getLastPartie().afficherGrille();
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_grille: Affiche la grille actuelle.");
    }
}
