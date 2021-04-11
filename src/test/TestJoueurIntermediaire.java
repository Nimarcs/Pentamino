package test;

import exceptions.*;
import org.junit.Test;
import partie.JoueurIntermediaire;
import partie.Partie;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * test de la classe JoueurIntermediaire
 */
public class TestJoueurIntermediaire {

    /**
     * test du contructeur de JoueurIntermediaire
     * cas normal
     */
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

    /**
     * test de la methode ajouterPiece
     * cas normal
     */
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

    /**
     * test de la methode ajouterPiece
     * cas avec la case deja occupe
     */
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

    /**
     * test de la methode ajouterPiece
     * cas ou la piece deborde
     */
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

    /**
     * test de la methode calculerScore
     * cas normal
     */
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
