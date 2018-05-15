package dominion.cards;

import dominion.cardEffects.CardEffect;
import dominion.game.Player;

import java.util.ArrayList;

public class Action extends Card {
    private ArrayList<CardEffect> cardEffects;

    public Action(String name, String description, int cost) {
        super(name, description, cost);
    }

    @Override
    public void activate(Player player) {
        for (CardEffect effect : cardEffects) {
            effect.activate();
        }
    }
}
