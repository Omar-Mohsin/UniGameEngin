import java.util.Objects;

public class UnoCard {

        public UnoCard(Color color, Action action) {
            this.color =  color;
            this.action = action ;
        }
        public UnoCard(Wild wild){
            this.wild = wild;
        }

        enum Color {
            red, blue , green, yellow;

            private static Color[] colors = Color.values();

            public static Color getColors(int i) {
                return colors[i];
            }

        }
        enum Value {
            zero, one, two, three, four, five, six, seven, eight, nine;

            private static Value[] values = Value.values();

            public static Value getValues(int i) {
                return values[i];
            }
        }
        enum Wild{
            wild, wild_draw_four;
            private static Wild[] wilds = Wild.values();

            public static Wild getWild(int i) {
                return wilds[i];
            }
        }
        enum Action{
            skip , reverse , draw_two;
            private static Action[] actions = Action.values();

            public static Action getActions(int i) {
                return actions[i];
            }
        }

        protected   Color color;
        protected   Value value;
        protected Action action;
        protected Wild  wild;
        public UnoCard(Color color, Value value) {
            this.color = color;
            this.value = value;
        }
        public UnoCard(CardPlayStrategy playStrategy) {
            this.playStrategy = playStrategy;
        }
        public void play(UnoPlayer player) {
            playStrategy.playCard(player, this);
        }
        private CardPlayStrategy playStrategy;



        public UnoCard.Color getColor(){
            return this.color;
        }


        public UnoCard.Value getValue(){
            return this.value;
        }
        public UnoCard.Wild getWild() {
            return this.wild;
        }

        @Override
        public String toString() {

            String s="";
            if(color==Color.blue){

                s+=ConsoleColor.ANSI_BLUE;
            }
            if(color==Color.green){
                s+=ConsoleColor.ANSI_GREEN;
            }
            if(color==Color.yellow){
                s+=ConsoleColor.ANSI_YELLOW;

            }
            if(color==Color.red){
                s+= ConsoleColor.ANSI_RED;
            }
            if(value!=null)
            s+=value;
            if(action!=null) {
                s+=action;
            } if(wild !=  null){
                s+= wild;
            }
            s+= ConsoleColor.ANSI_RESET;
            return s;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnoCard unoCard = (UnoCard) o;
        return color == unoCard.color && value == unoCard.value && action == unoCard.action && wild == unoCard.wild && Objects.equals(playStrategy, unoCard.playStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, value, action, wild, playStrategy);
    }
}


