package commandes.jeu;


import jeu.Jeu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SauvegarderJeuCommande extends CommandeJeu {


    public SauvegarderJeuCommande() {
        super("sauvegarder_jeu");
    }

    /**
     * Méthode affichant l'aide sur une commande, comment l'utiliser.
     */
    @Override
    public void afficherAide() {
        System.out.println(" -sauvegarder_jeu <nom_du_fichier_de_sauvegarde> : Sauvegarde le jeu dans son etat actuel.");
    }

    @Override
    public void executer(String[] args, Jeu jeu) {
        if(args.length < 2) {
            super.erreur("Pas assez d'arguments");
            return;
        }
        if(args.length > 2) {
            super.erreur("Le nom du fichier ne doit pas contenir d'espace");
            return;
        }

        //faire les try catch pour les erreurs
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(args[1]));
            oos.writeObject(jeu);
            oos.close();
            super.info("sauvegarde effectue dans le fichier: " + args[1]);
        } catch (IOException e) {
            super.erreur("Echec lors de la sauvegarde du jeu.");
        }

    }

}
