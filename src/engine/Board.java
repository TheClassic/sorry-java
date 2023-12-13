package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Color is the index
public class Board {
    private ArrayList<Positions> positions = new ArrayList<>();
    private static final Gson gson = new GsonBuilder().create();

    public Board() {
        //TODO make this a loop
        positions.add(Color.GREEN.ordinal(), new Positions());
        positions.add(Color.RED.ordinal(), new Positions());
        positions.add(Color.BLUE.ordinal(), new Positions());
        positions.add(Color.YELLOW.ordinal(), new Positions());
    }

    public Board clone() {
        return gson.fromJson(gson.toJson(this), Board.class);
    }
    public Positions get(Color color) {
        return positions.get(color.ordinal());
    }
    
    public Optional<Color> findWinner() {
        return Arrays.stream(Color.values())
                .filter(color -> get(color).allPawnsAtFinish())
                .findFirst();
    }

    // negative value indicates no equivalent position
    // instead of adding a representation for sliders, start, and home for each color
    // we represent it once and know that each color is offset by X spaces
    // this needs unit testing!!!
    public static int getEquivalentPosition(Color inputColor, int position, Color outputColor) {
        int outputPosition = -1;

        if(!Positions.isSafe(position)) {
            outputPosition = position + 10*(((4+outputColor.ordinal()-inputColor.ordinal()))%4);
        }

        return outputPosition;
    }

}
