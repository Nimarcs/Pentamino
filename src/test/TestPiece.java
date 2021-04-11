package test;

import exceptions.CoordonneeInvalide;
import piece.Carre;
import org.junit.Test;
import piece.L;
import piece.U;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPiece {

    @Test
    public void test_carre_normal() throws Exception {

        Carre c = new Carre(7, 6);
        assertEquals("carre au mauvais endroit", 7, c.getX());
        assertEquals("carre au mauvais endroit", 6, c.getY());

    }

    @Test (expected = CoordonneeInvalide.class)
    public void test_carre_negatif() throws Exception {

        Carre c = new Carre(-7, 6);
        Carre c1 = new Carre(7, -6);
        Carre c2 = new Carre(-7, -6);

    }

    @Test
    public void test_piece_normalU() throws Exception {

        U piece = new U(0, 0);
        assertEquals("La lettre est cense etre U ", 'U', piece.getLettre());
        assertEquals("mauvaise abscisse de la piece", 0, piece.getY());
        assertEquals("mauvaise ordonne de la piece", 0, piece.getX());
        List<Carre> carres = piece.getCarres();
        Carre c1 = carres.get(0);
        Carre c5 = carres.get(4);
        assertEquals("carre au mauvais endroit", 0, c1.getX());
        assertEquals("carre au mauvais endroit", 0, c1.getY());
        assertEquals("carre au mauvais endroit", 1, c5.getX());
        assertEquals("carre au mauvais endroit", 2, c5.getY());

    }

    @Test
    public void test_piece_normalL() throws Exception {

        L piece = new L(0, 0);
        assertEquals("La lettre est cense etre L ", 'L', piece.getLettre());
        assertEquals("mauvaise abscisse de la piece", 0, piece.getY());
        assertEquals("mauvaise ordonne de la piece", 0, piece.getX());
        List<Carre> carres = piece.getCarres();
        Carre c1 = carres.get(0);
        Carre c2 = carres.get(1);
        Carre c3 = carres.get(2);
        Carre c4 = carres.get(3);
        assertEquals("carre au mauvais endroit", 0, c1.getX());
        assertEquals("carre au mauvais endroit", 0, c1.getY());
        assertEquals("carre au mauvais endroit", 1, c2.getX());
        assertEquals("carre au mauvais endroit", 0, c2.getY());
        assertEquals("carre au mauvais endroit", 2, c3.getX());
        assertEquals("carre au mauvais endroit", 0, c3.getY());
        assertEquals("carre au mauvais endroit", 2, c4.getX());
        assertEquals("carre au mauvais endroit", 1, c4.getY());

    }

    @Test (expected = CoordonneeInvalide.class)
    public void test_piece_Xnegatif() throws Exception {
        U piece = new U(-1, 0);
    }

    @Test (expected = CoordonneeInvalide.class)
    public void test_piece_Ynegatif() throws Exception {
        U piece = new U(0, -120);
    }

    @Test
    public void test_toString_normalU() throws Exception {

        // preparation des donnees
        U piece = new U(0, 0);
        //methode testee
        String res = piece.toString();
        // verification
        assertEquals("Le string est censé être #_#\\n### ", "#_#\n###", res);


    }

    @Test
    public void test_toString_normalL() throws Exception {

        // preparation des donnees
        L piece = new L(0, 0);
        //methode testee
        String res = piece.toString();
        // verification
        assertEquals("Le string est censé être #_\\n#_\\n## ", "#_\n#_\n##", res);


    }

    @Test
    public void test_equals_memeObjet() throws Exception {

        // preparation des donnees
        L piece = new L(4, 0);
        //methode testee
        boolean res = piece.equals(piece);
        // verification
        assertEquals("Les piece devrait etre egale ", true, res);


    }

    @Test
    public void test_equals_normal() throws Exception {

        // preparation des donnees
        L piece = new L(4, 0);
        L piece2 = new L(4, 0);
        //methode testee
        boolean res = piece.equals(piece2);
        // verification
        assertEquals("Les piece devrait etre egale ", true, res);


    }

    @Test
    public void test_equals_positionDiff() throws Exception {

        // preparation des donnees
        L piece = new L(4, 0);
        L piece2 = new L(4, 1);
        //methode testee
        boolean res = piece.equals(piece2);
        // verification
        assertEquals("Les piece devrait etre egale ", false, res);


    }

    @Test
    public void test_equals_pieceDiff() throws Exception {

        // preparation des donnees
        L piece = new L(4, 0);
        U piece2 = new U(4, 0);
        //methode testee
        boolean res = piece.equals(piece2);
        // verification
        assertEquals("Les piece devrait etre egale ", false, res);


    }

}
