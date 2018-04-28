package dominion.game;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.cards.Treasure;
import dominion.cards.Victory;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private int numberOfPlayers;
    private ArrayList<Player> listOfPlayers = new ArrayList<Player>();
    private ArrayList<Card> gameCards;


    //Constructor
    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.gameCards = new ArrayList<>();
    }

    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }



    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    //Helper Method to find a card by name
    private Card getCardByName(String name) {
        Card theCard = null;
        for (Card temp : gameCards) {
            if (temp.getName().equals(name)) {
                theCard = temp;
            }

        }
        return theCard;
    }

    //Helper Method for instancing new players in to the listOfPlayers ArrayList
    private void newPlayers() {
        for (int i = 1; i <= numberOfPlayers; i++) {
            listOfPlayers.add(new Player());
        }
    }

    //Helper method for initializing Player objects in an ArrayList
    private void dealNewGameDecks() {

        //selecting each listOfPlayers and dealing him 7 victory cards and 3 treasure cards. (Deck initialization)
        for (int i = 0; i < numberOfPlayers; i++) {

            //deal  7 copper (starting a new game)
            for (int k = 0; k < 7; k++) {
                listOfPlayers.get(i).deck.push(getCardByName("copper"));

            }
            //deal  3 estates (starting a new game)
            for (int k = 0; k < 3; k++) {
                listOfPlayers.get(i).deck.push(getCardByName("estate"));

            }
            //shuffle current listOfPlayers's deck
            Collections.shuffle(listOfPlayers.get(i).deck);
            //draw five cards
            listOfPlayers.get(i).endOfTurn();

        }

    }

    //Helper method for initializing a copy of each Card in the gameCard property of this card
    private void initializeGameCards(){
        this.gameCards.add(new Treasure("copper","",CardType.TREASURE,0,10,1));
        this.gameCards.add(new Treasure("silver","",CardType.TREASURE,3,10,2));
        this.gameCards.add(new Treasure("gold","",CardType.TREASURE,6,10,3));
        this.gameCards.add(new Victory("estate","",CardType.TREASURE,2,10,1));
    }


    public void newGame() {
        newPlayers();
        initializeGameCards();
        dealNewGameDecks();


    }

}
