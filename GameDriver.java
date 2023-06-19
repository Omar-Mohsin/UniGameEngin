import java.util.List;
import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {

        Game game  = new UnoGame();
        game.play();
        System.out.println(game.getPlayersName());


    }

}