package engine;

import java.util.ArrayList;

public interface GamePlayInterface {
    void announceBoard(State gameState);

    void announceCard(int cardValue);

    State getMove(ArrayList<State> options);

    void announceWinner(Color winner);
}
