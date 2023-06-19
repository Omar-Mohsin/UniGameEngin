import java.util.Random;


public class Deck {

    private UnoCard[] cards;
    private int cardsInDeck;

    public Deck() {
        cards = new UnoCard[180];
    }

    public void rest () {
    UnoCard.Color[] colors =  UnoCard.Color.values();
        cardsInDeck = 0;

        for (int i = 0; i < colors.length; i++) {
            UnoCard. Color color = colors[i];

            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValues(0));

            for (int j = i; j < 10; j++) {
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValues(j));
            }
        }

        UnoCard.Value[] values = {UnoCard.Value.wild, UnoCard.Value.wild_draw_four};
        for (UnoCard.Value value : values) {
            for (int i = 0; i < 4; i++) {
                cards[cardsInDeck++] = new UnoCard(UnoCard.Color.wild, value);
            }

        }
    }

    public void shuffle() {
        int cardLength = cards.length;
        Random random = new Random();

        for (int i = 0; i < cardLength; i++) {

            int randomValue = i + random.nextInt(cardLength - i);
            UnoCard randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
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
    } // it will change later


}
