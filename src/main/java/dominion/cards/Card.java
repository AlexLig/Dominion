package dominion.cards;

public class Card {
    private String Name;
    private String description;
    private CardType cardType;
    private int  cost;
    private int plusTreasure;
    private int plusAction;
    private int plusBuy;
    private int plusCards;
    private int victoryPoints;

    private Card(String name, String description, CardType cardType, int cost, int plusTreasure, int plusAction, int plusBuy, int plusCards, int victoryPoints) {
        this.Name = name;
        this.description = description;
        this.cardType = cardType;
        this.cost = cost;
        this.plusTreasure = plusTreasure;
        this.plusAction = plusAction;
        this.plusBuy = plusBuy;
        this.plusCards = plusCards;
    }
    //getters
    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    public CardType getCardType() {
        return cardType;
    }

    public int getCost() {
        return cost;
    }

    public int getPlusTreasure() {
        return plusTreasure;
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
        return new Card("Copper","", CardType.TREASURE,0,1,0,0,0,0);
    }
    public static Card estate(){
        return new Card("Estate","", CardType.VICTORY,0,0,0,0,0,1);
    }


}
