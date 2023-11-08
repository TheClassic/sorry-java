package engine;

public class Positions {
    static public int getSize() { return 2;}
    static public int HOME = 10;
    static public int START = 0;
    int[] pawnLocations = {0, 0};

    public int getPawnLocation(int n) {
        return pawnLocations[n];
    }

    public void movePawn(int pawn, int location) {
        pawnLocations[pawn] = location;
    }
}
