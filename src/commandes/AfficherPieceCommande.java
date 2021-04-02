package commandes;

import jeu.Partie;

public class AfficherPieceCommande extends Commande {

    private final Partie partie;

    public AfficherPieceCommande(Partie partie) {
        super("afficher_piece");
        this.partie = partie;
    }

    @Override
    public void executer(String[] args) {
        System.out.println("Listes de toutes les pièces disponibles à leur indice respectif:");
        for (int i = 0; i < this.partie.getPieceAPoser().size(); i++) {
            System.out.printf(" -(%s) %s%n", i, this.partie.getPieceAPoser().get(i));
        }
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_piece: Affiche les pièces restantes à poser sur la grille.");
    }
}
