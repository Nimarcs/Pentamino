package exceptions;

public class PartieInconnue extends Exception {

    public PartieInconnue(int n) {
        super("La partie numéro " + n + " n'existe pas.");
    }

}
