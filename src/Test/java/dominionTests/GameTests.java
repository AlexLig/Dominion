
package dominionTests;

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
    public void testingFindWinner(){
        //Arrange
        Game game = new Game(4);
        //Act
        Tools.addStringCard("Province",3, game.getPlayers().get(0).getDeck());
        game.findWinner();
        //Assert
        Assertions.assertEquals(game.getPlayers().get(0), game.getWinner());


        //id == 16??? many instances ?   foreach--> new  player ?
        //Assertions.assertEquals(0, game.getWinner().getId());
    }

    @Test
    public void gameRemovingCardsWhenBought() {
        // Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        game.setActivePlayer(player);
        game.newTurn(TurnPhase.ACTION);
        // Act
        player.endOfPhase();
        player.playCard("Gold");
        player.playCard("Gold");
        player.playCard("Gold");
        player.endOfPhase();
        player.buyCard("Province");
        // Assert
        assertEquals(TurnPhase.BUY, game.getTurnPhase());
        assertEquals(5, player.getHand().size());
        assertEquals(1, game.getTurn().getTreasurePoints());
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

    @Test
    public void testBuyACardWorks(){
        Game game = new Game(4);
        game.newTurn(TurnPhase.BUY);

        game.getTurn().addTreasurePoints(25);
        game.getTurn().addBuyPoints(5);
        game.setActivePlayer(game.getPlayers().get(0));
        game.getActivePlayer().buyCard("Province");
        game.getActivePlayer().buyCard("Province");
        game.getActivePlayer().buyCard("Province");
        Assertions.assertEquals(false, game.getPileOfCards().contains("Province"));
    }

}
