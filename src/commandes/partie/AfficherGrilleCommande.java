package commandes.partie;

import exceptions.AucunePartie;
import partie.Joueur;

public class AfficherGrilleCommande extends CommandePartie {

    public AfficherGrilleCommande() {
        super("afficher_grille");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        try {
            joueur.getPartieActuelle().afficherGrille();
        } catch (AucunePartie partieInconnue) {
            super.erreur("Vous n'avez pas choisis de partie dans laquelle jouer.");
        }
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_grille: Affiche la grille actuelle.");
    }
}
