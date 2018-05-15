
package game;

import dominion.game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {

    @Test
    public void numberOfPlayers(){
        Game game = new Game(4);
        Assertions.assertEquals(4, game.getPlayers().size());
    }





}
