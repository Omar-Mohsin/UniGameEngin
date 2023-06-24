import ENUMS.Color;


public class DrawTwoUnoCard extends ColoredUnoCard {
    Deck deck = Deck.getInstance();
    public DrawTwoUnoCard(String value, Color color) {
        super(value, color);
    }

    @Override
    boolean execute() {

        boolean isValidMove=isSameValue() || isSameColor();
        if(!isValidMove)return false;
        GameState.getInstance().drawCardsNextPlayer(2);
        return true;
    }
}
