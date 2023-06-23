public abstract class UnoCardStrategy {
    protected String value;
    UnoCardStrategy(String value){
        this.value=value;
    }
    abstract boolean execute();
    public boolean isSameValue() {
        UnoCardStrategy currentCard= GameState.getInstance().getCurrentCard1();
        if(currentCard==null)return true; // when it's the first card
        return currentCard.getValue().equals(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString() {

        String s="";
        s+= ConsoleColor.ANSI_BLACK;
        if(value!=null)
            s+=value;
        s+= ConsoleColor.ANSI_RESET;
        return s;
    }
}
