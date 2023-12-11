package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Color is the index
public class Board {
    private ArrayList<Positions> positions = new ArrayList<>();
    private static Gson gson = new GsonBuilder().create();

    public Board() {
        positions.add(Color.GREEN.ordinal(), new Positions());
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
}
