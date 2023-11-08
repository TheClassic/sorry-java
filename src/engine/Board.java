package engine;

import java.util.ArrayList;

// Color is the index
public class Board extends ArrayList<Positions> {
    public Board() {
        this.add(Color.GREEN.ordinal(), new Positions());
        this.add(Color.YELLOW.ordinal(), new Positions());
    }
    public Positions get(Color color) {
        return get(color.ordinal());
    }
}
