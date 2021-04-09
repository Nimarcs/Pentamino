package commandes.partie;

import exceptions.AucunePiecePlace;
import exceptions.PartieInconnue;
import jeu.Joueur;
import jeu.Partie;

public class RetirerDernierPieceCommande extends CommandePartie {

    public RetirerDernierPieceCommande() {
        super("retirer_derniere_piece");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -retirer_derniere_piece: Retire la dernière pièce joué sur la partie");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        try {
            Partie partie = joueur.getLastPartie();
            partie.retirerDernierePiece();
            partie.afficherGrille();
        } catch (PartieInconnue partieInconnue) {
            super.erreur("Echec en interne du chargement de la partie.");
        } catch (AucunePiecePlace aucunePiecePlace) {
            super.erreur("Vous n'avez encore placé aucune pièce.");
        }
    }
}
