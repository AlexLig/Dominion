package dominion.game;

import dominion.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Player {

    public Stack<Card> deck;
    public Stack<Card> discardDeck;
    public ArrayList<Card> handDeck;

    private int remainingActions;
    private int remainingTreasure;
    private int remainingBuys;
    private int score = 0;
    private int strategyId;


    public Player() {
        this.deck = new Stack<>();
        this.handDeck = new ArrayList<>();
        this.discardDeck = new Stack<>();
        this.remainingActions = 1;
        this.remainingBuys = 1;
        this.remainingTreasure = 0;

    }


    private void discardToDeckShuffle() {
        deck.addAll(discardDeck);
        discardDeck.clear();
        Collections.shuffle(deck);
    }

    private void drawCards(int numberOfCards) {
        if (deck.size() < numberOfCards) {
            int tempDeckSize = deck.size();
            //draw as many cards there are left in deck
            for (int i = 0; i < deck.size(); i++) {
                handDeck.add(deck.pop());
            }
            discardToDeckShuffle();
            //draw the rest
            for (int i = 0; i < (numberOfCards - tempDeckSize); i++) {
                handDeck.add(deck.pop());
            }
        } else {
            for (int i = 0; i < (numberOfCards); i++) {
                handDeck.add(deck.pop());
            }
        }
    }

    public void endOfTurn() {
        discardDeck.addAll(handDeck);
        handDeck.clear();
        drawCards(5);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStrategyId() {
        return strategyId;
    }

    public int getRemainingActions() {
        return remainingActions;
    }

    public void setRemainingActions(int remainingActions) {
        this.remainingActions = remainingActions;
    }

    public int getRemainingTreasure() {
        return remainingTreasure;
    }

    public void setRemainingTreasure(int remainingTreasure) {
        this.remainingTreasure = remainingTreasure;
    }

    public int getRemainingBuys() {
        return remainingBuys;
    }

    public void setRemainingBuys(int remainingBuys) {
        this.remainingBuys = remainingBuys;
    }
}
