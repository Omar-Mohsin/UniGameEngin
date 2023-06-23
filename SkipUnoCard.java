import ENUMS.Color;


public class SkipUnoCard extends ColoredUnoCard {
    public SkipUnoCard(String value, Color color) {
        super(value, color);
    }

    @Override
    boolean execute() {
        return false;
    }
}
