package dominion.cardEffects;

import dominion.game.Game;
import dominion.game.Player;
import dominion.game.PlayerState;

public class PlusTreasure implements CardEffect {
    private int numberOfTreasury;

    public PlusTreasure(int numberOfTreasury) {
        this.numberOfTreasury = numberOfTreasury;
    }

    public void activate(PlayerState playerState){
        playerState.getTurn().addTreasurePoints(numberOfTreasury);

    }
}
