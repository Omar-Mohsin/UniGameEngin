import java.util.ArrayList;

public class UnoPlayer extends Player{

    private String playerName;
    private int score;
    private ArrayList<ArrayList<UnoCard>> playerHand;
    public UnoPlayer(String playerName) {
        this.playerName = playerName;
        score = 0 ;
    }
    public UnoPlayer(){

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
}
