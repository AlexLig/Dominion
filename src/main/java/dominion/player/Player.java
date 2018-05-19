package dominion.player;

import dominion.cards.CardType;
import dominion.game.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Player {
    private static int count = 0;
    private int id;
    private Stack<String> deck;
    private ArrayList<String> hand;
    private ArrayList<String> discard;
    private int victoryPoints;
    private Game game;
    private Logic logic;

    //Constructor
    public Player(Game game) {
        this.id = count;
        count++;
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.victoryPoints = 0;
        this.game = game;


        dealMeCards();
        Collections.shuffle(deck);
        drawCards(5);

    }

    //Helper methods for player initialisation
    //
    private void dealMeCards() {
        game.dealCards(this);
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


    //Methods for player to play his turn
    //
    public void playCard(String card) {
        game.playCard(card);
    }

    public void buyCard(String card) {
        game.buyCard(card);
    }

    public void endOfPhase() {
        game.endOfPhase();
    }

    public void endOfTurn() {

        discard.addAll(hand);
        hand.clear();
        drawCards(5);

    }

    //Logic = dumb logic
    public void dumbLogic() {
        playActions();
        game.endOfPhase();
        playTreasures();
        game.endOfPhase();
        buyThings();
        endOfTurn();
    }

    private void playActions() {
        for (String card : hand) {
            if (game.getCardMap().get(card).getCardType() == CardType.ACTION) {
                playCard(card);
            }
        }
    }

    private void playTreasures() {
        for (String card : hand) {
            if (game.getCardMap().get(card).getCardType() == CardType.TREASURE) {
                playCard(card);
            }
        }
    }

    private void buyThings() {
        if(game.getTurn().getTreasurePoints()>8) buyCard("Province");
        else if(game.getTurn().getTreasurePoints() <4) buyCard("Silver");
        else if(game.getTurn().getTreasurePoints() == 4 ) buyCard("Smithy");
        else if(game.getTurn().getTreasurePoints() == 6) buyCard("Gold");

    }


    //Getters
    //
    public void addVictoryPoints(int points) {
        victoryPoints += points;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public Stack<String> getDeck() {
        return deck;
    }

    public ArrayList<String> getHand() {
        return hand;
    }

    public ArrayList<String> getDiscard() {
        return discard;
    }

    public Game getGame() {
        return game;
    }

    public List<String> getAllCards() {
        ArrayList<String> allCards = new ArrayList<>();
        allCards.addAll(deck);
        allCards.addAll(hand);
        allCards.addAll(discard);
        return allCards;
    }


    public int getId() {
        return id;
    }
}
