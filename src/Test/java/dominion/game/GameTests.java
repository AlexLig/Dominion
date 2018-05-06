package dominion.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {

    @Test
    public void numberOfPlayers(){
        Game game = new Game(4);
        Assertions.assertEquals(4,game.getPlayers().size());
    }

    @Test
    public void how_many_Cards_the_game_has(){
        Game game = new Game(4);
        Assertions.assertEquals(2,game.getGameCards().size());
    }

    @Test
    public void testSomething(){
        Game game = new Game(4);

    }

}
