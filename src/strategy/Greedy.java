package strategy;

import engine.Board;
import engine.Color;
import engine.Positions;

import java.util.Comparator;

public class Greedy {
    private final Color color;

    public Greedy(Color color) {
        this.color = color;
    }

    public final Comparator<Board> GREEDY_COMPARATOR = new Comparator<Board>() {
        @Override
        public int compare(Board o1, Board o2) {
            if(o1.findWinner().isPresent())
                return -1;
            if(o2.findWinner().isPresent())
                return 1;
            return Integer.compare(scorePositions(o1), scorePositions(o2));
        }
    };

    public int scorePositions(Board board) {
        int score = 0;

        for (Color color : Color.values()) {
            Positions positions = board.get(color);
            if (color == this.color) {
                for (int i = 0; i < positions.getSize(); i++) {
                    score -= positions.getPawnLocation(i);
                }
            }
            else {
                for (int i = 0; i < positions.getSize(); i++) {
                    score += positions.getPawnLocation(i);
                }
            }

        }
        return score;
    }
}
