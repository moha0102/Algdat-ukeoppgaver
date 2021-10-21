package Uke38.ForelesningTirsdag;

public class towerOfHanoy {
    /*
    Lager en funksjon som kjører tower of hanoi
    @param pieces Antall brikker å bruke i tower of hanoi
    */
    public static void towerOfHanoi(int piece) {
        hanoyMove(piece, 'A', 'C', 'B');
    }

    public static void hanoyMove(int piece, char from, char to, char helper) {
        // Vi slutter rekusjon når vi kommer til øverste brikke.
        if (piece < 0) {
            return;
        }
        // (1) Flytt alt fra stikke C over til stikke B
        hanoyMove(piece-1, to, helper, from);
        // (2) Flytt øverste brikke fra A til C
        System.out.println("Flytter " + piece + " " + from + " - " + to);
        // (3) Flytt alt på stikk B fra punkt 1, over på stikke C
        hanoyMove(piece-1, helper, to, from);
    }
    public static void main(String[] args) {
        towerOfHanoi(1);
    }
}
