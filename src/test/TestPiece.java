package test;

import exceptions.CoordonneeInvalide;
import piece.Carre;
import org.junit.Assert;
import org.junit.Test;
import piece.L;
import piece.U;

import java.util.List;

public class TestPiece {

    @Test
    public void test01_carre_normal() throws Exception {

        Carre c = new Carre(7, 6);
        Assert.assertEquals("carre au mauvais endroit", 7, c.getX());
        Assert.assertEquals("carre au mauvais endroit", 6, c.getY());

    }

    @Test (expected = CoordonneeInvalide.class)
    public void test02_carre_negatif() throws Exception {

        Carre c = new Carre(-7, 6);
        Carre c1 = new Carre(7, -6);
        Carre c2 = new Carre(-7, -6);

    }

    @Test
    public void test03_piece_normalU() throws Exception {

        U piece = new U(0, 0);
        Assert.assertEquals("La lettre est cense etre U ", 'U', piece.getLettre());
        Assert.assertEquals("mauvaise abscisse de la piece", 0, piece.getY());
        Assert.assertEquals("mauvaise ordonne de la piece", 0, piece.getX());
        List<Carre> carres = piece.getCarres();
        Carre c1 = carres.get(0);
        Carre c5 = carres.get(4);
        Assert.assertEquals("carre au mauvais endroit", 0, c1.getX());
        Assert.assertEquals("carre au mauvais endroit", 0, c1.getY());
        Assert.assertEquals("carre au mauvais endroit", 1, c5.getX());
        Assert.assertEquals("carre au mauvais endroit", 2, c5.getY());

    }

    @Test
    public void test04_piece_normalL() throws Exception {

        L piece = new L(0, 0);
        Assert.assertEquals("La lettre est cense etre L ", 'L', piece.getLettre());
        Assert.assertEquals("mauvaise abscisse de la piece", 0, piece.getY());
        Assert.assertEquals("mauvaise ordonne de la piece", 0, piece.getX());
        List<Carre> carres = piece.getCarres();
        Carre c1 = carres.get(0);
        Carre c2 = carres.get(1);
        Carre c3 = carres.get(2);
        Carre c4 = carres.get(3);
        Assert.assertEquals("carre au mauvais endroit", 0, c1.getX());
        Assert.assertEquals("carre au mauvais endroit", 0, c1.getY());
        Assert.assertEquals("carre au mauvais endroit", 1, c2.getX());
        Assert.assertEquals("carre au mauvais endroit", 0, c2.getY());
        Assert.assertEquals("carre au mauvais endroit", 2, c3.getX());
        Assert.assertEquals("carre au mauvais endroit", 0, c3.getY());
        Assert.assertEquals("carre au mauvais endroit", 2, c4.getX());
        Assert.assertEquals("carre au mauvais endroit", 1, c4.getY());

    }

    @Test
    public void test05_toString_normalU() throws Exception {

        // preparation des donnees
        U piece = new U(0, 0);
        //methode testee
        String res = piece.toString();
        // verification
        Assert.assertEquals("Le string est censé être #_#\\n### ", "#_#\n###", res);


    }

    @Test
    public void test06_toString_normalL() throws Exception {

        // preparation des donnees
        L piece = new L(0, 0);
        //methode testee
        String res = piece.toString();
        // verification
        Assert.assertEquals("Le string est censé être #_\\n#_\\n## ", "#_\n#_\n##", res);


    }

}
