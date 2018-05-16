package dominion.cardEffects;

import dominion.game.PlayerState;

public class PlusCards implements CardEffect {
    private int cardsDrawn;

    public PlusCards(int cardsDrawn) {
        this.cardsDrawn = cardsDrawn;
    }


    public void activate(PlayerState playerState) {
        for (int i = 0; i < cardsDrawn; i++) {
            playerState.getHand().add(playerState.getDeck().pop());

        }

    }
}
