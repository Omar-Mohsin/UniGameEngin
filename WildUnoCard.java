

public class WildUnoCard extends UnoCardStrategy {
    public WildUnoCard(String value) {
        super(value);
    }

    @Override
    boolean execute() {
        return false;
    }
}
