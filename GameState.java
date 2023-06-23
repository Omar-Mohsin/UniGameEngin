import ENUMS.Color;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private UnoCardStrategy currentCard1;
    private UnoCardStrategy currentCard;
    private List<UnoPlayer> players;
    private UnoPlayer currentPlayer;
    private  int currentPlayerIndex;
    private Color currentColor;


    private List<UnoCardStrategy> discardedCards;
    private static volatile GameState instance;

    private GameState() {
        discardedCards = new ArrayList<>();

    }


    public void discardCard(UnoCardStrategy card) {
        discardedCards.add(card);
    }

    public UnoCardStrategy getCurrentCard1() {
        return currentCard1;
    }

    public void setCurrentCard1(UnoCardStrategy currentCard1) {
        this.currentCard1 = currentCard1;
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
    public void getInt(List<UnoPlayer> players  ){

        this.players = players;
    }
    public UnoPlayer getNextPlayer(UnoPlayer currentPlayer) {
        int currentPlayerIndex = players.indexOf(currentPlayer);
        int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return players.get(nextPlayerIndex);
    }
    public void setCurrentPlayer(UnoPlayer currentPlayer){
        this.currentPlayer = currentPlayer;
    }
    public UnoPlayer getCurrentPlayer(){
      return currentPlayer;

    }


}



