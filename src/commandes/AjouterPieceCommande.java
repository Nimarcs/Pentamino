package commandes;

import exceptions.*;
import jeu.Jeu;
import jeu.Partie;

import java.util.Arrays;

public class AjouterPieceCommande extends Commande {

    private final Partie partie;

    public AjouterPieceCommande(Partie partie) {
        super("ajouter_piece");
        this.partie = partie;
    }

    public void executer(String[] args) {
        System.out.println(Arrays.toString(args));
        if(args.length < 4) {
            this.afficherAide();
            return;
        }
        try {
            int numPiece = Integer.parseInt(args[1]);
            int posX = Integer.parseInt(args[2]);
            int posY = Integer.parseInt(args[3]);
            this.partie.ajouterPiece(numPiece, posX, posY);
            this.partie.afficherGrille();
        } catch (NumberFormatException ignored) {
            System.out.println("Erreur: Mauvais format pour les arguments");
            this.afficherAide();
        } catch (PieceDebordeTerrain | CaseDejaOccupe | NumeroInconnue | PieceEmpietePiece | CoordonneeInvalide pieceDebordeTerrain) {
            pieceDebordeTerrain.printStackTrace();
        }

    }

    public void afficherAide() {
        System.out.println(" -ajouter_piece <numeroPiece> <x> <y>: ajoute une pièce à l'indice numeroPiece aux coordonées [x,y].");
    }
}
