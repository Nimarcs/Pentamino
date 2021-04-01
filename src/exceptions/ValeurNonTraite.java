package exceptions;

public class ValeurNonTraite extends Exception {

    public ValeurNonTraite(char val) {
        super(String.format("Le char [%s] n'est pas traité.", val));
    }
}