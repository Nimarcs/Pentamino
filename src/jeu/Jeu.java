package jeu;

import commandes.CommandeUtil;
import commandes.jeu.*;
import commandes.partie.*;
import exceptions.*;
import partie.Joueur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {

    //attributs

    /**
     * liste des joueurs
     */
    private List<Joueur> joueurs;

    private int indiceJoueurCourant;

    /**
     * Méthode permettant de sélectionner le joueur avec lequel on veut jouer à partir d'un indice qui doit exister
     * @param indice indice du joueur sélectionné
     * @return true si indice existe, sinon false
     */
    public boolean setJoueurCourant(int indice) {
        if(indice >= this.joueurs.size()) return false;
        this.indiceJoueurCourant = indice;
        return true;
    }

    /**
     * signale la fin d'une partie
     */
    private boolean estFinis;

    /**
     * liste des commandes disponible pour jouer
     */
    private List<CommandePartie> commandesPartie;

    /**
     * liste de commandes disponoble pour le jeu
     */
    private List<CommandeJeu> commandesJeu;


    //constructeur

    /**
     * constructeur vide de jeu.Jeu
     */
    public Jeu() {
        this.indiceJoueurCourant = -1;
        this.estFinis = false;
        this.joueurs = new ArrayList<Joueur>();
        this.commandesPartie = new ArrayList<CommandePartie>();
        this.commandesJeu = new ArrayList<CommandeJeu>();
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
        this.commandesPartie.add(new AidePartieCommande(this.commandesPartie));
        this.commandesPartie.add(new FinPartieCommande(this));
        this.commandesPartie.add(new PoserPieceCommande());
        this.commandesPartie.add(new AfficherPiecesCommande());
        this.commandesPartie.add(new AfficherGrilleCommande());
        this.commandesPartie.add(new RetirerDernierPieceCommande());

        this.commandesJeu.add(new ChoisirJoueurCommande());
        this.commandesJeu.add(new AfficherJoueurCommande());
        this.commandesJeu.add(new AjouterJoueurCommande());
        this.commandesJeu.add(new AideJeuCommande(this.commandesJeu));
    }

    /**
     * methode permettant de lancer le jeu
     * @throws CharInvalide renvoye par Partie lorsque qu'un caractere est invalide
     * @throws CoordonneeInvalide renvoye par Partie lorsque des coordonee sont invalides
     * @throws IOException renvoye par Partie lors d'une erreur lors de la lecture d'un fichier
     * @throws ValeurNonTraite renvoye par Partie lors d'une erreur lorsqu'un caratere non traite est trouve dans un fichier
     */
    public void lancerJeu() throws CharInvalide, CoordonneeInvalide, IOException, ValeurNonTraite {
        //creer un scanner
        Scanner scanner = new Scanner(System.in);

        //initialisation des valeurs necessaire
        this.enregistrerCommandes();

        //on prépare le jeu avec l'ajout/sélection des joueurs
        while(this.indiceJoueurCourant == -1) {
            System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
            String commande = scanner.nextLine();
            this.executerCommandeJeu(commande);
        }

        //on récupère le joueur choisis
        Joueur joueur = this.joueurs.get(this.indiceJoueurCourant);
        System.out.println("Lancement d'une partie avec le joueur " + joueur);

        //boucle jusqu'a la fin des tours
        while (!this.estFinis) {
            System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
            String commande = scanner.nextLine();
            this.executerCommandeJoueur(commande, joueur);
        }
    }

    /**
     * methode permettant d'executer une commande
     * @param commandeStr nom de la commande
     */
    private void executerCommandeJeu(String commandeStr) {
        if(commandeStr == null) return;
        String[] commandeDonnee = commandeStr.split(" ");
        int indice = CommandeUtil.trouverIndiceCommande(this.commandesJeu, commandeDonnee[0]);
        if (indice == -1) {
            System.out.println("[ERREUR]: Commande '" + commandeDonnee[0] + "' non reconnue.");
            return;
        }
        this.commandesJeu.get(indice).executer(commandeDonnee, this);
    }

    /**
     * methode permettant d'executer une commande
     * @param commandeStr nom de la commande
     */
    private void executerCommandeJoueur(String commandeStr, Joueur joueur) {
        if(commandeStr == null) return;
        String[] commandeDonnee = commandeStr.split(" ");
        int indice = CommandeUtil.trouverIndiceCommande(this.commandesPartie, commandeDonnee[0]);
        if (indice == -1) {
            System.out.println("[ERREUR]: Commande '" + commandeDonnee[0] + "' non reconnue.");
            return;
        }
        this.commandesPartie.get(indice).executer(commandeDonnee, joueur);
    }

    //main

    public static void main(String[] args) {
        //on creer puis lance un jeu
        Jeu jeu = new Jeu();
        try {
            jeu.lancerJeu();
            //Exceptions se déclenchant si le programme n'arrive pas à bien charger les formes.
        } catch (IOException | CharInvalide | ValeurNonTraite | CoordonneeInvalide e) {
            e.printStackTrace();
        }

    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
