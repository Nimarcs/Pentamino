package jeu;

import commandes.*;
import exceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    //attributs

    /**
     * liste des joueurs
     */
    private List<Joueur> joueurList;

    /**
     * partie en cours
     */
    private Partie partie;

    /**
     * signale la fin d'une partie
     */
    private boolean estFinis;

    /**
     * liste des commandes disponible pour jouer
     */
    private List<Commande> commandes;


    //constructeur

    /**
     * constructeur vide de Jeu
     */
    public Jeu() {
        this.estFinis = false;
        this.joueurList = new ArrayList<Joueur>();
        this.partie = null; //pas de partie a l'origine
        this.commandes = new ArrayList<Commande>();
        //les commandes ont besoin de Partie definit
    }

    //methodes

    /**
     * methode permettant d'arreter le jeu
     */
    public void finirJeu() {
        this.estFinis = true;
    }

    /**
     * methode permettant de redefinir les commandes disponible
     */
    private void enregistrerCommandes() {
        this.commandes = new ArrayList<Commande>();
        commandes.add(new AideCommande(this.commandes));
        commandes.add(new FinCommande(this));
        commandes.add(new AjouterPieceCommande(this.partie));
        commandes.add(new AfficherPieceCommande(this.partie));
        commandes.add(new AfficherGrilleCommande(this.partie));
    }

    /**
     * methode permettant d'executer une commande
     * @param commandeStr nom de la commande
     */
    private void executerCommande(String commandeStr) {
        if (commandeStr != null) {

            String[] commandeDonnee = commandeStr.split(" ");
            for (Commande commande : this.commandes) {
                if (commande.getAlias().equalsIgnoreCase(commandeDonnee[0])) commande.executer(commandeDonnee);
            }

        }
    }

    /**
     * methode permettant de lancer le jeu
     * @throws DimensionsInvalide renvoye par Partie lorsque les dimentions de la grille sont invalides
     * @throws CharInvalide renvoye par Partie lorsque qu'un caractere est invalide
     * @throws CoordonneeInvalide renvoye par Partie lorsque des coordonee sont invalides
     * @throws IOException renvoye par Partie lors d'une erreur lors de la lecture d'un fichier
     * @throws ValeurNonTraite renvoye par Partie lors d'une erreur lorsqu'un caratere non traite est trouve dans un fichier
     */
    public void lancerJeu() throws DimensionsInvalide, CharInvalide, CoordonneeInvalide, IOException, ValeurNonTraite {

        //creer un scanner
        Scanner scanner = new Scanner(System.in);

        //initialisation des valeurs necessaire
        this.partie = new Partie(10, 10);
        this.enregistrerCommandes();

        //TODO ajout des joueurs

        //boucle jusqu'a la fin des tours
        while (!this.estFinis) {
            System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
            String commande = scanner.nextLine();
            this.executerCommande(commande);

        }
    }

    //main

    public static void main(String[] args) {

        //on creer puis lance un jeu
        Jeu jeu = new Jeu();
        try {
            jeu.lancerJeu();
        } catch (DimensionsInvalide | CharInvalide | CoordonneeInvalide | IOException | ValeurNonTraite erreur) {
            erreur.printStackTrace();
        }
        
    }

}
