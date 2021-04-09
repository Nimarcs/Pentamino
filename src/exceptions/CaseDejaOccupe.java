package exceptions;

/**
 * Exception représentant le cas ou on essaie de placer une pièce sur une autre pièce.
 */
public class CaseDejaOccupe extends Exception {

    public CaseDejaOccupe(int x, int y, char already) {
        super(String.format("La position [%s, %s] est déjà occupé par %s", x, y, already));
    }

    public CaseDejaOccupe() {
        super("Une pièce empiète sur une autre pièce");
    }

}
