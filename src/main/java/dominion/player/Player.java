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
    public final void play() {
        readyToPlay();
        turnReport();
        playAllCardsInHand();
        game.switchToNextPhase();
        turnReport();
        playAllCardsInHand();
        turnReport();
        buyThings();
        endOfTurn();

    }

    public void readyToPlay(){
        this.turn = new Turn();
    }

    private void turnReport(){
        System.out.println(String.format("Player %d: Has %d Action Points. %d Buy Points. %d Treasure Points.",id,turn.getActionPoints(),turn.getBuyPoints(),turn.getTreasurePoints()));
    }

    private void playAllCardsInHand(){
        //Iterate to a copy ArrayList of hand so the cards can discard themselves without causing any problem
        for (String card : new ArrayList<>(hand)) {
            playCard(card);
        }
    }

    public void playCard(String card) {
        if (hand.contains(card)){
            game.getCardMap().get(card).doPlayCard(this);

        }


    }

    public void buyThings() {
        switch (turn.getTreasurePoints()){
            case 3: buyCard("Silver");
            case 4: buyCard("Smithy");
            case 5: buyCard("Smithy");
            case 6: buyCard("Gold");
            case 7: buyCard("Gold");
            case 8: buyCard("Province");
            case 9: buyCard("Province");
            case 10: buyCard("Province");
            case 11: buyCard("Province");
            case 12: buyCard("Province");
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
