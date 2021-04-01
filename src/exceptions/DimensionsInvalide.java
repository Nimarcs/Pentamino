package exceptions;

public class DimensionsInvalide extends Exception {

    public DimensionsInvalide(int x, int y) {
        super(String.format("Dimensions (%s;%s) invalides (< 0)", x, y));
    }

}
