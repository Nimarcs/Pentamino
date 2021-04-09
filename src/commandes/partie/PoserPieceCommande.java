package commandes.partie;

import exceptions.CoordonneeInvalide;
import exceptions.NumeroInconnue;
import exceptions.PartieInconnue;
import exceptions.PlacementInterdit;
import partie.Joueur;

public class PoserPieceCommande extends CommandePartie {

    public PoserPieceCommande() {
        super("poser_piece");
    }

    public void executer(String[] args, Joueur joueur) {
        if(args.length < 4) {
            super.erreur("Pas assez d'arguments.");
            return;
        }
        //On s'assure que les arguments sont bien des entiers.
        int numPiece = -1, posX = -1, posY = -1;
        try {
            numPiece = Integer.parseInt(args[1]);
            posX = Integer.parseInt(args[2]);
            posY = Integer.parseInt(args[3]);
        } catch (NumberFormatException ignored) {
            super.erreur("Mauvais format pour les arguments.");
        }
        try {
            joueur.ajouterPiece(numPiece, posX, posY);
            joueur.getLastPartie().afficherGrille();
        } catch (CoordonneeInvalide coordonneeInvalide) {
            super.erreur("Les coordonnées doivent être positives et inférieur à la taille de la grille.");
        } catch (NumeroInconnue numeroInconnue) {
            super.erreur("Le numéro de pièce fournit (" + numPiece + ") n'a pas de pièce associé.");
        } catch (PartieInconnue partieInconnue) {
            super.erreur("Echec en interne du chargement de la partie.");
        } catch (PlacementInterdit placementInterdit) {
            super.erreur(placementInterdit.getMessage());
        }
    }

    public void afficherAide() {
        System.out.println(" -poser_piece <numeroPiece> <x> <y>: ajoute une pièce à l'indice numeroPiece aux coordonées [x,y].");
    }
}
