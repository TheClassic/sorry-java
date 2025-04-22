package engine;

import java.util.Arrays;

public class Positions {
    static public int getSize() { return Color.values().length; }
    static public int SAFE = 61; //assumes first spot is 1, moving back 1 is 0, and last spot before safe is 60
    static public int HOME = 66;
    //TODO make start a large negative number so that negative one can used as the bridge
    // from the first spot to HOME
    static public int START = -333;
    int[] pawnLocations = {START, START, START, START};

    public static boolean isSafe(int position) {
        return SAFE <= position || START == position;
    }

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
