import engine.Color;
import engine.GamePlayInterface;
import simulator.GameSimulator;
import simulator.MonteCarloEngine;
import util.DefaultGameFactory;

import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!\n");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

        GamePlayInterface gameSimulator = new GameSimulator();
        Set<Color> activeColors = Set.of(Color.BLUE, Color.YELLOW);
        new MonteCarloEngine(new DefaultGameFactory(gameSimulator, activeColors)).run();

        activeColors = Set.of(Color.BLUE, Color.RED);
        new MonteCarloEngine(new DefaultGameFactory(gameSimulator, activeColors)).run();

        activeColors = Set.of(Color.YELLOW, Color.RED);
        new MonteCarloEngine(new DefaultGameFactory(gameSimulator, activeColors)).run();

        activeColors = Set.of(Color.GREEN, Color.BLUE);
        new MonteCarloEngine(new DefaultGameFactory(gameSimulator, activeColors)).run();

        activeColors = Set.of(Color.GREEN, Color.BLUE, Color.YELLOW);
        new MonteCarloEngine(new DefaultGameFactory(gameSimulator, activeColors)).run();


        // Press Shift+F9 to start debugging your code. We have set one breakpoint
        // for you, but you can always add more by pressing Ctrl+F8.
    }
}