import ENUMS.Color;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private UnoCardStrategy currentCard;
    private List<UnoPlayer> players;
    private UnoPlayer currentPlayer;
    private int currentPlayerIndex;
    private Color currentColor;
    private final Deck deck;


    private List<UnoCardStrategy> discardedCards;
    private static volatile GameState instance;

    private GameState() {
        discardedCards = new ArrayList<>();
        deck = Deck.getInstance();

    }


    public void discardCard(UnoCardStrategy card) {
        discardedCards.add(card);
    }


    public UnoCardStrategy getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(UnoCardStrategy card) {
        currentCard = card;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public static GameState getInstance() {
        GameState result = instance;
        if (result != null) {
            return result;
        }
        synchronized (GameState.class) {
            if (instance == null) {
                instance = new GameState();
            }
            return instance;
        }
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex){
        this.currentPlayerIndex = currentPlayerIndex;
    }
    public int getCurrentPlayerIndex(){
     return currentPlayerIndex;
    }
    public void getPlayers(List<UnoPlayer> players) {

        this.players = players;
    }

    public UnoPlayer getNextPlayer() {
        int currentPlayerIndex = players.indexOf(getCurrentPlayer());
        int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
     currentPlayer = players.get(nextPlayerIndex);
        return currentPlayer;
    }

    public void setCurrentPlayer(UnoPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public UnoPlayer getCurrentPlayer() {
        return currentPlayer;

    }

    public void drawCardsNextPlayer(int numCards) {
        for (int i = 0; i < numCards; i++) {
            UnoCardStrategy drawnCard = deck.drawCard();
            if (drawnCard != null) {
                getNextPlayer().drawCard(drawnCard);
            } else {
                System.out.println("No more cards in the deck!");
                break;
            }
        }
    }
    public void skipNextPlayer() {

     currentPlayer = getNextPlayer();
    }

}





