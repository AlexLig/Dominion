package dominion.cards.treasureCards;

import dominion.cards.CardType;
import dominion.player.Player;

public class Silver extends Treasure {
    public Silver() {
        super("Silver", "", 3, CardType.TREASURE);

    }

    @Override
    public void activate(Player player) {
        cardEffects.plusTreasure(2, player);
    }
}
