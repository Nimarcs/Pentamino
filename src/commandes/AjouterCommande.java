package commandes;

import jeu.Jeu;

public class AjouterCommande extends Commande {

    private final Jeu jeu;

    public AjouterCommande(Jeu jeu) {
        super("ajouter");
        this.jeu = jeu;
    }

    public void executer(String[] args) {
        if(args.length < 4) {
            this.afficherAide();
            return;
        }

    }

    public void afficherAide() {
        System.out.println(" -ajouter <numeroPiece> <x> <y>: ajoute une pièce à l'indice numeroPiece aux coordonées [x,y].");
    }
}
