package dominion.cards.victoryCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public class Estate extends Card {

    public Estate(Game game) {
        super("Estate","",5,CardType.VICTORY, game);

    }

    @Override
    public void activate() {
        game.addVictoryPointsToActivePlayer(1);

    }
}
