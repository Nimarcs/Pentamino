package piece;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;

import java.io.IOException;

public class V extends Piece{

    public V(int x, int y) throws IOException, CoordonneeInvalide, ValeurNonTraite, CharInvalide {
        super(x, y, 'V', "V.txt");
    }



}
