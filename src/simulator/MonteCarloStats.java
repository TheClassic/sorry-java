package simulator;

import engine.Color;

import java.util.Arrays;

// Your data structure class
public class MonteCarloStats {
    private final int[] wins;

    public MonteCarloStats() {
        wins = new int[Color.values().length];
        Arrays.fill(wins, 0); //probably unneccessary
    }

    public synchronized void addWin(Color winner) {
        ++wins[winner.ordinal()];
    }

    public int getWins(Color color) {
        return wins[color.ordinal()];
    }
}
