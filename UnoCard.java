
    public class UnoCard extends Card{



        private final Card.Color color;
        private final Card.Value value;

        public UnoCard(Color color, Value value){
            this.color = color;
            this.value = value;
        }


        @Override
        public Card.Color getColor(){
            return this.color;
        }

        @Override
        public Card.Value getValue(){
            return this.value;
        }

}


