package jeu;

import exceptions.*;
import piece.L;
import piece.Piece;
import piece.U;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public Partie(int x, int y) throws DimensionsInvalide, ValeurNonTraite, CharInvalide, CoordonneeInvalide, IOException {
        //Par convention, l'origine [(0, 0)] est en haut à gauche
        if(x < 0 || y < 0) throw new DimensionsInvalide(x, y);
        this.grille = new char[x][y];
        this.remplirGrille('.');
        this.piecePosees = new ArrayList<Piece>();
        this.remplirAleatoirementPieceAPoser();
    }

    private void testCoordonnee(int x, int y) throws CoordonneeInvalide {
        if(!this.estDansGrille(x, y)) throw new CoordonneeInvalide(x, y);
    }

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

    public void ajouterPiece(int n, int x, int y) throws NumeroInconnue, CoordonneeInvalide, CaseDejaOccupe, PieceEmpietePiece, PieceDebordeTerrain {
        this.testCoordonnee(x, y);
        if(this.pieceAPoser.size() < n) throw new NumeroInconnue(n);
        Piece piece = this.pieceAPoser.get(n);
        char character = piece.getLettre();
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
}
