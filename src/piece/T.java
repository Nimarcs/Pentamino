package piece;

import exceptions.CharInvalide;
import exceptions.CoordonneeInvalide;
import exceptions.ValeurNonTraite;

import java.io.IOException;

public class T extends Piece{

    public T(int x, int y) throws IOException, CoordonneeInvalide, ValeurNonTraite, CharInvalide {
        super(x, y, 'T', "T.txt");
    }



}