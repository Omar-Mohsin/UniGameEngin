public interface Strategy {
    Card chooseCardToPlay(Player player , Card topCard);
    Card.Color ChooseColor(Player player);
}
