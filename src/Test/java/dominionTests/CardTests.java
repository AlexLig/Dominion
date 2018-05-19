package dominionTests;

import dominion.game.Game;
import dominion.game.TurnPhase;
import dominion.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTests {

    @Test
    public void copperCard_awardsOneTreasurePoint_toTurn(){
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        game.setActivePlayer(player);
        game.newTurn(TurnPhase.TREASURE);

        //Act
        player.playCard("Copper");
        //Assert
        Assertions.assertEquals(1, game.getTurn().getTreasurePoints());

    }
    @Test
    public void silverCard_awardsTwoTreasurePoints_toTurn(){
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        game.setActivePlayer(player);
        game.newTurn(TurnPhase.TREASURE);

        //Act
        player.playCard("Silver");
        //Assert
        Assertions.assertEquals(2, game.getTurn().getTreasurePoints());

    }
    @Test
    public void goldCard_awardsThreeTreasurePoints_toTurn(){
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        game.setActivePlayer(player);
        game.newTurn(TurnPhase.TREASURE);

        //Act
        player.playCard("Gold");
        //Assert
        Assertions.assertEquals(3, game.getTurn().getTreasurePoints());

    }
    @Test
    public void smithyAwards3Cards() {
        //Arrange
        Game game = new Game(4);
        Player player = game.getPlayers().get(0);
        game.setActivePlayer(player);
        game.newTurn(TurnPhase.ACTION);

        //Act
        player.playCard("Smithy");
        //Assert
        Assertions.assertEquals(8, player.getHand().size());
    }

}
