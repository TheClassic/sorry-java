package engine;

import ui.Visualizer;

public class Executor {
    private State state = new State();
    private Visualizer ui = new Visualizer();

    public void run() {
        while(!state.gameOver()) {
            ui.printBoard(state);
            ui.printCard(state);
            state = ui.getMove(Options.getOptions(state));
            state.finishTurn();
        }
    }


}
