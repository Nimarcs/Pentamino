package commandes;

import piece.Piece;

import java.util.List;

public class AfficherPieceCommande extends Commande {

    private final List<Piece> pieces;

    public AfficherPieceCommande(List<Piece> pieces) {
        super("afficher_piece");
        this.pieces = pieces;
    }

    @Override
    public void executer(String[] args) {
        System.out.println("Listes de toutes les pièces disponibles à leur indice respectif:");
        for (int i = 0; i < this.pieces.size(); i++) {
            System.out.printf(" -(%s) %s%n", i, this.pieces.get(i));
        }
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_piece: Affiche les pièces restantes à poser sur la grille.");
    }
}
