package dominion.cards.victoryCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public abstract class Victory extends Card {
    public Victory(String name, String description, int cost, CardType cardType) {
        super(name, description, cost, cardType);
    }

    protected final boolean canBePlayed(Game game) {
        return false;
    }
}
