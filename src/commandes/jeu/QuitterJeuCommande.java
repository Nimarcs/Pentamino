package commandes.jeu;

import jeu.Jeu;

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

        super.info("Voulez-vous vraiment quitter ? (Y/N) (Attention, ça ne sauvegarde pas automatiquement)");
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
