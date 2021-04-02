package jeu;

import commandes.*;
import exceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    private List<Joueur> joueurList;
    private Partie partie;
    private boolean estFinis;

    private List<Commande> commandes;
    private static Scanner scanner = new Scanner(System.in);

    public Jeu() {
        this.enregistrerCommandes();
    }

    public void finirJeu() {
        this.estFinis = true;
    }

    private void enregistrerCommandes() {
        this.commandes = new ArrayList<Commande>();
        commandes.add(new AideCommande(this.commandes));
        commandes.add(new FinCommande(this));
        commandes.add(new AjouterCommande(this));
        commandes.add(new AfficherPieceCommande(this.partie.getPieceAPoser()));
    }

    private void executerCommande(String commandeStr) {
        for (Commande commande : this.commandes) {
            if(commande.getAlias().equalsIgnoreCase(commandeStr)) commande.executer(commandeStr.split(" "));
        }
    }

    public void lancerJeu() throws DimensionsInvalide, CharInvalide, CoordonneeInvalide, IOException, ValeurNonTraite {
        //boucle jusqu'a la fin des tours
        this.partie = new Partie(10, 10);
        this.enregistrerCommandes();
        while (!this.estFinis) {
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
