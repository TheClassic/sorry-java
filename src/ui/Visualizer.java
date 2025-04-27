package ui;

import engine.Board;
import engine.Color;
import engine.Positions;
import engine.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Visualizer implements engine.GamePlayInterface {
    final private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    @Override
    public void announceBoard(State gameState) {
        Board board = gameState.getCurrentPositions();
        System.out.println(Color.values()[0] + "\t" + Color.values()[1] + Color.values()[2] + Color.values()[3]);
        for(int i=0; i<Positions.NUM_PAWNS; ++i) {
            String row = "";
            for (Color color : Color.values()) {
                Positions positions = board.get(color);
                row += (positions.getPawnLocation(i));
                row += "\t\t";
            }
            System.out.println(row);
        }
        System.out.println(gameState.getCurrentTurn() + " turn");
    }

    @Override
    public void announceCard(int cardValue) {
        System.out.println("You drew a " + cardValue);
    }

    @Override
    public int getMove(Color turn, ArrayList<Board> options) {
        try {
            reader.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void announceWinner(Color winner) {
        System.out.println(winner + " won the game!");
    }
}
