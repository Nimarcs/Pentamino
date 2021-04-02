package commandes;

import jeu.Jeu;

public class FinCommande extends Commande {

    private Jeu jeu;

    public FinCommande(Jeu jeu) {
        super("fin");
        this.jeu = jeu;
    }

    @Override
    public void executer(String[] args) {
        //TODO: save in file
        this.jeu.finirJeu();
        System.out.println("Jeu finis.");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -fin [fichier_sauvegarde]: Met fin à la partie et sauvegarde dans un fichier si précisé.");
    }
}
