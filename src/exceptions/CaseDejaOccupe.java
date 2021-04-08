package exceptions;

public class CaseDejaOccupe extends Exception {

    public CaseDejaOccupe(int x, int y, char already) {
        super(String.format("La position [%s, %s] est déjà occupé par %s", x, y, already));
    }

    public CaseDejaOccupe() {
        super("Une pièce empiète sur une autre pièce");
    }

}
