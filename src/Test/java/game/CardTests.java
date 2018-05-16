package game;
import dominion.cards.Card;
import dominion.cards.Treasure;
import dominion.cards.actionCards.Smithy;
import dominion.game.Game;
import dominion.game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTests {

    @Test
    public void copperCard_awardsOneTreasurePoint_toPlayersTurn(){
        Player player = new Player();
        Treasure.copper().activate(player.getPlayerState());
        Assertions.assertEquals(1, player.getPlayerState().getTurn().getTreasurePoints());

    }
    @Test
    public void silverCard_awardsTwoTreasurePoints_toPlayersTurn(){
        Player player = new Player();
        Treasure.silver().activate(player.getPlayerState());
        Assertions.assertEquals(2,player.getPlayerState().getTurn().getTreasurePoints());

    }
    @Test
    public void goldCard_awardsThreeTreasurePoints_toPlayersTurn(){
        Player player = new Player();
        Treasure.gold().activate(player.getPlayerState());
        Assertions.assertEquals(3, player.getPlayerState().getTurn().getTreasurePoints());

    }
    @Test
    public void testsmthing() {
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        Smithy.smithy().activate(player.getPlayerState());
        Assertions.assertEquals(8, player.getPlayerState().getHand().size());
    }

}
