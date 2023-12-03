package engine;

import java.util.Random;

public class Deck {
    private final Random random = new Random();
    private int currentCard = 0;
    public int getNextCard() {
        currentCard = random.nextInt(1,10);
        return currentCard;
    }

    int getCurrentCard() {
            return currentCard;
    }
}
