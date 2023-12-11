package engine;

import java.util.ArrayList;
import java.util.Random;

import static engine.Color.RED;
import static engine.Color.YELLOW;

public class Game {
    private State state;
    final private GamePlayInterface gamePlayInterface;

    private final Random random = new Random();

    public Game(GamePlayInterface gpi) {
        gamePlayInterface = gpi;
        state = new State(this, getFirstPLayer());
    }

    private Color getFirstPLayer() {
        Color firstPlayer = Color.values()[random.nextInt(Color.values().length)];
        // so dirty, but should work well
        if(!isPlayerActive(firstPlayer)) {
            firstPlayer = getFirstPLayer();
        }
        return firstPlayer;
    }

    public void run() {
        while(!state.gameOver()) {
            gamePlayInterface.announceBoard(state);

            gamePlayInterface.announceCard(state.getNextCard());
            ArrayList<Board> possibleMoves = Options.getOptions(state);
            int desiredMove = gamePlayInterface.getMove(possibleMoves);
            state.makeMove(possibleMoves.get(desiredMove));
            state.finishTurn();
        }
        gamePlayInterface.announceWinner(state.getWinner());
        gamePlayInterface.announceBoard(state);
    }

    public boolean isPlayerActive(Color player) {
        return player == YELLOW || player == RED;
    }

    public Color getWinner() {
        return state.getWinner();
    }
}
