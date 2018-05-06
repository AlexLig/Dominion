package dominion.game;

import dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import dominion.game.Tools.*;

public class Player {
    private Stack<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> discard;

    public Player() {
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();

    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getDiscard() {
        return discard;
    }

    public List<Card> getAllCards() {
        ArrayList<Card> allCards = new ArrayList<Card>();
        allCards.addAll(deck);
        allCards.addAll(hand);
        allCards.addAll(discard);
        return allCards;
    }
}
