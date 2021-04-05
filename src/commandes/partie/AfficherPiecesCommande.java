package commandes.partie;

import jeu.Joueur;
import jeu.Partie;

public class AfficherPiecesCommande extends CommandePartie {


    public AfficherPiecesCommande() {
        super("afficher_piece");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        Partie partie = joueur.getLastPartie();
        System.out.println("Listes de toutes les pièces disponibles à leur indice respectif:");
        for (int i = 0; i < partie.getPieceAPoser().size(); i++) {
            System.out.printf(" -(%s) %s%n", i, partie.getPieceAPoser().get(i));
        }
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_piece: Affiche les pièces restantes à poser sur la grille.");
    }
}
