package commandes.jeu;


import jeu.Jeu;

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

        //TODO sauvegarde
        //faire les try catch pour les erreurs

        System.out.println("sauvegarde effectue dans le fichier :" + args[1]);

    }

}
