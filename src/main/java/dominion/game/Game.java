package dominion.game;

import dominion.cards.Card;
import dominion.cards.CardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Game {
    //Fields
    private ArrayList<Player> players;
    private ArrayList<Card> gameCards;
    private Turn turn;

    //Constructor
    public Game(int numberOfPlayers) {
        initialisingCards();
        initialisingPlayers(numberOfPlayers);


    }

    //Helper Methods
    private void initialisingCards() {
        this.gameCards = new ArrayList<>();
        gameCards.add(Card.copper());
        gameCards.add(Card.estate());

    }


    private void initialisingPlayers(int numberOfPlayers) {
        this.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());

        }

    }



    /*
    public void gameRound() {
        for (Player player : players) {

            playHandOfPlayer(player);
            player.endOfTurn();

        }
    }


    public void playHandOfPlayer(Player player) {
        for (Card card : player.getHand()) {

            player.addToNumberOfActions(card.getPlusAction());
            player.addToNumberOfBuys(card.getPlusBuy());
            player.addToTreasurePoints(card.getPlusTreasure());

        }
    }
    */

    public Player getWinner() {

        countVictoryCards();
        Player winner = Collections.max(players, Comparator.comparing(Player::getVictoryPoints));
        return winner;

    }

    public void countVictoryCards() {
        for (Player player : players) {
            for (Card card : player.getAllCards()) {
                if (card.getCardType() == CardType.VICTORY) {
                    player.addVictoryPoints(card.getVictoryPoints());
                }

            }

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
