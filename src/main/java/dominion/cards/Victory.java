package dominion.cards;

import dominion.game.PlayerState;

public class Victory extends Card {
    private int victoryPoints;

    public Victory(String name, String description, int cost, int victoryPoints, CardType cardType) {
        super(name, description, cost, cardType);
        this.victoryPoints = victoryPoints;
    }
    public static Victory estate(){
        return new Victory("Estate","",2,1, CardType.VICTORY);
    }

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void activate(PlayerState playerState) {

    }


}
