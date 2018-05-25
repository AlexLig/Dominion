package dominion.cards.treasureCards;

import dominion.cards.CardType;
import dominion.player.Player;

public class Copper extends Treasure {


    public Copper() {
        super("Copper", "", 0, CardType.TREASURE);

    }

    @Override
    public void activate(Player player) {
        cardEffects.plusTreasure(1, player);
    }
}
