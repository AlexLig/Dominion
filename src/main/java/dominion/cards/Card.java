package dominion.cards;

public class Card {
    private String Name;
    private String Description;
    private int  cost;
    private int plusTrueasure;
    private int plusAction;
    private int plusBuy;
    private int plusCards;
    private int victoryPoints;

    private Card(String name, String description, int cost, int plusTrueasure, int plusAction, int plusBuy, int plusCards, int victoryPoints) {
        Name = name;
        Description = description;
        this.cost = cost;
        this.plusTrueasure = plusTrueasure;
        this.plusAction = plusAction;
        this.plusBuy = plusBuy;
        this.plusCards = plusCards;
    }

    public Card copper(){
        return new Card("Copper","",0,1,0,0,0,0);
    }
    public Card estate(){
        return new Card("Estate","",0,0,0,0,0,1);
    }
}
