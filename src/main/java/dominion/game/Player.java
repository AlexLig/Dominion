package dominion.game;

import dominion.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static dominion.game.Tools.*;

public class Player {
    private Stack<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> discard;
    private int victoryPoints;


    public Player() {
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.victoryPoints = 0;

        initialisingPlayersDeck_andHand();


    }
    private void initialisingPlayersDeck_andHand(){

        addCardToDeck(7,Card.copper(),deck);
        addCardToDeck(3,Card.estate(),deck);
        Collections.shuffle(deck);
        drawCardsFromDeck(5, deck, hand);


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

    public void playCardByName(String cardName){
        playCard(findCardByName(cardName,hand));

    }
    private void playCard (Card card){

    }


    public List<Card> getAllCards() {
        ArrayList<Card> allCards = new ArrayList<>();
        allCards.addAll(deck);
        allCards.addAll(hand);
        allCards.addAll(discard);
        return allCards;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void addVictoryPoints(int victoryPoints) {
        this.victoryPoints += victoryPoints;
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





}
