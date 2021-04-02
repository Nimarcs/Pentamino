package commandes;

import jeu.Partie;

public class AfficherGrilleCommande extends Commande {

    private final Partie partie;

    public AfficherGrilleCommande(Partie partie) {
        super("afficher_grille");
        this.partie = partie;
    }

    @Override
    public void executer(String[] args) {
        this.partie.afficherGrille();
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_grille: Affiche la grille actuelle.");
    }
}
