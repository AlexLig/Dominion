package dominion.cards.treasureCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public class Silver extends Card {
    public Silver(Game game) {
        super("Silver","",3,CardType.TREASURE, game);

    }

    @Override
    public void activate(){
        game.plusTreasure(2);

    }
}
