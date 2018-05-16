package dominion.game;

import dominion.cards.Card;
import dominion.cards.CardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Player {

    private PlayerState playerState;
    private int victoryPoints;

    public Player() {
        this.playerState = new PlayerState();
        this.victoryPoints = 0;

    }

    public Player(List<String> pileOfCards) {
        this.playerState = new PlayerState();
        this.victoryPoints = 0;
        initialisingPlayersDeck_andHand(pileOfCards);
    }

    private void initialisingPlayersDeck_andHand(List<String> pileOfCards) {

        addCardToDeckFromDeck("Copper", 7, pileOfCards, playerState.getDeck());
        addCardToDeckFromDeck("Estate", 3, pileOfCards, playerState.getDeck());
        Collections.shuffle(playerState.getDeck());
        drawCards(5);

    }

    private void addCardToDeckFromDeck(String card, int times, List<String> fromHere, List<String> toHere) {
        for (int i = 0; i < times; i++) {
            toHere.add(card);
            fromHere.remove(card);
        }
    }


    private void drawCards(int numberOfCards) {
        if (playerState.getDeck().size() < numberOfCards) {
            int tempDeckSize = playerState.getDeck().size();
            //draw as many cards there are left in deck
            for (int i = 0; i < playerState.getDeck().size(); i++) {
                playerState.getHand().add(playerState.getDeck().pop());
            }
            discardToDeckAndShuffle();
            //draw the rest
            for (int i = 0; i < (numberOfCards - tempDeckSize); i++) {
                playerState.getHand().add(playerState.getDeck().pop());
            }
        } else {
            for (int i = 0; i < (numberOfCards); i++) {
                playerState.getHand().add(playerState.getDeck().pop());
            }
        }
    }

    private void discardToDeckAndShuffle() {
        playerState.getDeck().addAll(playerState.getDiscard());
        playerState.getDiscard().clear();
        Collections.shuffle(playerState.getDeck());
    }


    public PlayerState getPlayerState() {
        return playerState;
    }


    public List<String> getAllCards() {
        ArrayList<String> allCards = new ArrayList<>();
        allCards.addAll(playerState.getDeck());
        allCards.addAll(playerState.getHand());
        allCards.addAll(playerState.getDiscard());
        return allCards;
    }


    public void play(Map<String, Card> cardMap) {

        //Play actions
        while (playerState.getTurn().getActionPoints() > 0) {
            playHand(cardMap, CardType.ACTION);
        }
        //Play treasures
        playHand(cardMap, CardType.TREASURE);


        endOfTurn();
    }

    public void playHand(Map<String, Card> cardMap, CardType turnState) {
        for (String card : playerState.getHand()) {
            if (cardMap.get(card).getCardType() == turnState) {
                cardMap.get(card).activate(playerState);
            }
        }
    }


    public void endOfTurn() {

        playerState.getDiscard().addAll(playerState.getHand());
        playerState.getHand().clear();
        drawCards(5);
        playerState.setTurn(new Turn());
    }
}
