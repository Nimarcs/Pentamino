package commandes.jeu;

import jeu.*;

public class AjouterJoueurCommande extends CommandeJeu {

    public AjouterJoueurCommande() {
        super("ajouter_joueur");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -ajouter_joueur <prenom> <debutant|intermediaire|avance>: Permet d'ajouter un joueur au jeu.");
    }

    @Override
    public void executer(String[] args, Jeu jeu) {
        if(args.length < 3) {
            super.erreur("Pas assez d'arguments");
            return;
        }
        String prenom = args[1];
        Joueur joueur = null;
        switch (args[2]) {
            case "debutant": joueur = new JoueurDebutant(prenom); break;
            case "intermediaire": joueur = new JoueurIntermediaire(prenom); break;
            case "avance": joueur = new JoueurAvance(prenom); break;
            default: this.erreur(args[2] + " n'est pas un mode de jeu reconnue.");
        }
        if(joueur != null) jeu.getJoueurs().add(joueur);
    }
}
