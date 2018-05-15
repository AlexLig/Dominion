package dominion.cardEffects;

import dominion.game.Game;
import dominion.game.Player;

public class PlusTreasure implements CardEffect {
    private int numberOfTreasury;

    public PlusTreasure(int numberOfTreasury) {
        this.numberOfTreasury = numberOfTreasury;
    }

    public void activate(Player player){
        player.getTurn().addTreasurePoints(numberOfTreasury);

    }
}
