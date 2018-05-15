package dominion.cards;

import dominion.game.Player;

public abstract class  Card {
    private String name;
    private String description;
    private int cost;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Card(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public int getVictoryPoints(){
        return 0;
    }

    public abstract void activate(Player player);
}
