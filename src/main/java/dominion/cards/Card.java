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
    //getters
    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public int getCost() {
        return cost;
    }

    public int getPlusTrueasure() {
        return plusTrueasure;
    }

    public int getPlusAction() {
        return plusAction;
    }

    public int getPlusBuy() {
        return plusBuy;
    }

    public int getPlusCards() {
        return plusCards;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    //Static
    public static Card copper(){
        return new Card("Copper","",0,1,0,0,0,0);
    }
    public static Card estate(){
        return new Card("Estate","",0,0,0,0,0,1);
    }


}
