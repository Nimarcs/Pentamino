package piece;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;

import java.io.IOException;

public class L extends Piece{

    public L(int x, int y) throws CoordonneeInvalide, CharInvalide, IOException, ValeurNonTraite {
        super(x, y, 'L', "L.txt");
    }



}