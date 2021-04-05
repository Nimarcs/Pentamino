package commandes.jeu;

import commandes.jeu.CommandeJeu;
import jeu.Jeu;
import jeu.Joueur;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AfficherJoueurCommande extends CommandeJeu {

    public AfficherJoueurCommande() {
        super("afficher_joueur");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -afficher_joueur [nom|score]: Affiche tous les joueurs que l'on peut choisir avec leur indice");
    }

    @Override
    public void executer(String[] args, Jeu jeu) {
        List<Joueur> joueurs = jeu.getJoueurs();
        if(args.length < 2 || args[1].equalsIgnoreCase("score")) {
            Collections.sort(joueurs);
            System.out.println("Joueurs par score moyen:");
            for (int i = 0; i < joueurs.size(); i++) {
                System.out.printf(" %d: %s%n", i, joueurs.get(i).toString());
            }
        } else {
            Collections.sort(joueurs, new Comparator<Joueur>() {
                public int compare(Joueur o1, Joueur o2) {
                    return o1.getPrenom().compareTo(o2.getPrenom());
                }
            });
            System.out.println("Joueurs par ordre alphabétique:");
            for (int i = 0; i < joueurs.size(); i++) {
                System.out.printf(" %d: %s%n", i, joueurs.get(i).toString());
            }
        }
        jeu.setJoueurs(joueurs);
    }
}
