package exceptions;

/**
 * Exception représentant le cas ou on essaie d'accèder à une pièce qui n'existe pas
 */
public class NumeroInconnue extends Exception {

    public NumeroInconnue(int n) {
        super("La pièce numéro " + n + " dans la liste n'existe pas.");
    }

}
