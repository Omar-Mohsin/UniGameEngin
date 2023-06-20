import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private List<UnoPlayer> players;
    ArrayList<ArrayList<UnoCard>> playerHand;
    private int currentPlayerIndex;
    private Deck deck;
    private GameState gameState;

    public GameEngine() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
       deck = new Deck();
        gameState = new GameState();
    }
    public void run() {
        initialize();
        boolean gameEnd = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameEnd) {
            render();
            UnoPlayer currentPlayer = players.get(currentPlayerIndex);

            System.out.println("Player " + currentPlayer.playerName + "'s turn");
            System.out.println("Enter your command: ");
            String input = scanner.nextLine();

            processInput(currentPlayer, input);



            if (currentPlayer.isWon()) {
                System.out.println("Player " + currentPlayer.getPlayerName() + " wins!");
                gameEnd = true;
            } else if (deck.isEmpty() && currentPlayer.playerHand.isEmpty()) {
                System.out.println("Game over. It's a draw!");
                gameEnd = true;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    void initialize() {
        System.out.println("Welcome to the Uno game!");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Player");
        int numberOfPlayer = input.nextInt();
        players = PlayerFactory.createPlayer(numberOfPlayer);

        deck.initializeDeck();
        deck.shuffle();
        dealCards();
    }
    private void dealCards() {
        for (UnoPlayer player : players) {
            for (int i = 0; i < 7; i++) {
                UnoCard card = deck.drawCard();
                player.drawCard(card);
            }
        }
    }

    private void render() {
        System.out.println("--------------------------------------------------");
        for (UnoPlayer player : players) {
            System.out.println("Player: " + player.getPlayerName());
            System.out.println("Hand: " + player.getPlayerName());
            System.out.println();
        }
        System.out.println("Deck: " + deck);
        System.out.println("--------------------------------------------------");
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
            UnoCard cardToPlay =  currentPlayer.selectCardToPlay();
        if (cardToPlay != null) {
            if (gameState.isCardValid(cardToPlay)) {
                currentPlayer.playCard(cardToPlay);
                gameState.setCurrentCard(cardToPlay);
                gameState.setCurrentColor(cardToPlay.getColor());
            } else {
                System.out.println("Invalid card. Try again.");
            }
        } else {
            System.out.println("No valid cards in hand. Draw a card or pass.");
        }
    }

    private void drawCard(UnoPlayer currentPlayer) {
        UnoCard drawnCard = deck.drawCard();
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
        UnoPlayer winner = null;
        int maxScore = 0;
        for (UnoPlayer player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                winner = player;
            }
        }

        // The winner
        System.out.println("The winner is: " + winner.getPlayerName());

    }
    private int calculateScore(UnoPlayer player) {
        int score = 0;
        for (UnoCard card : player.getHand()) {
            score += getCardValue(card);
        }
        return score;
    }
    private int getCardValue(UnoCard card) {
     return 10;
    }



}

