package jeu;

import commandes.AideCommande;
import commandes.Commande;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    private List<Joueur> joueurList;

    public Jeu(){
        //a faire
    }

    private List<Commande> commandes;
    private static Scanner scanner = new Scanner(System.in);

    public Jeu() {
        this.enregistrerCommandes();
    }

    private void enregistrerCommandes() {
        this.commandes = new ArrayList<Commande>();
        commandes.add(new AideCommande(this.commandes));
    }

    private void executerCommande(String commandeStr) {
        for (Commande commande : this.commandes) {
            if(commande.getAlias().equalsIgnoreCase(commandeStr)) commande.executer();
        }
    }

    public void lancerJeu() {
        boolean isEnd = false;
        Partie partie = null;


        String chargerOuNew = recupEntree(new String[] {"N", "n", "C", "c"}, "N pour creer une nouvelle partie, C pour tenter d'en charger une");
        if (chargerOuNew.toUpperCase() == "N") {
            //creation de la partie
            try {
                partie = new Partie(10, 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //chargement de la partie
            try {
                //c'est ici qu'il faut appeler la methode qui charge
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }

        //boucle jusqu'a la fin des tours
        while (!isEnd) {
            System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
            String commande = scanner.nextLine();
            this.executerCommande(commande);
        }
    }

    public static String recupEntree(String[] valAttendu, String valDemande){
        Scanner sc = new Scanner(System.in);
        boolean estValAttendu = false;
        String val = "";

        while (! estValAttendu){
            System.out.println("Inscrivez " + valDemande);
            val = sc.next();
            int i = 0;
            boolean trouve = false;
            while (i < valAttendu.length && !trouve ){
                if (valAttendu[i] == val){
                    trouve = true;
                    estValAttendu = true;
                }
                i++;
            }
            if (!trouve){
                System.out.println("Valeur errone ressayer");
            }

        }

        return val;

    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.lancerJeu();
    }

}
