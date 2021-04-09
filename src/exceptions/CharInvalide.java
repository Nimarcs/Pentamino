package exceptions;

/**
 * Exception représentant le cas ou le charactères associé à une Piece n'est pas une lettre
 */
public class CharInvalide extends Exception {

    public CharInvalide(char val) {
        super(String.format("Le char [%s] n'est pas une lettre.", val));
    }
}