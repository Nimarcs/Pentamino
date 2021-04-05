package commandes.partie;

import exceptions.PartieInconnue;
import jeu.Joueur;

import java.util.Arrays;

public class PoserPieceCommande extends CommandePartie {

    public PoserPieceCommande() {
        super("ajouter_piece");
    }

    public void executer(String[] args, Joueur joueur) {
        System.out.println(Arrays.toString(args));
        if(args.length < 4) {
            super.erreur("Pas assez d'arguments.");
            return;
        }
        try {
            int numPiece = Integer.parseInt(args[1]);
            int posX = Integer.parseInt(args[2]);
            int posY = Integer.parseInt(args[3]);
            joueur.ajouterPiece(numPiece, posX, posY);
            try {
                joueur.getLastPartie().afficherGrille();
            } catch (PartieInconnue partieInconnue) {
                partieInconnue.printStackTrace();
            }
        } catch (NumberFormatException ignored) {
            super.erreur("Mauvais format pour les arguments.");
        }
    }

    public void afficherAide() {
        System.out.println(" -ajouter_piece <numeroPiece> <x> <y>: ajoute une pièce à l'indice numeroPiece aux coordonées [x,y].");
    }
}
