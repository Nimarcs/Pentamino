package commandes.partie;

import exceptions.PartieInconnue;
import partie.Joueur;
import partie.Partie;

public class AfficherPiecesCommande extends CommandePartie {


    public AfficherPiecesCommande() {
        super("afficher_pieces");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        Partie partie;
        try {
            partie = joueur.getLastPartie();
        } catch (PartieInconnue partieInconnue) {
            super.erreur("Echec du chargement en interne de la partie.");
            return;
        }
        System.out.println("Listes de toutes les pièces disponibles à leur indice respectif:");
        for (int i = 0; i < partie.getPieceAPoser().size(); i++) {
            System.out.printf(" -(%s) %n%s%n", i, partie.getPieceAPoser().get(i));
        }
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_pieces: Affiche les pièces restantes à poser sur la grille.");
    }
}
