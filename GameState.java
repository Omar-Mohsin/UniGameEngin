import java.util.ArrayList;
import java.util.List;

public class GameState {
    private UnoCard currentCard;
    private Color currentColor;
    private List<UnoCard> discardedCards;


    public GameState() {
        discardedCards = new ArrayList<>();
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

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }
    public boolean isCardValid(UnoCard card) {
        if(currentCard==null)return true; // when it's the first card
        return card.getColor().equals(currentColor) || card.getValue().equals(currentCard.getValue());
    }
}



