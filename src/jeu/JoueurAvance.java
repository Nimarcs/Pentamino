package jeu;

import exceptions.*;

import java.util.List;

public class JoueurAvance extends Joueur{

    //constructeurs

    public JoueurAvance(String prenom){
        super(prenom);
    }

    //methodes

    public void calculerScore() {
        double score = 0;
        List<Partie> parties= this.getParties();
        for (int i = 0; i < parties.size(); i++){
            score += parties.get(i).getScore() * 1; //1 multiplicateur car Avance
        }
        this.setScore(score);
    }


    public void ajouterPiece(int num, int x, int y) throws PartieInconnue, CoordonneeInvalide, NumeroInconnue, PlacementInterdit {
        Partie partie = this.getLastPartie();
        try {
            partie.testerPosePiece(num, x, y);
            partie.forcerPosePiece(num, x, y);
        } catch (PieceDebordeTerrain caseDejaOccupe) {
            throw new PlacementInterdit("Vous ne pouvez pas avoir des pièces débordant du terrain.");
        } catch (CaseDejaOccupe caseDejaOccupe) {
            throw new PlacementInterdit("Vous ne pouvez pas superposer les pièces.");
        }
    }
}
