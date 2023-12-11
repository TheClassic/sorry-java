package engine;

import java.util.Optional;
import java.util.Random;

public class State {
    private final Random random = new Random();

    private Color currentTurnColor = getFirstPLayer();

    private Color getFirstPLayer() {
        return Color.values()[random.nextInt(Color.values().length)];
    }

    //TODO think about preventing writing this via reference
    private Board currentPositions = new Board();

    //TODO ensure order of things (draw card, move, next turn)

    private Deck deck = new Deck();

    private Optional<Color> winner = Optional.empty();

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

    public void finishTurn() {
        if (currentTurnColor == Color.YELLOW) {
           currentTurnColor = Color.GREEN;
        } else {
            currentTurnColor = Color.YELLOW;
        }

        winner = currentPositions.findWinner();
    }
    
}
