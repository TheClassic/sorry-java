package simulator;

import engine.Game;
import ui.Visualizer;

public class MonteCarloEngine {
    private GameSimulator simulator = new GameSimulator();
    private MonteCarloUI ui = new MonteCarloUI();
    private MonteCarloStats stats = new MonteCarloStats();

    public void run() {
        for(int i = 0; i < ui.getNumberOfRuns(); ++i) {
            Game game = new Game(simulator);
            game.run();
            stats.addWin(game.getWinner());
        }
        ui.reportStats(stats);
    }
}
