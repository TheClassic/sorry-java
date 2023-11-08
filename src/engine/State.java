package engine;

import com.google.gson.Gson;

public class State {
    private static Gson gson = new Gson();
    private Color currentTurnColor = Color.GREEN;
    //TODO think about preventing writing this via reference
    final private Board currentPositions = new Board();

    //TODO ensure order of things (draw card, move, next turn)

    private Deck deck = new Deck();

    public State clone() {
        return gson.fromJson(gson.toJson(this), State.class);
    }

    public Board getCurrentPositions() { return currentPositions;}
    public int getNextCard() { return deck.getNextCard(); }
    public int getCurrentCard() { return deck.getCurrentCard(); }
    public Color getCurrentTurn() {
        return currentTurnColor;
    }
    public boolean gameOver() { return false; }

    public void finishTurn() {
        if (currentTurnColor==Color.YELLOW) {
           currentTurnColor = Color.GREEN;
        } else {
            currentTurnColor = Color.YELLOW;
        }
    }
    
}
