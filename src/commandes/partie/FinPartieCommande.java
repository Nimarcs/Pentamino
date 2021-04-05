package commandes.partie;

import jeu.Jeu;
import jeu.Joueur;

public class FinPartieCommande extends CommandePartie {

    private Jeu jeu;

    public FinPartieCommande(Jeu jeu) {
        super("fin");
        this.jeu = jeu;
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        //TODO: save in file
        this.jeu.finirJeu();
        System.out.println("Jeu finis.");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -fin [fichier_sauvegarde]: Met fin à la partie et sauvegarde dans un fichier si précisé.");
    }
}
