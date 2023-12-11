package engine;

import java.util.ArrayList;

public class Game {
    private State state = new State();
    final private GamePlayInterface gamePlayInterface;

    public Game(GamePlayInterface gpi) {
        gamePlayInterface = gpi;
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

    public Color getWinner() {
        return state.getWinner();
    }
}
