package jeu;

import exceptions.*;

import java.util.List;

public class JoueurAvance extends Joueur{

    //constructeurs

    public JoueurAvance(){
        super();
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


    public void ajouterPiece(int num, int x, int y) {
        try {
            this.getLastPartie().ajouterPiece(num, x, y);
        } catch (PieceDebordeTerrain pieceDebordeTerrain) {
            pieceDebordeTerrain.printStackTrace();
        } catch (CaseDejaOccupe caseDejaOccupe) {
            caseDejaOccupe.printStackTrace();
        } catch (NumeroInconnue numeroInconnue) {
            numeroInconnue.printStackTrace();
        } catch (PartieInconnue partieInconnue) {
            partieInconnue.printStackTrace();
        } catch (CoordonneeInvalide coordonneeInvalide) {
            coordonneeInvalide.printStackTrace();
        }
    }
}
