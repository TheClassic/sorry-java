package engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void findWinnerWhenNoWinnnerExists() {
        Board testBoard = new Board();
        Optional<Color> winner = testBoard.findWinner();
        assertTrue(winner.isEmpty());
    }

    @Test
    void findWinnerWhenFirstColorIsWinner() {

    }

    @Test
    void findWinnerWhenLastColorIsWinner() {

    }
}