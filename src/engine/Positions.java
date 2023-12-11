package engine;

import java.util.Arrays;

public class Positions {
    static public int getSize() { return Color.values().length; }
    static public int SAFE = 40;
    static public int HOME = 40;
    static public int START = 0;
    int[] pawnLocations = {0, 0, 0, 0}; //ToDo make this based on number of colors

    public int getPawnLocation(int n) {
        return pawnLocations[n];
    }

    public void movePawn(int pawn, int destination) {
        pawnLocations[pawn] = destination;
    }

    public boolean allPawnsAtFinish() {
        return Arrays.stream(pawnLocations)
                .allMatch(position -> position == HOME);
    }
}
