package engine;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Game {
    private State state;
    private final GamePlayInterface gamePlayInterface;
    private final Random random = new Random();
    private final Set<Color> activePlayerColors;

    public Game(GamePlayInterface gpi, Set<Color> activePlayerColors) {
        this.gamePlayInterface = gpi;
        this.activePlayerColors = activePlayerColors;
        this.state = new State(this, getFirstPlayer());
    }

    private Color getFirstPlayer() {
        Color firstPlayer;
        do {
            firstPlayer = Color.values()[random.nextInt(Color.values().length)];
        } while (!isPlayerActive(firstPlayer));
        return firstPlayer;
    }

    public void run() {
        while (!state.gameOver()) {
            gamePlayInterface.announceBoard(state);

            gamePlayInterface.announceCard(state.getNextCard());
            ArrayList<Board> possibleMoves = Options.getOptions(state);
            if (possibleMoves.size() > 0) {
                int desiredMove = gamePlayInterface.getMove(possibleMoves);
                state.makeMove(possibleMoves.get(desiredMove));
            }
            state.finishTurn();
        }
        gamePlayInterface.announceWinner(state.getWinner());
        gamePlayInterface.announceBoard(state);
    }

    public boolean isPlayerActive(Color player) {
        return activePlayerColors.contains(player);
    }

    public Color getWinner() {
        return state.getWinner();
    }
}