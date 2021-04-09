package exceptions;

/**
 * Exception représentant le cas ou des coordonées ne respectent pas certaines conditions
 */
public class CoordonneeInvalide extends Exception {
    public CoordonneeInvalide(int x, int y) {
        super(String.format("La coordonée [%s;%s] est négative.", x, y));
    }
}
