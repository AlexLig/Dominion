package dominion.game;

import dominion.cards.Card;
import dominion.cards.CardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import static dominion.game.Tools.addCardByNameToDeck;

public class Game {
    //Fields
    private ArrayList<Player> players;
    private ArrayList<Card> gameCards;
    //Constructor
    public Game(int numberOfPlayers) {
        initialisingCards();
        initialisingPlayers(numberOfPlayers);


    }
    //Helper Methods
    private void initialisingPlayers(int numberOfPlayers){
        this.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());

        }
        initialisingPlayersDeck_andHand();
    }
    private void initialisingPlayersDeck_andHand(){
        for (Player player : players) {

            Stack<Card> playersDeck = player.getDeck();
            ArrayList<Card> playersHand = player.getHand();

            addCardByNameToDeck(7,"Copper",gameCards,playersDeck);
            addCardByNameToDeck(3,"Estate",gameCards,playersDeck);

            Collections.shuffle(playersDeck);

            Tools.drawCardsFromDeck(5,playersDeck,playersHand);

        }
    }
    private void initialisingCards(){
        this.gameCards = new ArrayList<>();
        gameCards.add(Card.copper());
        gameCards.add(Card.estate());

    }


    public void gameRound(){
        for (Player player: players) {
            player.playHand(CardType.ACTION);
            player.playHand(CardType.TREASURE);
        }
    }


    //Getters
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Card> getGameCards() {
        return gameCards;
    }
}
