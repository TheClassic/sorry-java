package simulator;

import engine.Game;
import util.GameFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MonteCarloEngine {
    private final GameFactory gameFactory;
    private final MonteCarloUI ui = new MonteCarloUI();
    private final MonteCarloStats stats = new MonteCarloStats();

    private static final int threadCount = Runtime.getRuntime().availableProcessors();

    static {
        System.out.println("Using " + threadCount + " threads for Monte Carlo simulation.");
    }

    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

    public MonteCarloEngine(GameFactory gameFactory) {
        this.gameFactory = gameFactory;
    }

    //TODO gotta catch exceptions during the game
    public void run() {
        for (int i = 0; i < ui.getNumberOfRuns(); ++i) {
            executorService.submit(() -> {
                playGame();
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
        ui.reportStats(stats);
    }

    private void playGame() {
        Game game = gameFactory.createGame();
        game.run();
        stats.addWin(game.getWinner());
    }
}