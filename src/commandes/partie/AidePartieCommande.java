package commandes.partie;

import commandes.Commande;
import partie.Joueur;

import java.util.List;

public class AidePartieCommande extends CommandePartie {

    private List<CommandePartie> commandes;

    public AidePartieCommande(List<CommandePartie> commandes) {
        super("aide");
        this.commandes = commandes;
    }
    public void afficherAide() {
        System.out.println(" -aide: Affiche toutes les commandes.");
    }

    public void executer(String[] args, Joueur joueur) {
        System.out.println("Liste de toutes les commandes:");
        this.commandes.forEach(System.out::println);
        System.out.println();

    }
}
