package dominion.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {

    @Test
    public void numberOfPlayers(){
        Game game = new Game(4);
        Assertions.assertEquals(4,game.getPlayer().size());
    }

}
