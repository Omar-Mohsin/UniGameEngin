/*
import java.util.ArrayList;
import java.util.List;

public class UnoGameRules {


    int currentPlayer;

    boolean gameDirection;
    Deck deck;
    UnoCard card = deck.drawCard();
    List<UnoPlayer> players;
    ArrayList<String> playersName;


    public UnoGameRules(UnoCard card, int currentPlayer, List<UnoPlayer> players, boolean gameDirection, ArrayList<String> playersName) {

        this.currentPlayer = currentPlayer;
        this.gameDirection = gameDirection;
        this.card = card;
        this.players = players;
        this.playersName = playersName;
    }


    public void movement() {
        if (card.getValue() == UnoCard.ENUMS.Value.wild) {

        }
        if (card.getValue() == UnoCard.ENUMS.Value.wild_draw_four || card.getValue() == UnoCard.ENUMS.Value.draw_two) {

        }
        if (card.getValue() == UnoCard.ENUMS.Value.skip) {
            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % players.size();
            } else {
                currentPlayer = (currentPlayer - 1) % players.size();
                if (currentPlayer == -1) {
                    currentPlayer = players.size() - 1;
                }
            }
        }

        if (card.getValue() == UnoCard.ENUMS.Value.reverse) {
            System.out.println(playersName.get(currentPlayer) + "the game direction changed");
            gameDirection ^= true; //  doing a xor
            currentPlayer = players.size() - 1;

        }
    }

    public void WhoIsWin() {
        boolean flag = false;
        for (UnoPlayer player : players) {
            if (player.getScore() == 500) {
                System.out.println(player.getPlayerName() + "is win");
                flag = true;
            }
        }
        if (flag) {

        } else {
            System.out.println("No One Won yet");

        }
    }
}
*/
