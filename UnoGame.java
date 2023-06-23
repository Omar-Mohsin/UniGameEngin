/*
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class UnoGame extends Game{
    private GameEngine gameEngine;
    // Other necessary properties

    public void play() {
        // Instantiate necessary objects
        Deck deck = new Deck();
        List<UnoPlayer> players = PlayerFactory.createPlayer();
        gameEngine = new GameEngine(players);

        // Set up initial game state
        deck.shuffle();
        dealCards(deck, players);
        int startingPlayerIndex = selectStartingPlayer(players);
        gameEngine.setCurrentPlayerIndex(startingPlayerIndex);

        // Enter game loop
        boolean gameEnd = false;
        while (!gameEnd) {
            UnoPlayer currentPlayer = gameEngine.getCurrentPlayer();

            // Prompt current player for their action
            // Handle player input accordingly
            // ...

            // Check for winning condition
            if (currentPlayer()) {
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnd = true;
            }

            // Update the game state
            gameEngine.moveToNextPlayer();
        }

        // Game ends, perform necessary cleanup or final actions
        // ...
    }
    @Override
    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Player");
        int numberOfPlayer = input.nextInt();
          players = PlayerFactory.createPlayer(numberOfPlayer);

        UnoCard card = deck.drawCard();
        validColor= card.getColor();
        validValue = card.getValue();

         gameRules  = new UnoGameRules(card  , currentPlayer, players , gameDirection, playersName);


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

  */
/*  public ArrayList<UnoCard> getPlayerHand(String player){

        int index = Arrays.asList(this.players).indexOf(player);
        return playerHand.get(index);
    }*//*


    */
/*public UnoCard getPlayerCard(String player, int choice){

        ArrayList<UnoCard> hand  = getPlayerHand(player);
        return hand.get(choice);

    }*//*


   */
/* public boolean hasEmptyHand(String player){
        return getPlayerHand(player).isEmpty();
    }*//*


  */
/*  public void checkPlayerTurn(String player) throws Exception {
        if(this.players.get(this.currentPlayer).equals(player)){
            throw new Exception("its not your turn" + player);
        }
    }*//*


   */
/* public void submitDraw (String player) throws Exception {
        checkPlayerTurn(player);
        if(deck.isEmpty()){
            deck.shuffle();
        }
        getPlayerHand(player).add(deck.drawCard());
        if(gameDirection == false){
            currentPlayer = (currentPlayer+1)% players.size();

        } else {
            currentPlayer = (currentPlayer-1)% players.size();
            if(currentPlayer == -1){
                currentPlayer = players.size()-1;
            }
        }
    }
    public void setCardColor(UnoCard.ENUMS.Color color){
        validColor = color;
    }*//*

}
*/
