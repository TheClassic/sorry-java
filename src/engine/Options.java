package engine;

import java.util.ArrayList;

import static java.lang.Math.min;

public class Options {
    // returns an array of optional ending states for a turn
    public static ArrayList<Board> getOptions(State state) {
        ArrayList<Board> options = new ArrayList<>();

        int card = state.getCurrentCard();
        Board board = state.getCurrentPositions();
        // should probably refactor positions into ArrayList
        for(int i=0; i<Positions.getSize(); ++i) {
            Board newBoard = board.clone();

            Positions positions = newBoard.get(state.getCurrentTurn());
            if(Positions.START == positions.getPawnLocation(i)) {
                if(1==card || 2==card) {
                    card = 1; //TODO implement a second turn (although its probably not terribly important for this simulation
                    // todo avoid collision with self
                    // todo encapsulate logic of next three lines
                    int newPosition = 0;
                    positions.movePawn(i, newPosition);
                    enforcePawnCollision(state.getCurrentTurn(), newPosition, newBoard);
                    options.add(newBoard);
                }
                continue;
            }
            if(positions.getPawnLocation(i)!=Positions.HOME) {
                if(12 != card) {
                    int newPosition = min(Positions.HOME, positions.getPawnLocation(i) + card);
                    // todo avoid collision with self
                    positions.movePawn(i, newPosition);
                    enforcePawnCollision(state.getCurrentTurn(), newPosition, newBoard);
                    options.add(newBoard);
                }
            }
        }
        return options;
    }

    // responsible for determining and enforcing if the current ending position sends another pawn back to start
    public static boolean enforcePawnCollision(Color currentTurn, int finalPosition, Board newBoard) {
        for (Color opponentColor : Color.values()) {
            if(opponentColor == currentTurn) {
                continue;
            }
            int opponentEquivPosition = Board.getEquivalentPosition(currentTurn, finalPosition, opponentColor);
            if(opponentEquivPosition>0) {
                Positions opponentPositions = newBoard.get(opponentColor);
                for(int i=0; i<Positions.getSize(); ++i) {
                    if(opponentEquivPosition == opponentPositions.getPawnLocation(i)) {
                        opponentPositions.movePawn(i, Positions.START);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // the engine should share this with the UI and allow indicating an index for the desired option
}
