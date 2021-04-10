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
        this.jeu.finirPartie();
        System.out.println("Partie finis.");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -fin : Met fin à la partie.");
    }
}
