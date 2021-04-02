package commandes;

import java.util.List;

public class AideCommande extends Commande {

    private List<Commande> commandes;

    public AideCommande(List<Commande> commandes) {
        super("aide");
        this.commandes = commandes;
    }

    public void executer() {
        for (Commande commande : this.commandes) {
            commande.afficherAide();
        }
    }

    public void afficherAide() {
        System.out.println("aide: Affiche toutes les commandes");
    }
}
