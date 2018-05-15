package game;

import dominion.cards.Card;
import dominion.game.Game;
import dominion.game.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PlayerTests {

    // Treasury : (C) (G) (S)
    // Victory: (V1) (V3) (V6)

    @Test
    public void player_initially_has_7_single_copper_and_3_estate_cards() {
        //Arrange

        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        //Act
        List<String> allCards = player.getAllCards();

        //Assert
        assertHasCards(allCards,7, "Copper");
        assertHasCards(allCards,3, "Estate");

    }

    private void assertHasCards(List<String> allCards, int number, String card){
        int cardsFound=0;
        for (String eachCard : allCards) {
            if (eachCard == card){
                ++cardsFound;
            }

        }

        assertEquals(number,cardsFound);



    }


    @Test
    public void playerInitiallyHas5CardsOnHand() {
        // Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        // Act
        List<String> cards = player.getPlayerState().getHand();
        // Assert
        assertEquals(5, cards.size());
    }

    @Test
    public void playerHas5CardsOnHand() {
        // Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);

        // Act
        player.endOfTurn();
        List<String> cards = player.getHand();
        // Assert
        assertEquals(5, cards.size());

        // Act
        player.endOfTurn();
        cards = player.getHand();
        // Assert
        assertEquals(5, cards.size());

        // Act
        player.endOfTurn();
        cards = player.getHand();
        // Assert
        assertEquals(5, cards.size());
    }





}
