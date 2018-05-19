package dominion.cards.treasureCards;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public class Copper extends Card {


    public Copper(Game game) {
        super("Copper","",0,CardType.TREASURE, game);

    }

    @Override
    public void activate(){
        game.plusTreasure(1);

    }
}
