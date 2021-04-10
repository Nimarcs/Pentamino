package commandes.jeu;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;
import jeu.Jeu;
import partie.Joueur;
import partie.JoueurAvance;
import partie.JoueurDebutant;
import partie.JoueurIntermediaire;

import java.io.IOException;

public class AjouterJoueurCommande extends CommandeJeu {

    public AjouterJoueurCommande() {
        super("ajouter_joueur");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -ajouter_joueur <prenom> <debutant|intermediaire|avance> <tailleX> <tailleY>: Permet d'ajouter un joueur au jeu et crée une partie de taille x,Y.");
    }

    @Override
    public void executer(String[] args, Jeu jeu) {
        if(args.length < 5) {
            super.erreur("Pas assez d'arguments");
            return;
        }
        //verification que le nom n'est pas trop long
        if(args[1].length() > 10) {
            super.erreur("Nom fourni trop long");
            return;
        }
        String prenom = args[1];
        int x = 0, y = 0;
        //On s'assure que les arguments sont bien des entiers
        try {
            x = Integer.parseInt(args[3]);
            y = Integer.parseInt(args[4]);
        } catch (NumberFormatException ignored) {
            super.erreur("Mauvais format pour les arguments, tailleX et tailleY doivent être des entiers.");
        }
        Joueur joueur = null;
        switch (args[2]) {
            case "debutant": joueur = new JoueurDebutant(prenom); break;
            case "intermediaire": joueur = new JoueurIntermediaire(prenom); break;
            case "avance": joueur = new JoueurAvance(prenom); break;
            default: this.erreur(args[2] + " n'est pas un mode de jeu reconnue.");
        }
        if(joueur != null) {
            try {
                joueur.creerPartie(x, y);
                jeu.getJoueurs().add(joueur);
                super.info("Création du joueur réussi.");
            } catch (CharInvalide | IOException | ValeurNonTraite charInvalide) {
                super.erreur("Echec de la création de la partie en interne (pas censé arriver)");
            } catch (CoordonneeInvalide coordonneeInvalide) {
                super.erreur("TailleX et tailleY doivent être supérieur à 0.");
            }
        }
    }
}
