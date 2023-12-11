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
            if(positions.getPawnLocation(i)!=Positions.HOME) {
                int newPosition = min(Positions.HOME,positions.getPawnLocation(i)+card);
                positions.movePawn(i,  newPosition);
                options.add(newBoard);
            }
        }
        return options;
    }

    // the engine should share this with the UI and allow indicating an index for the desired option
}
