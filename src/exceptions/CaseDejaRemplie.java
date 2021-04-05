package exceptions;

public class CaseDejaRemplie extends Exception {

    public CaseDejaRemplie(int x, int y, char already) {
        super(String.format("La position [%s, %s] est déjà occupé par %s", x, y, already));
    }

}
