package exceptions;

/**
 * Exception représentant le cas ou un déplacement est interdis par un mode de jeu
 */
public class PlacementInterdit extends Exception {

    public PlacementInterdit(String msg) { super(msg); }

}
