public class ActionCard extends UnoCard{
    private  Action action;

    public ActionCard(UnoCard.Color color, UnoCard.Action action) {
        super(new ActionCardPlayStrategy());
        this.color = color;
        this.action = action;
    }
}
