import java.util.Objects;

public class UnoCard {
        public UnoCard(Color color, Action action) {
            this.color =  color;
            this.action = action ;
        }
        public UnoCard(Wild wild){
            this.wild = wild;
        }
        protected Color color;
        protected Value value;
        protected Action action;
        protected Wild  wild;
        public UnoCard(Color color, Value value) {
            this.color = color;
            this.value = value;
        }
        public Color getColor(){
            return this.color;
        }


        public Value getValue(){
            return this.value;
        }
        public Wild getWild() {
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
        return color == unoCard.color && value == unoCard.value && action == unoCard.action && wild == unoCard.wild;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, value, action, wild);
    }
}


