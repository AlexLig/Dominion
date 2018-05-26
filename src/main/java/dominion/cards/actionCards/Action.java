package dominion.cards.actionCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;
import dominion.game.TurnPhase;
import dominion.player.Player;

public abstract class Action extends Card {

    public Action(String name, String description, int cost, CardType cardType) {
        super(name, description, cost, cardType);

    }
    protected final boolean canBePlayed(Player player) {
        if (player.getGame().getTurnPhase().equals(TurnPhase.ACTION) && player.getTurn().getActionPoints() > 0) {
            return true;
        } else return false;
    }
}
