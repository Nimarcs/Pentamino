package exceptions;

public class CharInvalide extends Exception {

    public CharInvalide(char val) {
        super(String.format("Le char [%s] n'est pas une lettre.", val));
    }
}