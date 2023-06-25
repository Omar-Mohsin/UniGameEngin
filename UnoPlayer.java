import ENUMS.Color;

import java.util.ArrayList;
import java.util.Scanner;

public class UnoPlayer{

    String playerName;
    ArrayList<UnoCardStrategy> playerHand;
    private int score;
    public UnoPlayer(String playerName) {
        score = 0;
        this.playerName= playerName;
        playerHand = new ArrayList<>();
    }

    public void sayUno(UnoPlayer player) {
        if (this.playerHand.size() == 1) {
            System.out.println( player.getPlayerName() + " : "+ "UNO");
        }

    }
    public void playCard(UnoCardStrategy card) {
        playerHand.remove(card);
    }

    public UnoCardStrategy selectCardToPlay() {
        boolean flag = true;
        while (flag) {
            System.out.println("Select a card to play (enter the index number):");
            for (int i = 0; i < playerHand.size(); i++) {
                System.out.println(i + ": " + playerHand.get(i));
            }
            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt();
            scanner.nextLine();

            if (inRange(index)) {
                flag = false;
                return playerHand.get(index);
            } else {
                System.out.println("Invalid card index. Try again.");

            }
        }
        return null;
    }
    public boolean inRange(int index){
        return index >= 0 && index < playerHand.size();
    }

    public void drawCard(UnoCardStrategy card) {
        playerHand.add(card);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score += score;
    }
    public ArrayList<UnoCardStrategy> getHand() {
        return playerHand;
    }

    public boolean isWon(){
        return playerHand.size() ==0;
    }

    public Color chooseColor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a color:");
        System.out.println("1. Red");
        System.out.println("2. Blue");
        System.out.println("3. Green");
        System.out.println("4. Yellow");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return Color.red;
            case 2:
                return Color.blue;
            case 3:
                return Color.green;
            case 4:
                return Color.yellow;
            default:
                System.out.println("Invalid choice. Defaulting to Red.");
                return Color.red;
        }
    }

}
