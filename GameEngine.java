import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private List<UnoPlayer> players;
    private int currentPlayerIndex;
    private Deck deck;
    private GameState gameState;
    public GameEngine() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
       deck = Deck.getInstance();

    }
    public void play() {
        initialize();
        boolean gameEnd = false;
        Scanner scanner = new Scanner(System.in);
         GameState gameState = GameState.getInstance();
        while (!gameEnd) {
            render();
            UnoPlayer currentPlayer = players.get(gameState.getCurrentPlayerIndex());
            System.out.println("Enter your command: "  + "Enter \"play\" to play one of your cards OR \"draw\"  to draw a card");
            String input = scanner.nextLine();
            processInput(currentPlayer, input);
            for (UnoPlayer player : players){
               player.sayUno(player);
            }

            if (currentPlayer.isWon()) {
                System.out.println("Player " + currentPlayer.getPlayerName() + " wins!");
                gameEnd = true;
                for (UnoPlayer player : players){
                    calculateScore(player);
                }
            } else if (deck.isEmpty() && currentPlayer.playerHand.isEmpty()) {
                System.out.println("Game over. It's a draw!");
                gameEnd = true;
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            gameState.setCurrentPlayerIndex(currentPlayerIndex);
        }
        endGame();
    }

    void initialize() {
        System.out.println("Welcome to the Uno game!");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Player");
        int numberOfPlayer = input.nextInt();
        players = PlayerFactory.createPlayer(numberOfPlayer);

        deck.initializeDeck();
        System.out.println(deck);
        deck.shuffle();
        dealCards();
        gameState=GameState.getInstance();//initalize game state
        gameState.getPlayers(players);
    }
    private void dealCards() {
        for (UnoPlayer player : players) {
            for (int i = 0; i < 7; i++) {
                UnoCardStrategy card = deck.drawCard();
                player.drawCard(card);
            }
        }
    }

    private void render() {
        GameState gameState = GameState.getInstance();
        System.out.println("--------------------------------------------------");
        UnoPlayer currentPlayer=players.get(gameState.getCurrentPlayerIndex());
        String currentPlayerName=currentPlayer.getPlayerName();
            System.out.println(currentPlayerName+"'s Turn");
            System.out.println(currentPlayerName+ "'s Hand: " + currentPlayer.playerHand);
        System.out.println("Current Card :  " +(gameState.getCurrentCard()==null?"none":gameState.getCurrentCard()));
    }

    private void processInput(UnoPlayer currentPlayer, String input) {
        if (input.equalsIgnoreCase("play")) {
            playCard(currentPlayer);
        } else if (input.equalsIgnoreCase("draw")) {
            drawCard(currentPlayer);
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }

    private void playCard(UnoPlayer currentPlayer) {

        boolean flag = true;
        while(flag) {
            UnoCardStrategy cardToPlay = currentPlayer.selectCardToPlay();  // flag while loop
            boolean isValidMove=cardToPlay.execute();
            if (isValidMove) {
                currentPlayer.playCard(cardToPlay);
                gameState.setCurrentCard(cardToPlay);

                System.out.println("Player " + currentPlayer.getPlayerName() + " throw a card: " + cardToPlay);
                flag=false;
            } else {
                System.out.println("Invalid card. Try again.");
            }
        }
    }

    private void drawCard(UnoPlayer currentPlayer) {
        UnoCardStrategy drawnCard = deck.drawCard();
        currentPlayer.drawCard(drawnCard);
        System.out.println("Player " + currentPlayer.getPlayerName() + " drew a card: " + drawnCard);
    }

    private void endGame() {
        // final scores
        System.out.println("Final scores:");
        for (UnoPlayer player : players) {
            System.out.println(player.getPlayerName() + ": " + player.getScore());
        }

        // Determine the winner
        UnoPlayer winner = players.get(0) ;
        int minScore = players.get(0).getScore();
        for (UnoPlayer player : players) {
            if (player.getScore() < minScore) {
                minScore = player.getScore();
                winner = player;
            }
        }

        // The winner
        System.out.println("The winner is: " + winner.getPlayerName());

    }
    private int calculateScore(UnoPlayer player) {
        int score = 0;
        for (UnoCardStrategy card : player.getHand()) {
            player.setScore(getCardValue(card));
        }
        return score;
    }
    private int getCardValue(UnoCardStrategy card) {
     return 10;
    }





}

