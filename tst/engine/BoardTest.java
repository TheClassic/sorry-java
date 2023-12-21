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

    @Test
    void getEquivalentPositionWhenInvalid() {
        assertEquals(-1, Board.getEquivalentPosition(Color.GREEN, 65, Color.RED));

    }

    @Test
    void getEquivalentPositionGreenBlue() {
        assertEquals(30, Board.getEquivalentPosition(Color.GREEN, 0, Color.BLUE));
        assertEquals(42, Board.getEquivalentPosition(Color.GREEN, 12, Color.BLUE));
        assertEquals(20, Board.getEquivalentPosition(Color.GREEN, 50, Color.BLUE));
    }

    @Test
    void getEquivalentPositionGreenRed() {
    }

    @Test
    void getEquivalentPositionRedGreen() {
    }
}