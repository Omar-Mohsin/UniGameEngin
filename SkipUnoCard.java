import ENUMS.Color;


public class SkipUnoCard extends ColoredUnoCard {
    public SkipUnoCard(String value, Color color) {
        super(value, color);
    }

    @Override
    boolean execute() {
       GameState  gameState=   GameState.getInstance();
        UnoPlayer nextPlayer = gameState.getNextPlayer();
        boolean isValidMove=isSameValue() || isSameColor();
        if(!isValidMove)return false;
        gameState.skipNextPlayer();
        System.out.println( gameState.getCurrentPlayer().playerName+ " skipped");


        return true;
    }
}
