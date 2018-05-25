package dominion.cards.treasureCards;

import dominion.cards.Card;
import dominion.cards.CardType;

import dominion.game.Game;
import dominion.game.TurnPhase;

public abstract class Treasure extends Card {


    public Treasure(String name, String description, int cost, CardType cardType) {
        super(name, description, cost, cardType);

    }

    protected final boolean canBePlayed(Game game) {
        if (game.getTurnPhase().equals(TurnPhase.BUY)) {
            return true;
        } else return false;
    }
}
