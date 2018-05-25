package dominion.cards.actionCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;
import dominion.game.TurnPhase;

public abstract class Action extends Card {

    public Action(String name, String description, int cost, CardType cardType) {
        super(name, description, cost, cardType);

    }
    protected final boolean canBePlayed(Game game) {
        if (game.getTurnPhase().equals(TurnPhase.ACTION)) {
            return true;
        } else return false;
    }
}
