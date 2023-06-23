public class NumberUnoCardStrategy implements UnoCardStrategy{
    @Override
    public boolean execute(GameState gameState, UnoCard unoCard) {
        return isValidMove(gameState,unoCard);
    }
    public boolean isValidMove(GameState gameState,UnoCard card) {
        UnoCard currentCard=gameState.getCurrentCard();
        Color color=gameState.getCurrentColor();
        if(currentCard==null)return true; // when it's the first card
        return card.getColor().equals(color) || card.getValue().equals(currentCard.getValue());
    }
}
