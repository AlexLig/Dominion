package dominion.cards;

import dominion.game.Game;

public abstract class  Card {
    private String name;
    private String description;
    private int cost;
    private CardType cardType;
    protected Game game;



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Card(String name, String description, int cost, CardType cardType, Game game) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.cardType = cardType;
        this.game = game;
    }



    public int getVictoryPoints(){
        return 0;
    }

    public CardType getCardType() {
        return cardType;
    }

    public abstract void activate();
}
