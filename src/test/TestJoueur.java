package test;

import exceptions.*;
import org.junit.Test;
import partie.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * test de la classe abstraite Joueur
 */
public class TestJoueur {

    /**
     * test de la methode creerPartie
     * cas normal
     */
    @Test
    public void test_creerPartie_normal() throws CoordonneeInvalide, CharInvalide, ValeurNonTraite, IOException {
        //preparation des donnees
        Joueur joueur = new JoueurDebutant("Megumin");

        //methode teste
        joueur.creerPartie(10, 10);

        //assertions
        assertEquals("Le joueur doit avoir crée une partie", 1, joueur.getParties().size());
    }

    /**
     * test de la methode creerPartie
     * cas avec des coordonne negative
     */
    @Test(expected = CoordonneeInvalide.class)
    public void test_creerPartie_coordonneeNegative() throws CoordonneeInvalide, CharInvalide, ValeurNonTraite, IOException {
        //preparation des donnees
        Joueur joueur = new JoueurDebutant("Makabe");

        //methode teste
        joueur.creerPartie(-1, 10);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode setPartieActuelle
     * cas normal
     */
    @Test
    public void test_setPartieActuelle_normal() throws CoordonneeInvalide, CharInvalide, ValeurNonTraite, IOException, PartieInconnue, AucunePartie {
        //preparation des donnees
        Joueur joueur = new JoueurDebutant("Megumin");
        joueur.creerPartie(10, 10);
        joueur.creerPartie(5, 5);

        //methode teste
        joueur.setPartieActuelle(1);

        //assertions
        assertEquals("La partie actuelle doit être à l'indice 1", joueur.getParties().get(1), joueur.getPartieActuelle());
    }

    /**
     * test de la methode setPartieActuelle
     * cas avec un indice negatif
     */
    @Test(expected = PartieInconnue.class)
    public void test_setPartieActuelle_indiceNegatif() throws CoordonneeInvalide, CharInvalide, ValeurNonTraite, IOException, PartieInconnue, AucunePartie {
        //preparation des donnees
        Joueur joueur = new JoueurDebutant("Megumin");
        joueur.creerPartie(10, 10);

        //methode teste
        joueur.setPartieActuelle(-1);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode setPartieActuelle
     * cas avec un indice trop grand
     */
    @Test(expected = PartieInconnue.class)
    public void test_setPartieActuelle_indiceTropGrand() throws CoordonneeInvalide, CharInvalide, ValeurNonTraite, IOException, PartieInconnue, AucunePartie {
        //preparation des donnees
        Joueur joueur = new JoueurDebutant("Megumin");
        joueur.creerPartie(10, 10);

        //methode teste
        joueur.setPartieActuelle(1);

        //assertions
        //doit throw exception
    }

    /**
     * test de la methode getPartieActuelle
     * cas normal
     */
    @Test
    public void test_getPartieActuelle_normal() throws CoordonneeInvalide, CharInvalide, ValeurNonTraite, IOException, PartieInconnue, AucunePartie {
        //preparation des donnees
        Joueur joueur = new JoueurDebutant("Megumin");
        joueur.creerPartie(10, 10);
        joueur.creerPartie(5, 5);
        joueur.setPartieActuelle(1);

        //methode teste
        Partie partieActuelle = joueur.getPartieActuelle();

        //assertions
        assertEquals("La partie actuelle doit être à l'indice 1", joueur.getParties().get(1), partieActuelle);
    }

    /**
     * test de la methode getPartieActuelle
     * cas avec aucune partie
     */
    @Test(expected = AucunePartie.class)
    public void test_getPartieActuelle_aucunePartie() throws AucunePartie {
        //preparation des donnees
        Joueur joueur = new JoueurDebutant("Megumin");

        //methode teste
        Partie partieActuelle = joueur.getPartieActuelle();

        //assertions
        //doit throw exception
    }

}
