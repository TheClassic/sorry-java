package simulator;

import engine.Color;
import engine.State;

import java.util.ArrayList;

public class GameSimulator implements engine.GamePlayInterface {

    @Override
    public void announceBoard(State gameState) {
    }

    @Override
    public void announceCard(State gameState) {
    }

    @Override
    public State getMove(ArrayList<State> options) {
        return options.getFirst();
    }

    @Override
    public void announceWinner(Color winner) {

    }
}
