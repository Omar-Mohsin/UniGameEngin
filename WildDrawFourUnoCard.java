

public class WildDrawFourUnoCard extends UnoCardStrategy {
    public WildDrawFourUnoCard(String value) {
        super(value);
    }

    @Override
    boolean execute() {
        Deck deck =  Deck.getInstance();

        GameState gameState= GameState.getInstance();
        UnoPlayer nextPlayer= gameState.getNextPlayer();
        System.out.println(nextPlayer.playerName + "draw four");
        nextPlayer.drawCard(deck.drawCard());
        nextPlayer.drawCard(deck.drawCard());
        nextPlayer.drawCard(deck.drawCard());
        nextPlayer.drawCard(deck.drawCard());
        gameState.getCurrentPlayer().chooseColor();
        gameState.setCurrentCard(gameState.getCurrentPlayer().selectCardToPlay());
        return true;
    }

    /*UnoCard.Color newColor = currentPlayer.chooseColor();
        gameState.setCurrentColor(newColor);

        Player nextPlayer = gameState.getNextPlayer(currentPlayer);
        nextPlayer.drawCardsFromDeck(4);*/
}
