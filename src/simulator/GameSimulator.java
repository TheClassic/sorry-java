package simulator;

import engine.Board;
import engine.Color;
import engine.State;

import java.util.ArrayList;

public class GameSimulator implements engine.GamePlayInterface {

    @Override
    public void announceBoard(State gameState) {
    }

    @Override
    public void announceCard(int cardValue) {
    }

    @Override
    public int getMove(ArrayList<Board> options) {
        return 0;
    }

    @Override
    public void announceWinner(Color winner) {

    }
}
