package util;

import engine.Color;
import engine.Game;
import engine.GamePlayInterface;

import java.util.Set;

public class DefaultGameFactory implements GameFactory {
    private final GamePlayInterface gamePlayInterface;
    private final Set<Color> activePlayerColors;

    public DefaultGameFactory(GamePlayInterface gamePlayInterface, Set<Color> activePlayerColors) {
        this.gamePlayInterface = gamePlayInterface;
        this.activePlayerColors = activePlayerColors;
    }

    @Override
    public Game createGame() {
        return new Game(gamePlayInterface, activePlayerColors);
    }
}