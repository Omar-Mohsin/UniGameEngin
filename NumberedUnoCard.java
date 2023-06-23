import ENUMS.Color;


public class NumberedUnoCard extends ColoredUnoCard {
    NumberedUnoCard(String value, Color color) {
        super(value, color);
    }
    @Override
    boolean execute() {
        boolean isValidMove=isSameValue() || isSameColor();
        if(!isValidMove)return false;
        GameState.getInstance().setCurrentColor(color);
        return true;
    }


}
