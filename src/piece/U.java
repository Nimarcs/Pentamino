package piece;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;

import java.io.IOException;

public class U extends Piece{

    public U(int x, int y) throws ValeurNonTraite, CharInvalide, CoordonneeInvalide, IOException {
        super(x, y, 'U', "U.txt");
    }



}
