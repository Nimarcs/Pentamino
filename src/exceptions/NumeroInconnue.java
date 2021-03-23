package exceptions;

public class NumeroInconnue extends Exception {

    public NumeroInconnue(int n) {
        super("La pièce numéro " + n + " dans la liste n'existe pas.");
    }

}
