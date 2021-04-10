package commandes.partie;

import exceptions.PartieInconnue;
import partie.Joueur;

public class ChoisirPartieCommande extends CommandePartie {

    public ChoisirPartieCommande() {
        super("choisir_partie");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -choisir_partie <indice>: Fais en sorte que le joueur joue à la partie à l'indice indice");
    }

    @Override
    public void executer(String[] args, Joueur joueur) {
        if(args.length < 2) {
            super.erreur("Pas assez d'arguments");
            return;
        }
        try {
            int indice = Integer.parseInt(args[1]);
            joueur.setPartieActuelle(indice);
            super.info("Sélection de la partie " + indice);
        } catch (NumberFormatException ignored) {
            super.erreur("Vous devez rentrer un nombre entier");
        } catch (PartieInconnue partieInconnue) {
            super.erreur("L'indice rentré");
        }
    }
}
