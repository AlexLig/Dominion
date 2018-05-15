package dominion.game;

import dominion.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Player {
    private Stack<String> deck;
    private ArrayList<String> hand;
    private ArrayList<String> discard;
    private int victoryPoints;
    private Turn turn;

    public Player() {
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.victoryPoints = 0;
        this.turn = new Turn();
    }

    public Player(List<String> pileOfCards) {
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.victoryPoints = 0;
        this.turn = new Turn();
        initialisingPlayersDeck_andHand(pileOfCards);
    }

    private void initialisingPlayersDeck_andHand(List<String> pileOfCards){

        addCardToDeckFromDeck("Copper",7,pileOfCards,deck);
        addCardToDeckFromDeck("Estate",3,pileOfCards,deck);
        Collections.shuffle(deck);
        drawCards(5);

    }
    private void addCardToDeckFromDeck(String card, int times, List<String> fromHere, List<String> toHere){
        for (int i = 0; i < times ; i++) {
            toHere.add(card);
            fromHere.remove(card);
        }
    }





    public void endOfTurn() {

        discard.addAll(hand);
        hand.clear();
        drawCards(5);
    }

    private void drawCards(int numberOfCards) {
        if (deck.size() < numberOfCards) {
            int tempDeckSize = deck.size();
            //draw as many cards there are left in deck
            for (int i = 0; i < deck.size(); i++) {
                hand.add(deck.pop());
            }
            discardToDeckAndShuffle();
            //draw the rest
            for (int i = 0; i < (numberOfCards - tempDeckSize); i++) {
                hand.add(deck.pop());
            }
        } else {
            for (int i = 0; i < (numberOfCards); i++) {
                hand.add(deck.pop());
            }
        }
    }

    private void discardToDeckAndShuffle() {
        deck.addAll(discard);
        discard.clear();
        Collections.shuffle(deck);
    }








    public Turn getTurn() {
        return turn;
    }

    public List<String> getAllCards() {
        ArrayList<String> allCards = new ArrayList<>();
        allCards.addAll(deck);
        allCards.addAll(hand);
        allCards.addAll(discard);
        return allCards;
    }

    public List<String> getHand() {
        return hand;
    }
}
