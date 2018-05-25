package dominion.player;

import dominion.cards.CardType;
import dominion.game.Game;
import dominion.game.Tools;
import dominion.game.Turn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Player {
    private int id;
    private Stack<String> deck;
    private ArrayList<String> hand;
    private ArrayList<String> discard;
    private int victoryPoints;
    private Game game;
    private Turn turn;


    //Constructor
    public Player(Game game, int id) {
        this.id = id;
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.victoryPoints = 0;
        this.game = game;

        game.initializePlayersDeck(this);
        Collections.shuffle(deck);
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


    //Methods for player to play his turn


    public void readyToPlay(){
        this.turn = new Turn();
    }

    public void playCard(String card) {
        if (hand.contains(card)){
            game.getCardMap().get(card).doPlayCard(this);

        }


    }

    public void buyCard(String card) {
        game.buyCard(card, this);
    }

    public void endOfTurn() {

        discard.addAll(hand);
        hand.clear();
        drawCards(5);

    }

    /*
    public void playAllCards() {

        for (String card : new ArrayList<>(hand)) {
            playCard(card);
        }

    }

    public void buyThings() {
        if(game.getTurn().getTreasurePoints()>8) buyCard("Province");
        else if(game.getTurn().getTreasurePoints() <4) buyCard("Silver");
        else if(game.getTurn().getTreasurePoints() == 4 ) buyCard("Smithy");
        else if(game.getTurn().getTreasurePoints() == 6) buyCard("Gold");

    }
*/

    //Setters

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }


    //Getters
    //

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

    public int getId() {
        return id;
    }
}
