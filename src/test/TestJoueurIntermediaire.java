package test;

import exceptions.*;
import org.junit.Test;
import partie.JoueurIntermediaire;
import partie.Partie;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestJoueurIntermediaire {

    @Test
    public void test_constructeur_normal() {
        //preparation des donnees
        JoueurIntermediaire joueurIntermedaire;

        //methode teste
        joueurIntermedaire = new JoueurIntermediaire("Kurisu");

        //assertions
        assertEquals("Le score initial doit être à 0", 0, joueurIntermedaire.getScore(), 0);
        assertEquals("La liste de partie doit être vide", 0, joueurIntermedaire.getParties().size());
    }

    @Test
    public void test_ajouterPiece_normal() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException, PlacementInterdit {
        //preparation des donnees
        JoueurIntermediaire joueurIntermediaire = new JoueurIntermediaire("Subaru");
        joueurIntermediaire.creerPartie(10, 10);
        Partie partie = joueurIntermediaire.getPartieActuelle();

        //methode teste
        joueurIntermediaire.ajouterPiece(0, 0, 0);

        //assertions
        assertEquals("La pièce doit être posé", 1, partie.getPiecePosees().size());
    }

    @Test(expected = PlacementInterdit.class)
    public void test_ajouterPiece_caseDejaOccupe() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException, PlacementInterdit {
        //preparation des donnees
        JoueurIntermediaire joueurIntermediaire = new JoueurIntermediaire("Emilia");
        joueurIntermediaire.creerPartie(10, 10);
        Partie partie = joueurIntermediaire.getPartieActuelle();

        //methode teste
        joueurIntermediaire.ajouterPiece(0, 0, 0);
        joueurIntermediaire.ajouterPiece(0, 0, 0);

        //assertions
        //doit throw exception
    }

    @Test
    public void test_ajouterPiece_pieceDeborde() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException, PlacementInterdit {
        //preparation des donnees
        JoueurIntermediaire joueurIntermediaire = new JoueurIntermediaire("Yugo");
        joueurIntermediaire.creerPartie(10, 10);
        Partie partie = joueurIntermediaire.getPartieActuelle();

        //methode teste
        joueurIntermediaire.ajouterPiece(0, 9, 0);

        //assertions
        assertEquals("La pièce doit être posé", 1, partie.getPiecePosees().size());
    }

    @Test
    public void test_calculerScore_normal() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException, PlacementInterdit {
        //preparation des donnees
        JoueurIntermediaire joueurIntermediaire = new JoueurIntermediaire("Oropo");
        joueurIntermediaire.creerPartie(10, 10);
        Partie partie = joueurIntermediaire.getPartieActuelle();
        joueurIntermediaire.ajouterPiece(0, 0, 0);
        joueurIntermediaire.calculerScore();

        //methode teste
        double score = joueurIntermediaire.getScore();

        //assertions
        assertEquals("Le score doit être de 0.5", 0.5, score, 0);
    }

}
