package engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.Optional;

public class State {
    private static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() // this excludes serializing our optional winner
            .create();
    private Color currentTurnColor = Color.GREEN;
    //TODO think about preventing writing this via reference
    final private Board currentPositions = new Board();

    //TODO ensure order of things (draw card, move, next turn)

    private Deck deck = new Deck();

    private Optional<Color> winner = Optional.empty();

    public State clone() {
        return gson.fromJson(gson.toJson(this), State.class);
    }

    public Board getCurrentPositions() { return currentPositions;}
    public int getNextCard() { return deck.getNextCard(); }
    public int getCurrentCard() { return deck.getCurrentCard(); }
    public Color getCurrentTurn() {
        return currentTurnColor;
    }
    public boolean gameOver() { return winner.isPresent(); }
    public Color getWinner() { return winner.get(); }

    public void finishTurn() {
        if (currentTurnColor==Color.YELLOW) {
           currentTurnColor = Color.GREEN;
        } else {
            currentTurnColor = Color.YELLOW;
        }

        winner = currentPositions.findWinner();
    }
    
}
