package dominion.cards.treasureCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public class Gold extends Card {
    public Gold(Game game) {
        super("Gold","",6,CardType.TREASURE, game);

    }

    @Override
    public void activate(){
        game.plusTreasure(3);

    }
}
