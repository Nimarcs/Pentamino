package test;

import exceptions.*;
import org.junit.Test;
import partie.JoueurAvance;
import partie.Partie;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * test de la classe JoueurAvance
 */
public class TestJoueurAvance {

    /**
     * test du contructeur de JoueurAvance
     * cas normal
     */
    @Test
    public void test_constructeur_normal() {
        //preparation des donnees
        JoueurAvance joueurAvance;

        //methode teste
        joueurAvance = new JoueurAvance("Kurisu");

        //assertions
        assertEquals("Le score initial doit être à 0", 0, joueurAvance.getScore(), 0);
        assertEquals("La liste de partie doit être vide", 0, joueurAvance.getParties().size());
    }

    /**
     * test de la methode ajouterPiece
     * cas normal
     */
    @Test
    public void test_ajouterPiece_normal() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException, PlacementInterdit {
        //preparation des donnees
        JoueurAvance joueurAvance = new JoueurAvance("Subaru");
        joueurAvance.creerPartie(10, 10);
        Partie partie = joueurAvance.getPartieActuelle();

        //methode teste
        joueurAvance.ajouterPiece(0, 0, 0);

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
        JoueurAvance joueurAvance = new JoueurAvance("Emilia");
        joueurAvance.creerPartie(10, 10);
        Partie partie = joueurAvance.getPartieActuelle();

        //methode teste
        joueurAvance.ajouterPiece(0, 0, 0);
        joueurAvance.ajouterPiece(0, 0, 0);

        //assertions
        //doit throw une exception
    }

    /**
     * test de la methode ajouterPiece
     * cas ou la piece deborde
     */
    @Test(expected = PlacementInterdit.class)
    public void test_ajouterPiece_pieceDeborde() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException, PlacementInterdit {
        //preparation des donnees
        JoueurAvance joueurAvance = new JoueurAvance("Yugo");
        joueurAvance.creerPartie(10, 10);
        Partie partie = joueurAvance.getPartieActuelle();

        //methode teste
        joueurAvance.ajouterPiece(0, 9, 0);

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
        JoueurAvance joueurAvance = new JoueurAvance("Oropo");
        joueurAvance.creerPartie(10, 10);
        Partie partie = joueurAvance.getPartieActuelle();
        joueurAvance.ajouterPiece(0, 0, 0);
        joueurAvance.calculerScore();

        //methode teste
        double score = joueurAvance.getScore();

        //assertions
        assertEquals("Le score doit être de 1", 1, score, 0);
    }

}
