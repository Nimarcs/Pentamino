package test;

import exceptions.*;
import org.junit.Test;
import partie.Partie;
import piece.Carre;
import piece.Piece;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPartie {

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

    @Test(expected = CoordonneeInvalide.class)
    public void test_constructeur_coordonneeNegative() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException {
        //preparation des donnees
        Partie partie;

        //methode teste
        partie = new Partie(-1, 10);

        //assertions
        //doit throw exception
    }

    @Test
    public void test_remplirAleatoirementPieceAPoser_normal() throws IOException, CharInvalide, CoordonneeInvalide, ValeurNonTraite {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        List<Piece> pieces = partie.getPieceAPoser();
        //assertions
        assertEquals("Doit avoir 10 pieces", 10, pieces.size());
    }

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

    @Test(expected = CoordonneeInvalide.class)
    public void test_retirerDernierePiece_coordonneeNagtive() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        //methode teste
        partie.forcerPosePiece(0, -1, 5);
    }

    @Test(expected = CoordonneeInvalide.class)
    public void test_retirerDernierePiece_coordonneeTropGrande() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        //methode teste
        partie.forcerPosePiece(0, 5, 11);
    }

    @Test(expected = NumeroInconnue.class)
    public void test_retirerDernierePiece_numPieceInconnue() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);
        //methode teste
        partie.forcerPosePiece(10, 0, 0);
    }

    @Test(expected=AucunePiecePlace.class)
    public void test_retirerDernierePiece_exception() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, AucunePiecePlace {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.retirerDernierePiece();

        //assertions
        //doit throw l'exception
    }

    @Test
    public void test_testerPosePiece_normal() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, 0, 0);

        //assertions
        //ne doit pas throw d'exception
    }

    @Test(expected = CoordonneeInvalide.class)
    public void test_testerPosePiece_coordonneNegative() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, -1, 5);

        //assertions
        //doit throw exception
    }

    @Test(expected = CoordonneeInvalide.class)
    public void test_testerPosePiece_coordonneTropGrande() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, 5, 10);

        //assertions
        //doit throw exception
    }

    @Test(expected = NumeroInconnue.class)
    public void test_testerPosePiece_numPieceInconnu() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(-1, 5, 5);

        //assertions
        //doit throw exception
    }

    @Test(expected = PieceDebordeTerrain.class)
    public void test_testerPosePiece_PieceDeborde() throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException, NumeroInconnue, PieceDebordeTerrain, CaseDejaOccupe {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        partie.testerPosePiece(0, 9, 0);

        //assertions
        //doit throw exception
    }

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
