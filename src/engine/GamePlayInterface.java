package engine;

import java.util.ArrayList;

public interface GamePlayInterface {
    void announceBoard(State gameState);

    void announceCard(int cardValue);

    int getMove(ArrayList<Board> options);

    void announceWinner(Color winner);
}
