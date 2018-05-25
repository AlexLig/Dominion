package dominionTests;
import dominion.game.Game;
import dominion.player.Player;
import dominion.game.TurnPhase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTests {

    @Test
    public void copperCard_awardsOneTreasurePoint(){
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        player.getHand().add("Copper");
        player.readyToPlay();
        game.newPhase(TurnPhase.BUY);


        //Act
        player.playCard("Copper");

        //Assert
        Assertions.assertEquals(1, player.getTurn().getTreasurePoints());

    }
    @Test
    public void silverCard_awardsTwoTreasurePoint(){
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        player.getHand().add("Silver");
        player.readyToPlay();
        game.newPhase(TurnPhase.BUY);


        //Act
        player.playCard("Silver");

        //Assert
        Assertions.assertEquals(2, player.getTurn().getTreasurePoints());

    }
    @Test
    public void goldCard_awardsTwoTreasurePoint(){
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        player.getHand().add("Gold");
        player.readyToPlay();
        game.newPhase(TurnPhase.BUY);


        //Act
        player.playCard("Gold");

        //Assert
        Assertions.assertEquals(3, player.getTurn().getTreasurePoints());

    }

    @Test
    public void smithyAwards3Cards() {
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        player.getHand().add("Smithy");
        player.readyToPlay();
        game.newPhase(TurnPhase.ACTION);


        //Act
        player.playCard("Smithy");
        //Assert
        Assertions.assertEquals(8, player.getHand().size());
    }
}
