package simulator;

import engine.Game;
import ui.Visualizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MonteCarloEngine {
    private GameSimulator simulator = new GameSimulator();
    private MonteCarloUI ui = new MonteCarloUI();
    private MonteCarloStats stats = new MonteCarloStats();

    private static final int threadCount=4;

    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);


    //TODO gotta catch exceptions during the game
    public void run() {
        for(int i = 0; i < ui.getNumberOfRuns(); ++i) {
            executorService.submit(() -> {playGame();});
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        }
        catch (InterruptedException e) {
        }
        ui.reportStats(stats);
    }

    private void playGame() {
        Game game = new Game(simulator);
        game.run();
        stats.addWin(game.getWinner());
    }
}
