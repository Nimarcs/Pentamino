package commandes.partie;

import jeu.Jeu;
import partie.Joueur;

public class FinPartieCommande extends CommandePartie {

    private Jeu jeu;

    public FinPartieCommande(Jeu jeu) {
        super("fin");
        this.jeu = jeu;
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        //TODO: save in file
        this.jeu.finirPartie();
        System.out.println("Jeu finis.");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -fin [fichier_sauvegarde]: Met fin à la partie et sauvegarde dans un fichier si précisé.");
    }
}
