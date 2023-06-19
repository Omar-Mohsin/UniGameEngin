import java.util.ArrayList;

public class UnoPlayer extends Player{


    ArrayList<Card> hand;
    private int score;
    private ArrayList<ArrayList<UnoCard>> playerHand;
    public UnoPlayer(String playerName) {
        super();
        this.playerName= playerName;
    }

    @Override
    public void playCard() {

    }

    @Override
    public void drawCard() {

    }

    @Override
    public String getPlayersName() {

        return playerName;
    }

    @Override
    public boolean isWin(){
        return hand.size() ==0;
    }

}
