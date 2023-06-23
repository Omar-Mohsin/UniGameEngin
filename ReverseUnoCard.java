import ENUMS.Color;


public class ReverseUnoCard extends ColoredUnoCard {
    public ReverseUnoCard(String value, Color color) {
        super(value, color);
    }

    @Override
    boolean execute() {


        boolean isValidMove=isSameValue() || isSameColor();
        if(!isValidMove)return false;
       /* GameState.getInstance().getNextPlayer();*/
        return true;
    }


}
