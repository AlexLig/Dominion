package dominion.cards.victoryCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public class Duchy extends Card {

    public Duchy(Game game) {
        super("Duchy","",2,CardType.VICTORY, game);

    }

    @Override
    public void activate() {
        game.addVictoryPointsToActivePlayer(3);
    }
}
