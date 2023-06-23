import ENUMS.Color;

public abstract class ColoredUnoCard extends UnoCardStrategy {
    protected Color color;
    ColoredUnoCard(String value,Color color){
        super(value);
        this.color=color;
    }
    public boolean isSameColor() {
        Color currentColor= GameState.getInstance().getCurrentColor();
        if(currentColor==null)return true; // when it's the first card
        return color.equals(currentColor);
    }
    @Override
    public String toString() {

        String s="";
        if(color==Color.blue){

            s+= ConsoleColor.ANSI_BLUE;
        }
        if(color==Color.green){
            s+= ConsoleColor.ANSI_GREEN;
        }
        if(color==Color.yellow){
            s+= ConsoleColor.ANSI_YELLOW;

        }
        if(color==Color.red){
            s+= ConsoleColor.ANSI_RED;
        }
        if(value!=null)
            s+=value;
        s+= ConsoleColor.ANSI_RESET;
        return s;
    }
}
