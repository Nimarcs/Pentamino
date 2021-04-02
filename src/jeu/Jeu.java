package jeu;

import commandes.AideCommande;
import commandes.Commande;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

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
        try {
            partie = new Partie(10, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!isEnd) {
            System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
            String commande = scanner.nextLine();
            this.executerCommande(commande);
        }
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.lancerJeu();
    }

}
