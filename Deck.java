import ENUMS.Action;
import ENUMS.Color;
import ENUMS.Value;
import ENUMS.Wild;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {

    private UnoCardStrategy[] cards;
    private int cardsInDeck;

    public Deck() {
        cards = new UnoCardStrategy[108];
    }

    public void initializeDeck () {
        Color[] colors =  Color.values();
        cardsInDeck = 0;

        for (int i = 0; i < colors.length; i++) {
            Color color = Color.getColors(i);

            cards[cardsInDeck++] = new NumberedUnoCard(Value.zero.toString(), color);

            for (int j = 1; j < 10; j++) {
                cards[cardsInDeck++] = new NumberedUnoCard(Value.getValues(j).toString(),color);
                cards[cardsInDeck++] = new NumberedUnoCard(Value.getValues(j).toString(),color);
            }
            for (int j =0; j <3;j++){
                cards[cardsInDeck++] = getActionCard(Action.getActions(j),color);
                cards[cardsInDeck++] = getActionCard(Action.getActions(j),color);
            }
        }
            for (int i = 0; i < 4; i++) {
                cards[cardsInDeck++] = new WildUnoCard(Wild.wild.toString());
                cards[cardsInDeck++] = new WildDrawFourUnoCard(Wild.wild_draw_four.toString());
            }
    }
    public UnoCardStrategy getActionCard(Action action, Color color){
        if(action==Action.skip)return new SkipUnoCard(action.toString(),color);
        if(action==Action.reverse)return new ReverseUnoCard(action.toString(),color);
        if(action==Action.draw_two)return new DrawTwoUnoCard(action.toString(),color);
        return null;
    }
    public void shuffle() {

        Random rnd = ThreadLocalRandom.current();
        for (int i = cards.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            UnoCardStrategy a = cards[index];
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


    public UnoCardStrategy drawCard() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");// it will change later
        }
        return cards[--cardsInDeck];
    }
    public UnoCardStrategy[] drawCard(int n) {
        if (!isPositive(n)) {
            throw new IllegalArgumentException("Must draw positiive cards but tried to draw " + n + " cards.");
        }

        if (n > cardsInDeck) {
            throw new IllegalArgumentException("Cannot draw " + n + " cards since there are only " + cardsInDeck + " cards.");
        }

        UnoCardStrategy[] ret = new UnoCardStrategy[n];

        for (int i = 0; i < n; i++) {
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return cardsInDeck == deck.cardsInDeck && Arrays.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cardsInDeck);
        result = 31 * result + Arrays.hashCode(cards);
        return result;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                ", cardsInDeck=" + cardsInDeck +
                '}';
    }
}
