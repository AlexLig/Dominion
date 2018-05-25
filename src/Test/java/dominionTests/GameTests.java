
package dominionTests;

import dominion.cards.Card;
import dominion.cards.CardType;
import dominion.game.Game;
import dominion.game.Tools;
import dominion.game.TurnPhase;
import dominion.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests {

    @Test
    public void numberOfPlayers(){
        Game game = new Game(4);
        Assertions.assertEquals(4, game.getPlayers().size());
    }



    public int numberOfCardInDeck(String card, Iterable<String> setOfCards){
        int cardsFound =0 ;
        for (String eachCard : setOfCards) {
            if (eachCard == card){
                ++cardsFound;
            }
        }
        return cardsFound;
    }

    @Test
    public void gameRemovingCardsWhenBought() {
        // Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        player.readyToPlay();
        player.getTurn().addTreasurePoints(8);
        game.newPhase(TurnPhase.BUY);
        // Act
        player.buyCard("Province");

        // Assert
        assertEquals(5, player.getHand().size());
        assertEquals(1, player.getDiscard().size());
        assertEquals(0, player.getTurn().getTreasurePoints());
        assertEquals(2, countCardsInPileOfCards(game.getPileOfCards(), "Province"));
    }
    private int countCardsInPileOfCards(List<String> pileOfCards, String card){
        int count=0;
        for( String eachCard : pileOfCards){
            if (eachCard == card){
                ++count;
            }
        }
        return  count;
    }


}
