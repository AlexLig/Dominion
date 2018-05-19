package dominion.game;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.cards.actionCards.Smithy;
import dominion.cards.treasureCards.Copper;
import dominion.cards.treasureCards.Gold;
import dominion.cards.treasureCards.Silver;
import dominion.cards.victoryCards.Duchy;
import dominion.cards.victoryCards.Estate;
import dominion.cards.victoryCards.Province;
import dominion.player.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static dominion.game.Tools.addStringCard;
import static dominion.game.Tools.moveStringCards;

public class Game {
    //Fields
    private ArrayList<Player> players;
    private ArrayList<String> pileOfCards;
    private Map<String, Card> cardMap;
    private Player activePlayer;
    private boolean gameHasEnded;
    private Player winner;
    private Turn turn;
    private TurnPhase turnPhase;


    //Constructor
    public Game(int numberOfPlayers) {

        this.cardMap = new HashMap<>();
        this.pileOfCards = new ArrayList<>();
        this.players = new ArrayList<>();
        this.gameHasEnded = false;

        initialisingNamesToCardsMapping();
        initialisingPileOfCards();
        initialisingPlayers(numberOfPlayers);


    }


    //Helper Methods for dominionTests initialisation
    private void initialisingNamesToCardsMapping() {
        //Treasures
        cardMap.put("Copper", new Copper(this));
        cardMap.put("Silver", new Silver(this));
        cardMap.put("Gold", new Gold(this));
        //Victory Cards
        cardMap.put("Estate", new Estate(this));
        cardMap.put("Duchy", new Duchy(this));
        cardMap.put("Province", new Province(this));
        //Action Cards
        cardMap.put("Smithy", new Smithy(this));


    }

    private void initialisingPileOfCards() {

        addStringCard("Copper", 30, pileOfCards);
        addStringCard("Silver", 30, pileOfCards);
        addStringCard("Gold", 30, pileOfCards);
        addStringCard("Estate", 30, pileOfCards);
        addStringCard("Duchy", 30, pileOfCards);
        addStringCard("Province", 3, pileOfCards);
        addStringCard("Smithy", 10, pileOfCards);


    }


    private void initialisingPlayers(int numberOfPlayers) {

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(this));

        }

    }

    public void dealCards(Player player) {
        moveStringCards("Copper", 7, pileOfCards, player.getDeck());
        moveStringCards("Estate", 3, pileOfCards, player.getDeck());
    }


    //Running the game


    public void gameLoop() {
        while (!gameHasEnded) {
            for (Player player : players) {
                activePlayer = player;
                newTurn(TurnPhase.ACTION);
                activePlayer.dumbLogic();
            }
        }

        findWinner();
    }


    public void newTurn(TurnPhase phase) {
        this.turn = new Turn();
        turnPhase = phase;
    }





    //Find the winner
    public void findWinner() {
        for (Player player : players) {
            activePlayer = player;
            addVictoryPointsToActivePlayer();

        }
        this.winner = players.stream().max(Comparator.comparing(Player::getVictoryPoints)).get();
        printPlayers();
    }

    public void addVictoryPointsToActivePlayer() {
        for (String card : activePlayer.getAllCards()) {
            if (cardMap.get(card).getCardType() == CardType.VICTORY) {
                cardMap.get(card).activate();
            }
        }


    }

    private void printPlayers() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + i + " finished with: " + players.get(i).getVictoryPoints());
        }
        System.out.println("The winner is Player: " + winner.getId() + " with: " + winner.getVictoryPoints() + " Victory Points");
    }


    //Methods for a player to call
    public void playCard(String card) {
        switch (turnPhase) {
            case ACTION:
                playAnActionCard(card);
                break;
            case TREASURE:
                playATreasureCard(card);
                break;

        }
    }

    public void buyCard(String card) {
        if (turn.getBuyPoints() > 0 && turn.getTreasurePoints() > cardMap.get(card).getCost() && pileOfCards.contains(card)) {
            addStringCard(card,1,activePlayer.getDiscard());
            pileOfCards.remove(card);
            turn.removeTreasurePoints(cardMap.get(card).getCost());
            if(! pileOfCards.contains("Province")) gameHasEnded=true;
        }
    }

    private void playAnActionCard(String card) {
        if (cardMap.get(card).getCardType() == CardType.ACTION && turn.getActionPoints() > 0) {
            cardMap.get(card).activate();
        }

    }

    private void playATreasureCard(String card) {
        if (cardMap.get(card).getCardType() == CardType.TREASURE) {
            cardMap.get(card).activate();
        }
    }



    public void endOfPhase() {
        switch (turnPhase) {
            case ACTION:
                turnPhase = TurnPhase.TREASURE;
                break;
            case TREASURE:
                turnPhase = TurnPhase.BUY;
                break;

        }
    }


    //Card Effects
    public void plusTreasure(int numberOfTreasurePoints) {
        turn.addTreasurePoints(numberOfTreasurePoints);
    }

    public void plusCards(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            activePlayer.getHand().add(activePlayer.getDeck().pop());
        }
    }

    public void addVictoryPointsToActivePlayer(int numberOfVictoryPoints) {
        activePlayer.addVictoryPoints(numberOfVictoryPoints);
    }


    //Getters


    public ArrayList<String> getPileOfCards() {
        return pileOfCards;
    }

    public Map<String, Card> getCardMap() {
        return cardMap;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Turn getTurn() {
        return turn;
    }

    public TurnPhase getTurnPhase() {
        return turnPhase;
    }

    public Player getWinner() {
        return winner;
    }
}
