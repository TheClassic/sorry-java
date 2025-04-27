package engine;

import java.util.ArrayList;

public interface GamePlayInterface {
    void announceBoard(State gameState);

    void announceCard(int cardValue);

    int getMove(Color turn, ArrayList<Board> options);

    void announceWinner(Color winner);
}
