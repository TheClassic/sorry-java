package engine;

import java.util.Random;

public class Deck {
    private final Random random = new Random();
    private int currentCard = 0;

    static final int SORRY = 13;

    // 13 is sorry card
    // TODO there should be 5 one's and 4 of each other card (including Sorry)
    public int getNextCard() {
        currentCard = random.nextInt(1,14);
        if(currentCard==6||currentCard==9)
            return getNextCard();
        return currentCard;
    }

    int getCurrentCard() {
            return currentCard;
    }
}
