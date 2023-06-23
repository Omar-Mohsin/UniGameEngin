public abstract class ActionUnoCardStrategy implements UnoCardStrategy {
    @Override
    public boolean execute(GameState gameState, UnoCard unoCard) {
        if(isValidMove(gameState,unoCard)){
            play();
            return true;
        }
        return false;
    }
    public boolean isValidMove(GameState gameState,UnoCard card) {
        Color color=gameState.getCurrentColor();
        if(color==null)return true; // when it's the first card
        return card.getColor().equals(color);
    }
    abstract boolean play();
}
