package jeu;

public class Jeu {

    public static void main(String[] args) {
        boolean isEnd = false;
        Partie jeu = null;
        try {
            jeu = new Partie(10, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!isEnd) {

        }
    }

}
