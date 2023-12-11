package engine;

import java.util.Arrays;

public class Positions {
    static public int getSize() { return 2;}
    static public int HOME = 10;
    static public int FINISH = 10;
    static public int START = 0;
    int[] pawnLocations = {0, 0};

    public int getPawnLocation(int n) {
        return pawnLocations[n];
    }

    public void movePawn(int pawn, int destination) {
        pawnLocations[pawn] = destination;
    }

    public boolean allPawnsAtFinish() {
        return Arrays.stream(pawnLocations)
                .allMatch(position -> position == FINISH);
    }
}
