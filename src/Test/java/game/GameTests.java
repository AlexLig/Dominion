
package game;

import dominion.game.Game;
import dominion.game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {

    @Test
    public void numberOfPlayers(){
        Game game = new Game(4);
        Assertions.assertEquals(4, game.getPlayers().size());
    }

  /*  @Test
    public void playerCanPlayCoppersCorrectly(){
        Game game = new Game(4);
        for (Player player: game.getPlayers()) {
            player.playHand(game.getCardMap());
            Assertions.assertEquals(numberOfCardInDeck("Copper", player.getPlayerState().getHand()), player.getPlayerState().getTurn().getTreasurePoints());
            player.endOfTurn();

            player.playHand(game.getCardMap());
            Assertions.assertEquals(numberOfCardInDeck("Copper", player.getPlayerState().getHand()), player.getPlayerState().getTurn().getTreasurePoints());
            player.endOfTurn();

            player.playHand(game.getCardMap());
            Assertions.assertEquals(numberOfCardInDeck("Copper", player.getPlayerState().getHand()), player.getPlayerState().getTurn().getTreasurePoints());
            player.endOfTurn();
        }

    }
    */
    public int numberOfCardInDeck(String card, Iterable<String> setOfCards){
        int cardsFound =0 ;
        for (String eachCard : setOfCards) {
            if (eachCard == card){
                ++cardsFound;
            }
        }
        return cardsFound;
    }



}
