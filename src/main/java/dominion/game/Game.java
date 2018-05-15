package dominion.game;

import dominion.cards.Card;
import dominion.cards.Treasure;
import dominion.cards.Victory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    //Fields
    private ArrayList<Player> players;
    private ArrayList<String> pileOfCards;
    private Map<String, Card> cardMap;
    private Player activePlayer;


    //Constructor
    public Game(int numberOfPlayers) {

        this.cardMap = new HashMap<>();
        this.pileOfCards = new ArrayList<>();
        this.players = new ArrayList<>();

        initialisingNamesToCardsMapping();
        initialisingPileOfCards();
        initialisingPlayers(numberOfPlayers);


    }


    //Helper Methods
    private void initialisingNamesToCardsMapping() {

        cardMap.put("Copper", Treasure.copper());
        cardMap.put("Estate", Victory.estate());

    }

    private void initialisingPileOfCards() {

        addCard("Copper", 30, pileOfCards);
        addCard("Estate", 30, pileOfCards);


    }

    private void addCard(String card, int times, List<String> toHere) {
        for (int i = 0; i < times; i++) {
            toHere.add(card);
        }
    }

    private void initialisingPlayers(int numberOfPlayers) {

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(pileOfCards));

        }

    }


    public ArrayList<String> getPileOfCards() {
        return pileOfCards;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }


}
