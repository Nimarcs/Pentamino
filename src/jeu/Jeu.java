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
        this.estFinis = false;
    }

    public void finirJeu() {
        this.estFinis = true;
    }

    private void enregistrerCommandes() {
        this.commandes = new ArrayList<Commande>();
        commandes.add(new AideCommande(this.commandes));
        commandes.add(new FinCommande(this));
        commandes.add(new AjouterPieceCommande(this.partie));
        commandes.add(new AfficherPieceCommande(this.partie));
        commandes.add(new AfficherGrilleCommande(this.partie));
    }

    private void executerCommande(String commandeStr) {
        String[] commandeDonnee = commandeStr.split(" ");
        for (Commande commande : this.commandes) {
            if(commande.getAlias().equalsIgnoreCase(commandeDonnee[0])) commande.executer(commandeDonnee);
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

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        try {
            jeu.lancerJeu();
        } catch (DimensionsInvalide | CharInvalide | CoordonneeInvalide | IOException | ValeurNonTraite dimensionsInvalide) {
            dimensionsInvalide.printStackTrace();
        }
    }

}
