package commandes.partie;

import exceptions.PartieInconnue;
import partie.Joueur;

public class AfficherGrilleCommande extends CommandePartie {

    public AfficherGrilleCommande() {
        super("afficher_grille");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        try {
            joueur.getLastPartie().afficherGrille();
        } catch (PartieInconnue partieInconnue) {
            partieInconnue.printStackTrace();
        }
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_grille: Affiche la grille actuelle.");
    }
}
