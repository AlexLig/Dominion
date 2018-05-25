package dominion.cards;

import dominion.player.Player;

public class CardEffects {

    //Card Effects
    public void plusTreasure(int numberOfTreasurePoints, Player player) {
        player.getTurn().addTreasurePoints(numberOfTreasurePoints);
    }

    public void plusCards(int numberOfCards, Player player) {
        for (int i = 0; i < numberOfCards; i++) {
            player.getHand().add(player.getDeck().pop());
        }
    }

}
