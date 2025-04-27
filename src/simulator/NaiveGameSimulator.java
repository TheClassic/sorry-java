package simulator;

import engine.Board;
import engine.Color;
import engine.State;
import strategy.Greedy;

import java.util.ArrayList;
import java.util.Random;

public class NaiveGameSimulator implements engine.GamePlayInterface {
    private final Random random = new Random();

    @Override
    public void announceBoard(State gameState) {
    }

    @Override
    public void announceCard(int cardValue) {
    }

    @Override
    public int getMove(Color turnColor, ArrayList<Board> options) {
        Greedy greedyStrategy = new Greedy(turnColor);
        options.sort(greedyStrategy.GREEDY_COMPARATOR);
        return random.nextInt(0,options.size());
    }

    @Override
    public void announceWinner(Color winner) {

    }
}
