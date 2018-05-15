package dominion.cards;

import dominion.cardEffects.CardEffect;
import dominion.cardEffects.PlusTreasure;
import dominion.game.Player;
import dominion.game.PlayerState;

public class Treasure extends Card{

    private PlusTreasure plusTreasure;
    private int treasurePoints;

    public Treasure(String name, String description, int cost, int treasurePoints) {
        super(name, description, cost);
        this.plusTreasure = new PlusTreasure(treasurePoints);
    }





    public static Treasure copper(){
        return new Treasure("Copper","",0, 1);
    }
    public static Treasure silver(){
        return new Treasure("Silver","",3, 2);
    }
    public static Treasure gold(){
        return new Treasure("Gold","",6, 3);
    }

    @Override
    public void activate(PlayerState playerState) {
        plusTreasure.activate(playerState);
    }


}
