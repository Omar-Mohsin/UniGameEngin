import ENUMS.Color;


public class ReverseUnoCard extends ColoredUnoCard {
    public ReverseUnoCard(String value, Color color) {
        super(value, color);
    }

    @Override
    boolean execute() {

        GameState  gameState=   GameState.getInstance();
        UnoPlayer nextPlayer = gameState.getNextPlayer();
        boolean isValidMove=isSameValue() || isSameColor();
        if(!isValidMove)return false;
        System.out.println( " the game direction is changed ");


        return true;


    }


}
