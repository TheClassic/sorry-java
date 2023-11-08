package ui;

import engine.Board;
import engine.Color;
import engine.Positions;
import engine.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Visualizer {
    final private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    public void printBoard(State gameState) {
        Board board = gameState.getCurrentPositions();
        System.out.println(Color.values()[0] + "\t" + Color.values()[1]);
        for(int i=0; i<Positions.getSize(); ++i) {
            String row = "";
            for(Positions positions : board) {
                row += (positions.getPawnLocation(i));
                row += "\t\t";
            }
            System.out.println(row);
        }
    }

    public void printCard(State gameState) {
        System.out.println("You drew a " + gameState.getNextCard());
    }

    public State getMove(ArrayList<State> options) {
        try {
            reader.readLine();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return options.getFirst();
    }
}
