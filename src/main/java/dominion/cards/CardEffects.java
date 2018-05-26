package dominion.cards;

import dominion.player.Player;

import java.util.Stack;

public class CardEffects {

    //Card Effects
    public void plusTreasure(int numberOfTreasurePoints, Player player) {
        player.getTurn().addTreasurePoints(numberOfTreasurePoints);
    }

    public void plusCards(int numberOfCards, Player player) {
        Stack<String> deck = player.getDeck();

        for (int i = 0; i < numberOfCards && !deck.isEmpty(); i++) {
            player.getHand().add(deck.pop());
        }
    }

}
