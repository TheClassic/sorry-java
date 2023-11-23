package engine;

import java.util.ArrayList;
import java.util.Optional;

// Color is the index
public class Board extends ArrayList<Positions> {
    public Board() {
        this.add(Color.GREEN.ordinal(), new Positions());
        this.add(Color.YELLOW.ordinal(), new Positions());
    }
    public Positions get(Color color) {
        return get(color.ordinal());
    }

    // TODO this method is so gross, clean it up
    public Optional<Color> findWinner() {
        Optional<Color> winner = Optional.empty();
        for(Color color : Color.values()) {
            Positions positions = get(color);
            boolean notWinner = false;
            for(int i=0; i<Positions.getSize(); ++i) {
                if(positions.getPawnLocation(i)!=Positions.FINISH) {
                    notWinner = true;
                    break;
                }
            }
            if(notWinner) {
                break;
            } else {
                winner = Optional.of(color);
            }
        }
        return winner;
    }
}
