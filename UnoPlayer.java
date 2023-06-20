import java.util.ArrayList;
import java.util.Scanner;

public class UnoPlayer{

    String playerName;
    ArrayList<UnoCard> playerHand;
    private int score;
    public UnoPlayer(String playerName) {
        score = 0;
        this.playerName= playerName;
    }

    public void sayUno() {
        if (this.playerHand.size() == 1) {
            System.out.println("Uno");
        }

    }
    public void playCard(UnoCard card) {
        playerHand.remove(card);
    }

    public UnoCard selectCardToPlay() {
        System.out.println("Select a card to play (enter the index number):");
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(i + ": " + playerHand.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.nextLine();

        if (inRange(index)) {
            return playerHand.get(index);
        } else {
            System.out.println("Invalid card index. Try again.");
            return null;
        }
    }
    public boolean inRange(int index){
        return index >= 0 && index < playerHand.size();
    }

    public void drawCard(UnoCard card) {
        playerHand.add(card);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore(){
        return score;
    }
    public ArrayList<UnoCard> getHand() {
        return playerHand;
    }

    public boolean isWon(){
        return playerHand.size() ==0;
    }

}
