package exceptions;

/**
 * Exception représentant le fait de vouloir récupèrer la dernière partie d'un joueur alors qu'il n'en a pas.
 */
public class PartieInconnue extends Exception {

    public PartieInconnue(int n) {
        super("La partie numéro " + n + " n'existe pas.");
    }

}
