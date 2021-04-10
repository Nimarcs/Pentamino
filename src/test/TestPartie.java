package test;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;
import org.junit.Test;
import partie.Partie;
import piece.Piece;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPartie {

    @Test
    public void test_remplirAleatoirementPieceAPoser_normal() throws IOException, CharInvalide, CoordonneeInvalide, ValeurNonTraite {
        //preparation des donnees
        Partie partie = new Partie(10 , 10);

        //methode teste
        List<Piece> pieces = partie.getPieceAPoser();
        //assertions
        assertEquals("Doit avoir 10 pieces", 10, pieces.size());
    }

}
