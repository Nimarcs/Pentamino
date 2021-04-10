package commandes.partie;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;
import partie.Joueur;

import java.io.IOException;

public class CreerPartieCommande extends CommandePartie {

    public CreerPartieCommande() {
        super("creer_partie");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -creer_partie <tailleX> <tailleY>: créer une partie avec une grille de tailleX, tailleY et change la partie actuelle par la nouvelle partie.");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        if(args.length < 3) {
            super.erreur("Pas assez d'arguments");
            return;
        }
        try {
            int tailleX = Integer.parseInt(args[1]);
            int tailleY = Integer.parseInt(args[2]);
            joueur.creerPartie(tailleX, tailleY);
            super.info("Création d'une nouvelle partie.");
        } catch (NumberFormatException ignored) {
            super.erreur("Vous devez rentrer des entiers");
        } catch (CoordonneeInvalide ignored) {
            super.erreur("Les coordonées fournis sont invalides");
        } catch (CharInvalide | ValeurNonTraite | IOException ignored) {
            super.erreur("Echec du chargement de la partie en interne");
        }

    }
}
