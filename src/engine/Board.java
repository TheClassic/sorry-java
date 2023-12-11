package engine;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    public Optional<Color> findWinner() {
        return Arrays.stream(Color.values())
                .filter(color -> get(color).allPawnsAtFinish())
                .findFirst();
    }
}
