import javax.lang.model.type.UnionType;

public abstract class WildUnoCardStrategy implements UnoCardStrategy {
    @Override
    public boolean execute(GameState gameState, UnoCard unoCard) {
        play();
        return true;
    }
    abstract void play();
}
