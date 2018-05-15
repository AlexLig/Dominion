package game;
import dominion.cards.Card;
import dominion.cards.Treasure;
import dominion.game.Game;
import dominion.game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTests {

    @Test
    public void copperCard_awardsOneTreasurePoint_toPlayersTurn(){
        Player player = new Player();
        Treasure.copper().activate(player.getPlayerState());
        Assertions.assertEquals(1, player.getTurn().getTreasurePoints());

    }
    @Test
    public void silverCard_awardsTwoTreasurePoints_toPlayersTurn(){
        Player player = new Player();
        Treasure.silver().activate(player.getPlayerState());
        Assertions.assertEquals(2, player.getTurn().getTreasurePoints());

    }
    @Test
    public void goldCard_awardsThreeTreasurePoints_toPlayersTurn(){
        Player player = new Player();
        Treasure.gold().activate(player.getPlayerState());
        Assertions.assertEquals(3, player.getTurn().getTreasurePoints());

    }
}
