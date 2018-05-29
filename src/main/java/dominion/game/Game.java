package dominion.game;

import dominion.cards.Card;
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

public class Game {
    //Fields
    private ArrayList<Player> players;
    private ArrayList<String> pileOfCards;
    private Map<String, Card> cardMap;

    private int emptyStacks;
    private boolean gameHasEnded;
    private Player winner;

    private TurnPhase turnPhase;


    //Constructor
    public Game(int numberOfPlayers) {

        this.cardMap = new HashMap<>();
        this.pileOfCards = new ArrayList<>();
        this.players = new ArrayList<>();
        this.gameHasEnded = false;
        this.emptyStacks =0;

        initialisingNamesToCardsMapping();
        initialisingPileOfCards();
        initialisingPlayers(numberOfPlayers);


    }

    //Helper Methods for dominionTests initialisation

    private void initialisingNamesToCardsMapping() {
        //Treasures
        cardMap.put("Copper", new Copper());
        cardMap.put("Silver", new Silver());
        cardMap.put("Gold", new Gold());
        //Victory Cards
        cardMap.put("Estate", new Estate());
        cardMap.put("Duchy", new Duchy());
        cardMap.put("Province", new Province());
        //ActionBehaviour Cards
        cardMap.put("Smithy", new Smithy());


    }

    private void initialisingPileOfCards() {

        addStringCard("Copper", 30, pileOfCards);
        addStringCard("Silver", 30, pileOfCards);
        addStringCard("Gold", 30, pileOfCards);
        addStringCard("Estate", 30, pileOfCards);
        addStringCard("Duchy", 30, pileOfCards);
        addStringCard("Province", 10, pileOfCards);
        addStringCard("Smithy", 10, pileOfCards);


    }

    private void initialisingPlayers(int numberOfPlayers) {

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(this, i));
        }

    }

    //initializePlayersDeck is being called in Player constructor to deal him his Starting Cards (7 Copper and 3 Estate)
    public void initializePlayersDeck(Player player) {
        dealCardsToPlayer("Copper", 7, player);
        dealCardsToPlayer("Estate", 3, player);
    }

    private void dealCardsToPlayer(String card, int times, Player player) {
        for (int i = 0; i < times; i++) {
            player.getDeck().add(card);
            pileOfCards.remove(card);
        }
    }


    public void gameLoop(){
        while (!gameHasEnded){
            for(Player player: players){
                newPhase(TurnPhase.ACTION);
                player.play();
                //printPlayerState(player);
            }
        }
        findWinner();
        printPlayers();

    }

    private void printPlayerState(Player player){
        System.out.println("Player: "+player.getId());
        System.out.print("Hand: ");
        for( String card : player.getHand()){System.out.print(" " + card );}
        System.out.println(" ");
        System.out.println("Discard: ");
        for( String card : player.getDiscard()){System.out.print(" "+ card);}
        System.out.println(" ");
        System.out.println("Deck: ");
        for( String card : player.getDeck()){System.out.print(" "+ card);}
        System.out.println(" ");


    }


    public void newPhase(TurnPhase phase) {
        turnPhase = phase;
    }
    public void switchToNextPhase() {
        switch (turnPhase) {
            case ACTION:
                turnPhase = TurnPhase.BUY;
                break;
           /* case BUY:
                turnPhase = TurnPhase.ACTION;
                break;
           */

        }
    }



    //Find the winner
    public void findWinner() {

        for (Player player : players) {
            player.setVictoryPoints(countVictoryPoints(player));
        }

        this.winner = players.stream().max(Comparator.comparing(Player::getVictoryPoints)).get();
    }

    private int countVictoryPoints(Player player) {
        int points = 0;
        for (String card : player.getAllCards()) {
            points += cardMap.get(card).getVictoryPoints();
        }
        return points;

    }

    public void printPlayers() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + i + " finished with: " + players.get(i).getVictoryPoints());
        }
        System.out.println("The winner is Player " + winner.getId() + " with: " + winner.getVictoryPoints() + " Victory Points");
        for(Player player: players){
            System.out.println("Player: " + player.getId());
            for(String card: player.getAllCards()){
                System.out.print(card + " " );
            }
            System.out.println();
        }
    }


    // buyCard is called by a player and it gives him a card if he can afford it
    public void buyCard(String card, Player player) {
        if (turnPhase == TurnPhase.BUY && player.getTurn().getBuyPoints() > 0 && player.getTurn().getTreasurePoints() >= cardMap.get(card).getCost() && pileOfCards.contains(card)) {
            player.getDiscard().add(card);
            pileOfCards.remove(card);

            player.getTurn().removeTreasurePoints(cardMap.get(card).getCost());

            player.getTurn().removeBuyPoints(1);

            buyReport(player,card);

            if (!pileOfCards.contains("Province")){
                gameHasEnded = true;
            }
            else if (!pileOfCards.contains(card)){
                emptyStacks++;
                if (emptyStacks>=3){gameHasEnded= true;}
            }

        }
    }
    private void buyReport(Player player, String card){
        System.out.println("Player " + player.getId()+": bought " + card + " card");
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

    public TurnPhase getTurnPhase() {
        return turnPhase;
    }

    public Player getWinner() {
        return winner;
    }


}
