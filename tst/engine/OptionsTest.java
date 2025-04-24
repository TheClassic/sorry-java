package engine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OptionsTest {

    @Test
    void testCreateSorryMoveOptions() {
        Board testBoard = new Board();
        testBoard.get(Color.RED).movePawn(0, 3);
        ArrayList<Board> options = new ArrayList<>();
        Options.createSorryMoveOptions(Color.GREEN, testBoard, 0, options);
        assertEquals(1, options.size());

        assertEquals(Positions.START, options.get(0).get(Color.RED).getPawnLocation(0));
        assertNotEquals(Positions.START, options.get(0).get(Color.GREEN).getPawnLocation(0));
    }

    @Test
    void testCreateSorryMoveHasNoOptionsWhenAllInStart() {
        Board testBoard = new Board();
        ArrayList<Board> options = new ArrayList<>();
        Options.createSorryMoveOptions(Color.GREEN, testBoard, 0, options);
        assertEquals(0, options.size());
    }

    @Test
    void testEnforcePawnCollisionFindsCollision() {
        Board testBoard = new Board();
        testBoard.get(Color.RED).movePawn(0, 3);
        testBoard.get(Color.YELLOW).movePawn(0, 3);
        testBoard.get(Color.GREEN).movePawn(0, 3);
        testBoard.get(Color.BLUE).movePawn(0, 3);

        assertFalse(Options.enforcePawnCollision(Color.RED, 17, testBoard));
        assertTrue(Options.enforcePawnCollision(Color.RED, 18, testBoard));
        assertTrue(Options.enforcePawnCollision(Color.YELLOW, 18, testBoard));
        assertTrue(Options.enforcePawnCollision(Color.GREEN, 18, testBoard));
        assertTrue(Options.enforcePawnCollision(Color.BLUE, 18, testBoard));
    }

    @Test
    void testEnforcePawnCollisionFindsNoCollision() {
        Board testBoard = new Board();
        testBoard.get(Color.RED).movePawn(0, 3);
        testBoard.get(Color.YELLOW).movePawn(0, 3);
        testBoard.get(Color.GREEN).movePawn(0, 3);
        testBoard.get(Color.BLUE).movePawn(0, 3);

        assertFalse(Options.enforcePawnCollision(Color.RED, 3, testBoard));
        assertFalse(Options.enforcePawnCollision(Color.YELLOW, 3, testBoard));
        assertFalse(Options.enforcePawnCollision(Color.GREEN, 3, testBoard));
        assertFalse(Options.enforcePawnCollision(Color.BLUE, 3, testBoard));
    }

}