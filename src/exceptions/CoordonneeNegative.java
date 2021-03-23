package exceptions;

public class CoordonneeNegative extends Exception {

    public CoordonneeNegative(int x) {
        super("La coordonée " + x + " est négative.");
    }
}
