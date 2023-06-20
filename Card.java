
public abstract class Card {

    enum Color {
        red, blue , green, yellow, wild;
        private    Color[] colors = Color.values();

        public  Color getColors(int i) {
            return colors[i];
        }
    }
    enum Value {
        zero, one , two , three, four , five , six , seven , eight , nine , skip , reverse , draw_two, wild, wild_draw_four;

        private static Value[] values = Value.values();

        public static Value getValues(int i) {
            return values[i];
        }
    }

    public abstract Card.Color getColor();
    public abstract Card.Value getValue();





}
