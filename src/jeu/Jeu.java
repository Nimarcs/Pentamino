package jeu;

import commandes.CommandeUtil;
import commandes.jeu.*;
import commandes.partie.*;
import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;
import partie.Joueur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu implements Serializable {

    //attributs

    /**
     * liste des joueurs
     */
    private List<Joueur> joueurs;

    /**
     * indice du joueur courant
     */
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
    private boolean partieEstFinis;

    /**
     * signale la fin du jeu
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
        this.partieEstFinis = false;
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
    public void finirJeu(){
        this.estFinis = true;
        System.exit(0);
    }

    /**
     * methode permettant d'arreter la partie
     */
    public void finirPartie() {
        this.partieEstFinis = true;
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
        this.commandesJeu.add(new AfficherJoueursCommande());
        this.commandesJeu.add(new AjouterJoueurCommande());
        this.commandesJeu.add(new QuitterJeuCommande());
        this.commandesJeu.add(new SauvegarderJeuCommande());
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

        while(!this.estFinis) { //tourne tant que le jeu est en route

            //on prépare le jeu avec l'ajout/sélection des joueurs
            while (this.indiceJoueurCourant == -1) {
                System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
                String commande = scanner.nextLine();
                this.executerCommandeJeu(commande);
            }

            //on récupère le joueur choisis
            Joueur joueur = this.joueurs.get(this.indiceJoueurCourant);
            System.out.println("Lancement d'une partie avec le joueur " + joueur.getPrenom());

            //boucle jusqu'a la fin des tours
            while (!this.partieEstFinis) {
                System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
                String commande = scanner.nextLine();
                this.executerCommandeJoueur(commande, joueur);
            }
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
        Jeu jeu = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous charger un jeu ? (Y/N)");
        String reponse = scanner.nextLine().toUpperCase();
        //tant que ce n'est ni Y ni N
        while(!(reponse.equals("Y") || reponse.equals("N"))){
            System.out.println("Réponse erronée notez Y pour charger et N pour continuer");
            reponse = scanner.nextLine().toUpperCase();
        }
        if (reponse.equals("Y")){
            System.out.println("Entrez le nom du fichier");
            String file = scanner.nextLine();
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                jeu = (Jeu) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erreur lors du chargement du fichier, lancement d'un nouveau jeu");
                jeu = new Jeu();
            }
        }
        //on creer puis lance un jeu
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
