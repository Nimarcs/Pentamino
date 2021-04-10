package commandes.jeu;

import commandes.Commande;
import jeu.Jeu;

import java.util.List;
import java.util.Scanner;

public class QuitterJeuCommande extends CommandeJeu {

    public QuitterJeuCommande() {
        super("quitter_jeu");
    }

    @Override
    public void afficherAide() {
        System.out.println(" -quitter_jeu : Permet de quitter le jeu (attention ne pas oublier de sauvegarder)");
    }

    @Override
    public void executer(String[] args, Jeu jeu) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous vraiment quitter ? (Y/N)");
        String reponse = scanner.nextLine().toUpperCase();

        //tant que ce n'est ni Y ni N
        while(!(reponse.equals("Y") || reponse.equals("N"))){
            System.out.println("Réponse erronée notez Y pour quitter et N pour continuer");
            reponse = scanner.nextLine().toUpperCase();
        }
        if (reponse.equals("Y")){
            jeu.finirJeu();
        }
    }

}
