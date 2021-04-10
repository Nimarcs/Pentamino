package commandes.partie;

import partie.Joueur;
import partie.Partie;

import java.util.List;

public class AfficherPartiesCommande extends CommandePartie {

    public AfficherPartiesCommande() {
        super("afficher_parties");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_parties: Affiche les parties du joueur.");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        List<Partie> parties = joueur.getParties();
        if(parties.size() == 0) {
            System.out.println("Aucune partie disponible");
            return;
        }
        System.out.println("Parties disponibles:");
        for (int i = 0; i < parties.size(); i++) {
            System.out.printf(" -%d: %s%n", i, parties.get(i));
        }
    }
}
