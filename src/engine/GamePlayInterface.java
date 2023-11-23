package engine;

import java.util.ArrayList;

public interface GamePlayInterface {
    void announceBoard(State gameState);

    void announceCard(State gameState);

    State getMove(ArrayList<State> options);

    void announceWinner(Color winner);
}
