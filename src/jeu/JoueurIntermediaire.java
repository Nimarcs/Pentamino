package jeu;

import exceptions.*;

import java.util.List;

public class JoueurIntermediaire extends Joueur {

    //constructeurs

    public JoueurIntermediaire(String prenom){
        super(prenom);
    }

    //methodes

    public void calculerScore() {
        double score = 0;
        List<Partie> parties= this.getParties();
        for (int i = 0; i < parties.size(); i++){
            score += parties.get(i).getScore() * 0.5;//0.5 multiplicateur car Intermediaire
        }
        this.setScore(score);
    }

    @Override
    public void ajouterPiece(int num, int x, int y) throws CoordonneeInvalide, NumeroInconnue, PartieInconnue, PlacementInterdit {
        Partie partie = this.getLastPartie();
        try {
            partie.testerPosePiece(num, x, y);
            partie.forcerPosePiece(num, x, y);
        } catch (PieceDebordeTerrain caseDejaOccupe) {
            partie.forcerPosePiece(num, x, y);
        } catch (CaseDejaOccupe caseDejaOccupe) {
            throw new PlacementInterdit("Vous ne pouvez pas superposer les pièces.");
        }
    }

}
