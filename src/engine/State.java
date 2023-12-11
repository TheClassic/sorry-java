package engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.Optional;
import java.util.Random;

public class State {
    private final Random random = new Random();

    private Color currentTurnColor;
    private Game game;

    //TODO think about preventing writing this via reference
    private Board currentPositions = new Board();

    private Deck deck = new Deck();

    private Optional<Color> winner = Optional.empty();

    public State(Game game, Color firstPlayer) {
        this.game = game;
        currentTurnColor = firstPlayer;
    }

    public Board getCurrentPositions() { return currentPositions;}
    public int getNextCard() { return deck.getNextCard(); }
    public int getCurrentCard() { return deck.getCurrentCard(); }
    public Color getCurrentTurn() {
        return currentTurnColor;
    }
    public boolean gameOver() { return winner.isPresent(); }
    public Color getWinner() { return winner.get(); }

    public void makeMove(Board desiredBoard) {
        currentPositions = desiredBoard;
    }

    private Color advanceToNextPlayer(Color currentPlayer) {
        int ordinal = currentPlayer.ordinal();
        Color[] values = Color.values();
        int nextOrdinal = (ordinal+1) % values.length;
        Color nextPlayer = values[nextOrdinal];

        if(!game.isPlayerActive(nextPlayer)) {
            nextPlayer = advanceToNextPlayer(nextPlayer);
        }

        return nextPlayer;
    }

    public void finishTurn() {
        currentTurnColor = advanceToNextPlayer(currentTurnColor);

        winner = currentPositions.findWinner();
    }
    
}
