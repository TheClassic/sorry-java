package engine;

import java.util.ArrayList;

public class Options {
    // returns an array of optional ending states for a turn
    public static ArrayList<State> getOptions(State state) {
        ArrayList<State> options = new ArrayList<>();

        int card = state.getCurrentCard();
        // should probably refactor positions into ArrayList
        for(int i=0; i<Positions.getSize(); ++i) {
            State originalState = state.clone();
            Board board = state.getCurrentPositions();
            Positions positions = board.get(state.getCurrentTurn());
            if(positions.getPawnLocation(i)!=Positions.HOME) {
                positions.movePawn(i,  1+positions.getPawnLocation(i));
                options.add(state);
                state = originalState;
            }
        }
        return options;
    }

    // the engine should share this with the UI and allow indicating an index for the desired option
}
