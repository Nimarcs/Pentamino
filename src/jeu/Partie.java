package jeu;

import exceptions.CoordonneeNegative;
import exceptions.NumeroInconnue;

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

    public Partie(int x, int y) throws CoordonneeNegative {
        //Par convention, l'origine [(0, 0)] est en bas à gauche
        this.testCoordonnee(x, y);
        this.grille = new char[x][y];
        this.remplirGrille('.');
        this.piecePosees = new ArrayList<>();
        this.remplirAleatoirementPieceAPoser();
    }

    public void testCoordonnee(int x, int y) throws CoordonneeNegative {
        if(x < 0) throw new CoordonneeNegative(x);
        if(y < 0) throw new CoordonneeNegative(y);
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
    private void remplirAleatoirementPieceAPoser() {
        this.pieceAPoser = new ArrayList<>();
        //TODO
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

    public void ajouterPiece(int n, int x, int y) throws NumeroInconnue, CoordonneeNegative {
        this.testCoordonnee(x, y);
        if(this.pieceAPoser.size() < n) throw new NumeroInconnue(n);

    }

    public static void main(String[] args) throws CoordonneeNegative {
        Partie partie = new Partie(20, 10);
        partie.afficherGrille();
    }

    /**
     * Getter pour piecesAPoser
     * @return liste des piéces à poser
     */
    public List<Piece> getPieceAPoser() {
        return pieceAPoser;
    }
}
