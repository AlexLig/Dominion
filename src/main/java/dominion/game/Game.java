package dominion.game;


import dominion.cards.Card;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Card> gameCards;

    public Game(int numberOfPlayers) {
        initialisingPlayers(numberOfPlayers);
        initialisingCards();
    }
    private void initialisingPlayers(int numberOfPlayers){
        this.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }
    }
    private void initialisingCards(){
        this.gameCards = new ArrayList<>();
        gameCards.add(Card.copper());
        gameCards.add(Card.estate());

    }
    private void initialisingPlayersDeck(){
        for (Player player : players) {
            Stack<Card> playersDeck = player.getDeck();
            Tools.addCardByNameToDeck(7,"Copper",gameCards,playersDeck);
            Tools.addCardByNameToDeck(7,"Estate",gameCards,playersDeck);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Card> getGameCards() {
        return gameCards;
    }
}
