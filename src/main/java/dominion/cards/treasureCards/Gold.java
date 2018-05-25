package dominion.cards.treasureCards;

import dominion.cards.CardType;
import dominion.player.Player;

public class Gold extends Treasure {
    public Gold() {
        super("Gold", "", 6, CardType.TREASURE);

    }

    @Override
    public void activate(Player player) {
        cardEffects.plusTreasure(3, player);
    }
}
