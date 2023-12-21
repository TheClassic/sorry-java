package simulator;

import engine.Color;

public class MonteCarloUI {
    int getNumberOfRuns() {
        return 5000;
    }

    void reportStats(MonteCarloStats stats) {
        String heading = "";
        for (Color color : Color.values()) {
            heading += color.name() + ' ';
        }
        System.out.println(heading);
        String wins = "";
        for (Color color : Color.values()) {
            wins += String.format("%d ", stats.getWins(color));
        }
        System.out.println(wins);
    }
}
