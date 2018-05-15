package dominion.cards;

import dominion.cardEffects.CardEffect;

import java.util.ArrayList;

public class Action extends Card {
    private ArrayList<CardEffect> cardEffects;

    public Action(String name, String description, int cost) {
        super(name, description, cost);
    }
}
