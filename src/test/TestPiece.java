package test;

import exceptions.CoordonneeInvalide;
import jeu.Carre;
import org.junit.Assert;
import org.junit.Test;
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
    public void test03_piece_normal() throws Exception {

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

}
