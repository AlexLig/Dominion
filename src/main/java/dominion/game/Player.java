package dominion.game;

import dominion.cards.Card;
import dominion.cards.CardType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private Stack<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> discard;

    private int treasurePoints;
    private int numberOfActions;
    private int numberOfBuys;

    public Player() {
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.treasurePoints = 0;
        this.numberOfActions = 1;
        this.numberOfBuys = 1;

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

    public int getTreasurePoints() {
        return treasurePoints;
    }

    public int getNumberOfActions() {
        return numberOfActions;
    }

    public int getNumberOfBuys() {
        return numberOfBuys;
    }

    public List<Card> getAllCards() {
        ArrayList<Card> allCards = new ArrayList<>();
        allCards.addAll(deck);
        allCards.addAll(hand);
        allCards.addAll(discard);
        return allCards;
    }

    public void playHand(CardType cardType) {
        for (Card card : hand) {
            if (card.getCardType() == cardType) {
                play(card);
            }
        }

    }

    private void play(Card card) {
        CardType cardType = card.getCardType();
        switch (cardType) {
            case TREASURE:
                treasurePoints += card.getPlusTreasure();
                break;
            case ACTION:
                treasurePoints += card.getPlusTreasure();
                numberOfActions += card.getPlusAction();
                numberOfBuys += card.getPlusBuy();
                break;
            case VICTORY:
                break;

        }
    }
}
