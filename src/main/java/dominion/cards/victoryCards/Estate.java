package dominion.cards.victoryCards;

import dominion.cards.Card;
import dominion.cards.CardType;

import dominion.player.Player;

public class Estate extends Victory {
    private int victoryPoints;
    public Estate() {
        super("Estate","",5,CardType.VICTORY);
        this.victoryPoints = 1;
    }

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void activate(Player player) {}
}
