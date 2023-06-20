public class WildCard extends UnoCard{
    public WildCard(Wild wild) {
        super(new WildCardPlayStrategy());
    }
}
