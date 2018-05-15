package dominion.cards;

import dominion.cardEffects.CardEffect;
import dominion.cardEffects.PlusTreasure;
import dominion.game.Player;

public class Treasure extends Card{

    private PlusTreasure plusTreasure;
    private int treasurePoints;

    public Treasure(String name, String description, int cost, int treasurePoints) {
        super(name, description, cost);
        this.plusTreasure = new PlusTreasure(treasurePoints);
    }

    public void activate(Player player){
        plusTreasure.activate(player);
    }



    public static Card copper(){
        return new Treasure("Copper","",0, 1);
    }
}
