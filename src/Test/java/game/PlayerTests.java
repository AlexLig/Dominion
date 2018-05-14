package game;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {

    // Treasury : (C) (G) (S)
    // Victory: (V1) (V3) (V6)

    @Test
    public void player_initially_has_7_single_copper_and_3_estate_cards() {
        //Arrange
        Player player = new Player();
        //Act
        List<Card> allCards = player.getAllCards();

        //Assert
        assertHasCards(allCards,7, Card.copper());
        assertHasCards(allCards,3, Card.estate());

    }

    private void assertHasCards(List<Card> allCards, int number, Card card){
        int cardsFound=0;
        for (Card eachCard : allCards) {
            if (eachCard.getName() == card.getName()){
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
        Player player = new Player();
        // Act
        List<Card> cards = player.getHand();
        // Assert
        assertEquals(5, cards.size());
    }

    @Test
    public void playerHas5CardsOnHand() {
        // Arrange
        Player player = new Player();
        // Act
        player.endOfTurn();
        List<Card> cards = player.getHand();

        // Assert
        assertEquals(5, cards.size());

        // Act
        player.endOfTurn();
        cards = player.getHand();

        // Assert
        assertEquals(5, cards.size());
    }


    @Test
    public void copperAwards_1TreasurePoint(){
        //Arrange
        Player player = new Player();
        //Act


    }

}
