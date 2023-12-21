package engine;

import java.util.Arrays;

public class Positions {
    static public int getSize() { return Color.values().length; }
    static public int SAFE = 60;
    static public int HOME = 66;
    //TODO make start a large negative number so that negative zero can used as the bridge
    // from the first spot to HOME
    static public int START = -333;
    int[] pawnLocations = {0, 0, 0, 0}; //ToDo make this based on number of colors

    public static boolean isSafe(int position) {
        return SAFE == position || START == position;
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
