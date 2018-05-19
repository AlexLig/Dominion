package dominion.cards.victoryCards;


import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;

public class Province extends Card {
    private int victoryPoints;

    public Province(Game game) {
        super("Province", "", 8, CardType.VICTORY, game);
        this.victoryPoints = 6;
    }

    @Override
    public void activate() {
        game.addVictoryPointsToActivePlayer(6);
    }
}
