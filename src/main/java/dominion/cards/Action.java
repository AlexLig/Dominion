package dominion.cards;

import dominion.cardEffects.CardEffect;
import dominion.cardEffects.PlusCards;
import dominion.game.PlayerState;

import java.util.ArrayList;

public class Action extends Card {
    private ArrayList<CardEffect> cardEffects;

    public Action(String name, String description, int cost, ArrayList<CardEffect> cardEffects, CardType cardType) {
        super(name, description, cost, cardType);
        this.cardEffects = cardEffects;
    }



    @Override
    public void activate(PlayerState playerState) {
        for (CardEffect effect : cardEffects) {
            effect.activate();
        }
    }
}
