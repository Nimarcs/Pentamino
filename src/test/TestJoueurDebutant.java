package test;

import exceptions.*;
import org.junit.Test;
import partie.JoueurDebutant;
import partie.Partie;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestJoueurDebutant {

    @Test
    public void test_constructeur_normal() {
        //preparation des donnees
        JoueurDebutant joueurDebutant;

        //methode teste
        joueurDebutant = new JoueurDebutant("Kurisu");

        //assertions
        assertEquals("Le score initial doit être à 0", 0, joueurDebutant.getScore(), 0);
        assertEquals("La liste de partie doit être vide", 0, joueurDebutant.getParties().size());
    }

    @Test
    public void test_ajouterPiece_normal() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException {
        //preparation des donnees
        JoueurDebutant joueurDebutant = new JoueurDebutant("Subaru");
        joueurDebutant.creerPartie(10, 10);
        Partie partie = joueurDebutant.getPartieActuelle();

        //methode teste
        joueurDebutant.ajouterPiece(0, 0, 0);

        //assertions
        assertEquals("La pièce doit être posé", 1, partie.getPiecePosees().size());
    }

    @Test
    public void test_ajouterPiece_caseDejaOccupe() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException {
        //preparation des donnees
        JoueurDebutant joueurDebutant = new JoueurDebutant("Emilia");
        joueurDebutant.creerPartie(10, 10);
        Partie partie = joueurDebutant.getPartieActuelle();

        //methode teste
        joueurDebutant.ajouterPiece(0, 0, 0);
        joueurDebutant.ajouterPiece(0, 0, 0);

        //assertions
        assertEquals("Les deux pièces doivent être posé", 2, partie.getPiecePosees().size());
    }

    @Test
    public void test_ajouterPiece_pieceDeborde() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException {
        //preparation des donnees
        JoueurDebutant joueurDebutant = new JoueurDebutant("Yugo");
        joueurDebutant.creerPartie(10, 10);
        Partie partie = joueurDebutant.getPartieActuelle();

        //methode teste
        joueurDebutant.ajouterPiece(0, 9, 0);

        //assertions
        assertEquals("La pièce doit être posé", 1, partie.getPiecePosees().size());
    }

    @Test
    public void test_calculerScore_normal() throws CoordonneeInvalide, AucunePartie, NumeroInconnue, CharInvalide, ValeurNonTraite, IOException {
        //preparation des donnees
        JoueurDebutant joueurDebutant = new JoueurDebutant("Oropo");
        joueurDebutant.creerPartie(10, 10);
        Partie partie = joueurDebutant.getPartieActuelle();
        joueurDebutant.ajouterPiece(0, 0, 0);
        joueurDebutant.calculerScore();

        //methode teste
        double score = joueurDebutant.getScore();

        //assertions
        assertEquals("Le score doit être de 0.25", 0.25, score, 0);
    }

}
