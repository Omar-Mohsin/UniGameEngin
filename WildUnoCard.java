

public class  WildUnoCard extends UnoCardStrategy {
    public WildUnoCard(String value) {
        super(value);
    }

    @Override
    boolean execute() {

        GameState gameState= GameState.getInstance();
        UnoPlayer nextPlayer= gameState.getNextPlayer();
        System.out.println(nextPlayer.playerName + "change the color to " + gameState.getCurrentColor());

        gameState.getCurrentPlayer().chooseColor();
        gameState.setCurrentCard(gameState.getCurrentPlayer().selectCardToPlay());
        return true;
    }
}
