import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class UnoGame extends Game{

    private UnoCard.Color validColor ;
    private UnoCard.Value validValue;

    private  int currentPlayer;
    private  Deck deck;
    private ArrayList<ArrayList<UnoCard>> playerHand;
    boolean gameDirection ;
    ArrayList<String> playersName= PlayerFactory.playersName;


    @Override
    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Player");
        int numberOfPlayer = input.nextInt();
        List<UnoPlayer>  players = PlayerFactory.createPlayer(numberOfPlayer);

        UnoCard card = deck.drawCard();
        validColor= card.getColor();
        validValue = card.getValue();

        if(card.getValue() == UnoCard.Value.wild){
            play();
        }
        if(card.getValue() == UnoCard.Value.skip){
            play();
        }
        if(card.getValue() == UnoCard.Value.skip){

        }

    }

    public UnoGame(){
        deck = new Deck();
        deck.shuffle();
        currentPlayer = 0 ;
        gameDirection = false;
        playerHand = new ArrayList<ArrayList<UnoCard>>();
        fillTheHand(playerHand);
    }

    @Override
    public String getPlayersName() {
        return playersName.toString();
    }

    private void fillTheHand(ArrayList<ArrayList<UnoCard>> playerHand){
        for(int i =0; i<playersName.size();i++){
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }
    }
}
