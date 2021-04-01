package piece;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;

import java.io.IOException;

public class L extends Piece{

    public L(int x, int y) throws CoordonneeInvalide, ValeurNonTraite, CharInvalide, IOException {
        super(x, y, 'L', "L.txt");
    }



}