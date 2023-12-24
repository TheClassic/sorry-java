package engine;

import org.immutables.value.Value;


@Value.Immutable
public class Option {

    int newPosition;
    int oldPosition;
    int opponentNewPosition;
    int opponentOldPosition;
    Board board;

    public int GetNetPosition() {
        return newPosition-oldPosition;
    }

    public int GetNetOpponentPosition() {
        return opponentNewPosition-opponentOldPosition;
    }
}
