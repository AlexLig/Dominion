package dominion.cards.actionCards;

import dominion.cardEffects.CardEffect;
import dominion.cardEffects.PlusCards;
import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.PlayerState;

public class Smithy extends Card {

    private PlusCards plusCards;


    public Smithy(String name, String description, int cost, CardType cardType) {
        super(name, description, cost, cardType);
        this.plusCards = new PlusCards(3);

    }

    public static Smithy smithy(){
        return new Smithy("Smithy","Draw 3 cards.",4,CardType.ACTION);
    }

    @Override
    public void activate(PlayerState playerState) {
        plusCards.activate(playerState);
    }
}
