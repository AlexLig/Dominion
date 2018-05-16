package dominion.cards;

import dominion.game.PlayerState;

public abstract class  Card {
    private String name;
    private String description;
    private int cost;
    private CardType cardType;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Card(String name, String description, int cost, CardType cardType) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.cardType = cardType;
    }

    public int getVictoryPoints(){
        return 0;
    }

    public CardType getCardType() {
        return cardType;
    }

    public abstract void activate(PlayerState playerState);
}
