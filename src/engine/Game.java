package engine;

public class Game {
    private State state = new State();
    final private GamePlayInterface gamePlayInterface;

    public Game(GamePlayInterface gpi) {
        gamePlayInterface = gpi;
    }

    public void run() {
        while(!state.gameOver()) {
            gamePlayInterface.announceBoard(state);
            gamePlayInterface.announceCard(state);
            state = gamePlayInterface.getMove(Options.getOptions(state));
            state.finishTurn();
        }
    }


}
