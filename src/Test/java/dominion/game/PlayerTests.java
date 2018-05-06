package dominion.game;

import dominion.cards.Card;
import static org.junit.jupiter.api.Assertions.*;


import dominion.cards.CardType;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class PlayerTests {

    // Treasury : (C) (G) (S)
    // Victory: (V1) (V3) (V6)

    @Test
    public void player_initially_has_7_single_copper_and_3_estate_cards() {
        //Arrange
        Game game = new Game(4);
        //Act


        for (Player player : game.getPlayers()) {
            //Act
            List<Card> allCards = player.getAllCards();

            //Assert
            assertHasCards(allCards,7, Card.copper());
            assertHasCards(allCards,3, Card.estate());

        }




    }

    private void assertHasCards(List<Card> allCards, int number, Card card){
        int cardsFound=0;
        for (int i = 0; i < allCards.size() ; i++) {
            if (allCards.get(i).getName() == card.getName()){
                ++cardsFound;
            }

        }

        assertEquals(number,cardsFound);



    }
    private void assertCards(Player player, String... cards) {
        List<Card> allCards = player.getAllCards();

        assertEquals(cards.length, allCards.size());

        for (int i = 0; i < cards.length; i++) {
            assertCard(allCards.get(i), cards[i]);
        }
    }

    private void assertCard(Card card, String c) {
        if (c == "C") {
            assertEquals(CardType.TREASURE, card.getCardType());
            assertEquals("Copper", card.getName());
        }
        else if (c == "V1") {
            Card expected = Card.estate();
            assertEquals(expected.getCardType(), card.getCardType());
            assertEquals(expected.getName(), card.getName());
        }
    }

    @Test
    public void playerInitiallyHas5CardsOnHand() {
        // Arrange
        Game game = new Game(4);

        for (Player player : game.getPlayers()) {
            //Act
            List<Card> cards = player.getHand();
            // Assert
            assertEquals(5, cards.size());
        }

    }
    /*

    @Test
    public void players_turn_initiallyHas_1Buy_1Action_0Treasure() {
        //Arrange
        Player player = new Player();
        //Act
        player.newTurn();
        //Assert
        assertEquals(1,player.getTurn().getNumberOfBuys());
        assertEquals(1,player.getTurn().getNumberOfActions());
        assertEquals(0,player.getTurn().getTreasurePoins());

    }

    @Test
    public void copperAwards_1TreasurePoint(){
        //Arrange
        Player player = new Player();
        //Act
        player.play(Treasure.copper());

    } */

}