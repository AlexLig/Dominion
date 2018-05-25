package dominion.cards.actionCards;


import dominion.cards.CardType;
import dominion.player.Player;

public class Smithy extends Action {

    public Smithy() {
        super("Smithy", "Draw 3 cards.", 4, CardType.ACTION);

    }


    @Override
    public void activate(Player player) {
        cardEffects.plusCards(3, player);
    }
}
