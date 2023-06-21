import java.util.ArrayList;
import java.util.List;

public class GameState {
    private UnoCard currentCard;
    private UnoCard.Color currentColor;
    private List<UnoCard> discardedCards;


    public GameState(UnoCard card) {
        discardedCards = new ArrayList<>();
        currentCard = card;
    }


    public void discardCard(UnoCard card) {
        discardedCards.add(card);
    }

    public UnoCard getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(UnoCard card) {
        currentCard = card;
    }

    public UnoCard.Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(UnoCard.Color color) {
        currentColor = color;
    }

    public boolean isCardValid(UnoCard card) {
        return card.getColor().equals(currentColor) || card.getValue().equals(currentCard.getValue());
    }

}

