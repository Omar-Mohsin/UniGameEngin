
    public class UnoCard {

        public UnoCard(Color color, Value zero) {
        }

        enum Color {
            red, blue , green, yellow;
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
            }
            enum Action{
                skip , reverse , draw_two;
            }


        protected   Color color;
        protected   Value value;
        public UnoCard(CardPlayStrategy playStrategy) {
            this.playStrategy = playStrategy;
        }
        public void play(UnoPlayer player) {
            playStrategy.playCard(player, this);
        }
        private CardPlayStrategy playStrategy;

        public void setPlayStrategy(CardPlayStrategy playStrategy) {
            this.playStrategy = playStrategy;
        }


        public UnoCard.Color getColor(){
            return this.color;
        }


        public UnoCard.Value getValue(){
            return this.value;
        }

}


