package exceptions;

public class CoordonneeInvalide extends Exception {

    public CoordonneeInvalide(int x, int y) {
        super(String.format("La coordonée [%s;%s] est négative.", x, y));
    }
}
