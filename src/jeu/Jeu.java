package jeu;

import commandes.*;
import commandes.jeu.AideJeuCommande;
import commandes.jeu.ChoisirJoueurCommande;
import commandes.jeu.CommandeJeu;
import commandes.partie.*;
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
    private List<Joueur> joueurs;

    private int indiceJoueurCourant;

    public void setJoueurCourant(int indice) { this.indiceJoueurCourant = indice; }

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
     * constructeur vide de Jeu
     */
    public Jeu() {
        this.indiceJoueurCourant = -1;
        this.estFinis = false;
        this.joueurs = new ArrayList<Joueur>();
        this.commandesPartie = new ArrayList<Commande>();
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
        this.commandesPartie = new ArrayList<CommandePartie>();
        commandesPartie.add(new AidePartieCommande(this.commandesPartie));
        commandesPartie.add(new FinPartieCommande(this));
        commandesPartie.add(new PoserPieceCommande());
        commandesPartie.add(new AfficherPiecesCommande());
        commandesPartie.add(new AfficherGrilleCommande());
        this.commandesJeu = new ArrayList<CommandeJeu>();
        this.commandesJeu.add(new ChoisirJoueurCommande());
        this.commandesJeu.add(new AideJeuCommande(this.commandesJeu));
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
        this.enregistrerCommandes();

        //on prépare le jeu avec l'ajout/sélection des joueurs
        while(this.indiceJoueurCourant == -1) {
            System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
        }

        //boucle jusqu'a la fin des tours
        while (!this.estFinis) {
            System.out.println("Entrez une commande (taper \"aide\" pour une liste de commandes)");
            String commande = scanner.nextLine();
            this.executerCommandeJeu(commande);
        }
    }

    /**
     * methode permettant d'executer une commande
     * @param commandeStr nom de la commande
     */
    private void executerCommandeJeu(String commandeStr) {
        if (commandeStr != null) {
            String[] commandeDonnee = commandeStr.split(" ");
            for (CommandeJeu commande : this.commandesJeu) {
                if (commande.getAlias().equalsIgnoreCase(commandeDonnee[0])) commande.executer(commandeDonnee, this);
            }
        }
    }

    //main

    public static void main(String[] args) {

        //on creer puis lance un jeu
        Jeu jeu = new Jeu();
        try {
            jeu.lancerJeu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DimensionsInvalide dimensionsInvalide) {
            dimensionsInvalide.printStackTrace();
        } catch (CharInvalide charInvalide) {
            charInvalide.printStackTrace();
        } catch (ValeurNonTraite valeurNonTraite) {
            valeurNonTraite.printStackTrace();
        } catch (CoordonneeInvalide coordonneeInvalide) {
            coordonneeInvalide.printStackTrace();
        }

    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
