import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerFactory {
    static Scanner input = new Scanner(System.in);
     static List <UnoPlayer> players = new ArrayList<>();
     public static ArrayList<String> playersName = new ArrayList<>();
    public static List<UnoPlayer> createPlayer(int numOfPlayers) {

        if (isValid(numOfPlayers)) {
            for (int i = 0; i < numOfPlayers; i++) {
                System.out.print("Enter the name of player " + (i + 1) + ": ");
                String playerName = input.nextLine();
                players.add(new UnoPlayer(playerName));
                playersName.add(playerName);
            }
        }else {
            System.out.println("invalid number of players");
        }
        return players;
    }

    public static boolean isValid(int numberOfPlayers){
        if (numberOfPlayers >= 2 && numberOfPlayers <= 10){
            return true;
        } else {
            return false;
        }
    }
}
