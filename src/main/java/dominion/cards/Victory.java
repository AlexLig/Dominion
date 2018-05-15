package dominion.cards;

import dominion.game.Player;

public class Victory extends Card {
    private int victoryPoints;

    public Victory(String name, String description, int cost, int victoryPoints) {
        super(name, description, cost);
        this.victoryPoints = victoryPoints;
    }
    public static Victory estate(){
        return new Victory("Estate","",2,1);
    }

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void activate(Player player) {

    }


}
