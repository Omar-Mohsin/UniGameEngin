public abstract class Player {

    int score ;
    String playerName;


    protected Player(){
        score = 0 ;
    }
    public abstract void playCard();
    public abstract void drawCard();
    public abstract String getPlayersName();
    public abstract boolean isWin();
}
