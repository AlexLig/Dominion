package dominion.cards.victoryCards;


import dominion.cards.Card;
import dominion.cards.CardType;

import dominion.player.Player;

public class Province extends Victory {
    private int victoryPoints;

    public Province() {
        super("Province", "", 8, CardType.VICTORY);
        this.victoryPoints = 6;
    }

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void activate(Player player){}

}
