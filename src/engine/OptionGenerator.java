package engine;

import java.util.ArrayList;

import static java.lang.Math.min;

public class OptionGenerator {
    // returns an array of optional ending states for a turn
    public static ArrayList<Board> getOptions(State state) {
        ArrayList<Board> options = new ArrayList<>();

        int card = state.getCurrentCard();

        if(11==card) {
            return getElevenCardOptions(state);
        }

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

    public static Option createOptionForMove(Board board, Color turnColor, int pawnIndex, int newPosition) {
        Board newBoard = board.clone();
        Positions positions = newBoard.get(turnColor);
        positions.movePawn(pawnIndex, newPosition);
        enforcePawnCollision(turnColor, newPosition, newBoard);

        // TODO how we going to find the old position
        // TODO how do we get info about the old position of any impacted other pawn
        return ImmutableOption.builder().board(newBoard).newPosition(newPosition);
    }

    private static ArrayList<Board> getElevenCardOptions(State state) {
        Board board = state.getCurrentPositions();
        Color currentTurnColor = state.getCurrentTurn();

        Positions positions = board.get(currentTurnColor);
        // should probably refactor positions into ArrayList
        // this should be more like "for each pawn"
        for (int i = 0; i < Positions.getSize(); ++i) {
            if (positions.getPawnLocation(i) == Positions.START) {
                continue;
            }

            // need to clone every time I find a potential move, not so soon
            Board newBoard = board.clone();

            if (positions.getPawnLocation(i) != Positions.START) {
                for (Color opponentColor : Color.values()) {
                    if (opponentColor == state.getCurrentTurn()) {
                        continue;
                    }
                    // we want to find all swappable opponents add them as options
                    // however, 11 card logic, sorry card logic, and enforce pawn collision
                    // will share some logic, lets see if we can extract and reuse that
                    // after some thought, probably not too much that's reuseable,
                    // but this should still be a separate testable method

                    // we want to leave the door for other decision making, but
                    // we probably want to ensure the first choice on the array
                    // should be the highest numbered opponent
                    // this should probably be a method that finds all the options
                    // and sorts them by end spot

                    // make sure to encapsulate and call logic for simply moving forward
                }
            }
        }
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
