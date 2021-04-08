package jeu;

import exceptions.*;

import java.util.List;

public class JoueurDebutant extends Joueur {

    //contructeurs

    public JoueurDebutant(String prenom){
        super(prenom);
    }

    //methodes


    public void calculerScore(){
        double score = 0;
        List<Partie> parties= this.getParties();
        for (int i = 0; i < parties.size(); i++){
            score += parties.get(i).getScore() * 0.25;//0.25 multiplicateur car debutant
        }
        this.setScore(score);
    }

    @Override
    public void ajouterPiece(int num, int x, int y) throws CoordonneeInvalide, NumeroInconnue, PartieInconnue {
        Partie partie = this.getLastPartie();
        try {
            partie.testerPosePiece(num, x, y);
            partie.ajouterPiece(num, x, y);
        } catch (CaseDejaOccupe | PieceDebordeTerrain caseDejaOccupe) {
            partie.ajouterPiece(num, x, y);
        }
    }


}
