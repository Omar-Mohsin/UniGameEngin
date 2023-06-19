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
    List<UnoPlayer>  players;

    @Override
    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Player");
        int numberOfPlayer = input.nextInt();
          players = PlayerFactory.createPlayer(numberOfPlayer);

        UnoCard card = deck.drawCard();
        validColor= card.getColor();
        validValue = card.getValue();

        if(card.getValue() == UnoCard.Value.wild){
            play();
        }
        if(card.getValue() == UnoCard.Value.wild_draw_four || card.getValue() == Card.Value.draw_two){
            play();
        }
        if(card.getValue() == UnoCard.Value.skip){
             if(gameDirection ==  false) {
                 currentPlayer = (currentPlayer + 1) % players.size();
             } else {
                 currentPlayer = (currentPlayer-1) % players.size();
                 if(currentPlayer ==-1){
                     currentPlayer = players.size()-1;
                 }
             }
        }

        if(card.getValue() == Card.Value.reverse){
            System.out.println(playersName.get(currentPlayer) + "the game direction changed");
            gameDirection ^= true; //  doing a xor
            currentPlayer = players.size() -1 ;

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

    public UnoPlayer getPreviousPlayer(int i){
        int index = this.currentPlayer -i ;
        if(index == -1){
            index = players.size()-1;

        }
        return this.players.get(index);
    }

    public ArrayList<UnoCard> getPlayerHand(String player){

        int index = Arrays.asList(this.players).indexOf(player);
        return playerHand.get(index);
    }
}
