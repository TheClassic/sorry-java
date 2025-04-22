package engine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OptionsTest {

    /*
    @Test
    void testCreateSorryMoveOptions() {
        Board testBoard = new Board();
        testBoard.setPosition(Color.RED, 1);
        testBoard.setPosition(Color.GREEN, 1);
        testBoard.setPosition(Color.BLUE, 1);
        testBoard.setPosition(Color.YELLOW, 1);
        ArrayList<Board> options = new ArrayList<>();
        Options.createSorryMoveOptions(Color.GREEN, testBoard, 0, options);
        assertEquals(4, options.size());
    }

    void testCreateSorryMoveHasNoOptionsWhenAllInStart() {
        Board testBoard = new Board();
        ArrayList<Board> options = new ArrayList<>();
        Options.createSorryMoveOptions(Color.GREEN, testBoard, 0, options);
        assertEquals(0, options.size());
    }

    @Test
    void testEnforcePawnCollisionFindsCollision() {
        Board testBoard = new Board();
        testBoard.setPosition(Color.RED, 1);
        testBoard.setPosition(Color.GREEN, 1);
        testBoard.enforcePawnCollision(Color.RED, Color.GREEN);
        assertEquals(Positions.START, testBoard.getPosition(Color.RED));
        assertEquals(Positions.START, testBoard.getPosition(Color.GREEN));
    }

    void testEnforcePawnCollisionFindsNoCollision() {
        Board testBoard = new Board();
        testBoard.setPosition(Color.RED, 1);
        testBoard.setPosition(Color.GREEN, 2);
        testBoard.enforcePawnCollision(Color.RED, Color.GREEN);
        assertEquals(1, testBoard.getPosition(Color.RED));
        assertEquals(2, testBoard.getPosition(Color.GREEN));
    }

     */
}