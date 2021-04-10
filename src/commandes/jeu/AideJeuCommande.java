package commandes.jeu;

import commandes.Commande;
import jeu.Jeu;

import java.util.List;

public class AideJeuCommande extends CommandeJeu {

    private List<CommandeJeu> commandes;

    public AideJeuCommande(List<CommandeJeu> commandes) {
        super("aide");
        this.commandes = commandes;
    }

    public void afficherAide() {
        System.out.println(" -aide: Affiche toutes les commandes.");
    }

    public void executer(String[] args, Jeu jeu) {
        System.out.println("Liste de toutes les commandes:");
        this.commandes.forEach(Commande::afficherAide);
        System.out.println();
    }
}
