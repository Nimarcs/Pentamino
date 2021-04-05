package jeu;

import exceptions.*;
import piece.L;
import piece.Piece;
import piece.U;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partie {

    /**
     * Représente le plateau de jeu
     */
    private char[][] grille;
    /**
     * Liste représentant les piéces qui ont été posé
     */
    private List<Piece> piecePosees;
    /**
     * Liste représentant les pièces à poser par les joueurs
     */
    private List<Piece> pieceAPoser;

    /**
     * score de la partie
     */
    private int score;

    /**
     * Constructeur de Partie
     * @param x taille de l'ordonnee de la grille doit etre positive
     * @param y taille de l'abscisse de la grille doit etre positive
     * @throws DimensionsInvalide renvoye si x ou y est negatif
     * @throws ValeurNonTraite renvoye en cas d'erreur dans remplirAleatoirementPieceAPoser
     * @throws CharInvalide renvoye en cas d'erreur dans remplirAleatoirementPieceAPoser
     * @throws CoordonneeInvalide renvoye en cas d'erreur dans remplirAleatoirementPieceAPoser
     * @throws IOException renvoye en cas d'erreur dans remplirAleatoirementPieceAPoser
     */
    public Partie(int x, int y) throws DimensionsInvalide, ValeurNonTraite, CharInvalide, CoordonneeInvalide, IOException {
        //Par convention, l'origine [(0, 0)] est en haut à gauche
        if(x < 0 || y < 0) throw new DimensionsInvalide(x, y);
        this.grille = new char[x][y];
        this.remplirGrille('.');
        this.piecePosees = new ArrayList<Piece>();
        this.remplirAleatoirementPieceAPoser();
    }

    /**
     * methode qui verfie si la position de la piece est valide
     * @param x position sur l'ordonnee
     * @param y position sur l'abscisse
     * @throws CoordonneeInvalide renvoye si la piece n'est pas dans la grille
     */
    private void testCoordonnee(int x, int y) throws CoordonneeInvalide {
        if(!this.estDansGrille(x, y)) throw new CoordonneeInvalide(x, y);
    }

    /**
     * methode qui verifie si les coordonnees sont dans la grille
     * @param x position sur l'ordonnee
     * @param y position sur l'abscisse
     * @return booleen a valeur true si les coordonee sont dans la grille, false sinon
     */
    private boolean estDansGrille(int x, int y) {
        if(x < 0) return false;
        if(y < 0) return false;
        if(x >= this.grille.length) return false;
        return y < this.grille[0].length;
    }

    /**
     * Méthode remplissant entièrement la grille d'un seul character
     * @param character character avec lequel remplir la grille
     */
    private void remplirGrille(char character) {
        for (char[] chars : this.grille) {
            Arrays.fill(chars, character);
        }
    }

    /**
     * Méthode remplissant aléatoirement la liste des pièces à poser
     */
    private void remplirAleatoirementPieceAPoser() throws IOException, CharInvalide, CoordonneeInvalide, ValeurNonTraite {
        //TODO
        this.pieceAPoser = new ArrayList<Piece>();
        this.pieceAPoser.add(new U(0, 0));
    }

    /**
     * Affiche le plateau courant
     */
    public void afficherGrille() {
        for (char[] chars : this.grille) {
            System.out.print("[");
            for (int i = 0; i < chars.length; i++) {
                if(i == chars.length - 1) System.out.print(chars[i]);
                else System.out.print(chars[i] + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * methode permettant de poser une piece sur la grille
     * la piece doit etre dans pieceAPoser
     * @param n index de la piece dans pieceAPoser
     * @param x position sur l'ordonnee
     * @param y position sur l'abscisse
     * @throws NumeroInconnue renvoye si n est invalide
     * @throws CoordonneeInvalide renvoye si l'on essaye de poser la piece hors du terrain
     * @throws CaseDejaOccupe renvoye si la case est deja occupe par une autre piece
     * @throws PieceEmpietePiece renvoye si une partie de la piece superpose une piece deja pose
     * @throws PieceDebordeTerrain renvoye si une partie de la piece deborde de la grille
     */
    public void ajouterPiece(int n, int x, int y) throws NumeroInconnue, CoordonneeInvalide, CaseDejaOccupe, PieceEmpietePiece, PieceDebordeTerrain {

        //TODO modifier score

        //verifications initiales
        this.testCoordonnee(x, y);
        if(this.pieceAPoser.size() < n) throw new NumeroInconnue(n);

        //recuperation des valeurs
        Piece piece = this.pieceAPoser.get(n);
        char character = piece.getLettre();

        //verification
        //TODO CaseDejaOccupe ne marche pas
        if(this.grille[x][y] == character) throw new CaseDejaOccupe(x, y, character);

        //On commence à placer la pièce
        List<Carre> carresPiece = piece.getCarres();
        for(Carre carre : carresPiece) {
            int newX = x + carre.getX();
            int newY = y + carre.getY();
            if(!estDansGrille(newX, newY)) throw new PieceDebordeTerrain();
            if(this.grille[newX][newY] != '.') throw new PieceEmpietePiece();
            this.grille[newX][newY] = character;
        }
    }

    /**
     * Getter pour piecesAPoser
     * @return liste des piéces à poser
     */
    public List<Piece> getPieceAPoser() {
        return pieceAPoser;
    }

    /**
     * getter de grille
     * @return grille de jeu
     */
    public char[][] getGrille() {
        return grille;
    }

    /**
     * getter de score
     * @return score de la partie
     */
    public int getScore() {
        return score;
    }
}
