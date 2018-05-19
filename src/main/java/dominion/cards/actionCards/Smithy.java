package dominion.cards.actionCards;


import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public class Smithy extends Card {

    public Smithy(Game game) {
        super("Smithy","Draw 3 cards.", 4, CardType.ACTION, game);

    }



    @Override
    public void activate() {
        game.plusCards(3);
    }
}
