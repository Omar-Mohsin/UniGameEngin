import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {

    private UnoCard[] cards;
    private int cardsInDeck;

    public Deck() {
        cards = new UnoCard[108];
    }

    public void initializeDeck () {
        UnoCard.Color[] colors =  UnoCard.Color.values();
        cardsInDeck = 0;

        for (int i = 0; i < colors.length; i++) {
            UnoCard.Color color = UnoCard.Color.getColors(i);

            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.zero);

            for (int j = 1; j < 10; j++) {
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValues(j));
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValues(j));
            }
            for (int j =0; j <3;j++){
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Action.getActions(j));

                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Action.getActions(j));

            }
        }
            for (int i = 0; i < 4; i++) {
                cards[cardsInDeck++] = new UnoCard(UnoCard.Wild.wild);
                cards[cardsInDeck++] = new UnoCard(UnoCard.Wild.wild_draw_four);

            }


    }

    public void shuffle() {

        Random rnd = ThreadLocalRandom.current();
        for (int i = cards.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            UnoCard a = cards[index];
            cards[index] = cards[i];
            cards[i] = a;
        }
    }
    public boolean isEmpty () {
        return cardsInDeck == 0;
    }
    public boolean isPositive(int n){
        return n >=0;
    }


    public UnoCard drawCard() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");// it will change later
        }
        return cards[--cardsInDeck];
    }
    public UnoCard[] drawCard(int n) {
        if (!isPositive(n)) {
            throw new IllegalArgumentException("Must draw positiive cards but tried to draw " + n + " cards.");
        }

        if (n > cardsInDeck) {
            throw new IllegalArgumentException("Cannot draw " + n + " cards since there are only " + cardsInDeck + " cards.");
        }

        UnoCard[] ret = new UnoCard[n];

        for (int i = 0; i < n; i++) {
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                ", cardsInDeck=" + cardsInDeck +
                '}';
    }
}
