package test;

import exceptions.*;
import org.junit.Test;
import partie.Partie;
import piece.Carre;
import piece.Piece;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * test de la classe Partie
 */
public class TestPartie {

    /**
     * test du contructeur de Partie
     * cas normal
     */
    @Test()
    public void test_constructeur_normal() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException {
        //preparation des donnees
        Partie partie;

        //methode teste
        partie = new Partie(10 , 10);

        //assertions
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char actual = partie.getCharAt(i, j);
                assertEquals("Le tableau doit être remplis de '.'", '.', actual);
            }
        }
    }

    /**
     * test du contructeur de Partie
     * cas avec des coordonnee negatives
     */
    @Test(expected = CoordonneeInvalide.class)
    public void test_constructeur_coordonneeNegative() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException {
        //preparation des donnees
        Partie partie;

        //methode teste
        partie = new Partie(-1, 10);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode remplirAleatoirementPieceAPoser
     * cas normal
     */
    @Test
    public void test_remplirAleatoirementPieceAPoser_normal() throws IOException, CharInvalide, CoordonneeInvalide, ValeurNonTraite {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        List<Piece> pieces = partie.getPieceAPoser();
        //assertions
        assertEquals("Doit avoir 10 pieces", 10, pieces.size());
    }

    /**
     * test de la methode forcerPoserPiece
     * cas normal
     */
    @Test
    public void test_forcerPoserPiece_normal() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        Piece piece = partie.getPieceAPoser().get(0);
        char c = piece.getLettre();

        //methode teste
        partie.forcerPosePiece(0, 0, 0);

        //assertions
        for (Carre carre : piece.getCarres()) {
            int x = carre.getX();
            int y = carre.getY();
            char actual = partie.getCharAt(x, y);
            assertEquals(String.format("Les coordonnées en [%d;%d] doivent contenir le charactère de la lettre %c%n", x, y, c), c, actual);
        }
    }

    /**
     * test de la methode forcerPoserPiece
     * cas avec des coordonne negative
     */
    @Test(expected = CoordonneeInvalide.class)
    public void test_forcerPoserPiece_coordonneeNagtive() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        //methode teste
        partie.forcerPosePiece(0, -1, 5);
    }

    /**
     * test de la methode forcerPoserPiece
     * cas avec des coordonne trop grande
     */
    @Test(expected = CoordonneeInvalide.class)
    public void test_forcerPoserPiece_coordonneeTropGrande() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        //methode teste
        partie.forcerPosePiece(0, 5, 11);
    }

    /**
     * test de la methode forcerPoserPiece
     * cas avec un numero de piece inconnu
     */
    @Test(expected = NumeroInconnue.class)
    public void test_forcerPoserPiece_numPieceInconnue() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        //methode teste
        partie.forcerPosePiece(10, 0, 0);
    }

    /**
     * test de la methode retirerDernierePiece
     * cas normal
     */
    @Test
    public void test_retirerDernierePiece_normal() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, AucunePiecePlace {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        partie.forcerPosePiece(0, 0, 0);

        //methode teste
        partie.retirerDernierePiece();

        //assertions
        assertEquals("La partie ne devrait pas avoir de pièce posé", 0, partie.getPiecePosees().size());
        assertEquals("La partie doit avoir ses 10 pièces", 10, partie.getPieceAPoser().size());
    }

    /**
     * test de la methode retirerDernierePiece
     * cas sans piece
     */
    @Test(expected=AucunePiecePlace.class)
    public void test_retirerDernierePiece_pasDePiece() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, AucunePiecePlace {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.retirerDernierePiece();

        //assertions
        //doit throw l'exception
    }

    /**
     * test de la methode testerPosePiece
     * cas normal
     */
    @Test
    public void test_testerPosePiece_normal() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, 0, 0);

        //assertions
        //ne doit pas throw d'exception
    }

    /**
     * test de la methode testerPosePiece
     * cas avec des coordonee negative
     */
    @Test(expected = CoordonneeInvalide.class)
    public void test_testerPosePiece_coordonneNegative() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, -1, 5);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode testerPosePiece
     * cas avec des coordonee trop grande
     */
    @Test(expected = CoordonneeInvalide.class)
    public void test_testerPosePiece_coordonneTropGrande() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, 5, 10);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode testerPosePiece
     * cas avec un numero de piece inconnu
     */
    @Test(expected = NumeroInconnue.class)
    public void test_testerPosePiece_numPieceInconnu() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(-1, 5, 5);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode testerPosePiece
     * cas avec des coordonee negative
     */
    @Test(expected = PieceDebordeTerrain.class)
    public void test_testerPosePiece_PieceDeborde() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, 9, 0);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode testerPosePiece
     * cas ou la case est deja occupe
     */
    @Test(expected = CaseDejaOccupe.class)
    public void test_testerPosePiece_cadeDejaOccupe() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.forcerPosePiece(0, 0, 0);
        //la pièce à l'indice 0 est posé et supprimé de la liste des pièces à poser
        partie.testerPosePiece(0, 0, 0);

        //assertions
        //doit throw exception
    }

}
