package exceptions;

/**
 * Exception représentant le cas ou un charactère n'est pas traité lors de la lecture d'un fichier.
 */
public class ValeurNonTraite extends Exception {

    public ValeurNonTraite(char val) {
        super(String.format("Le char [%s] n'est pas traité.", val));
    }
}