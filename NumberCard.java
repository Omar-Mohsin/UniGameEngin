public class NumberCard extends UnoCard {
    private Color color;
    private Number number;

    public NumberCard(Color color, Number number) {
        super(new NumberCardPlayStrategy());
        this.color = color;
        this.number = number;
    }
}
