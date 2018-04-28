package dominion.cards;

public abstract class Card {
    private String name;
    private String description;
    private CardType cardType;
    private int cost;
    private int numberOfCopies;


    public Card(String name, String description, CardType cardType, int cost, int numberOfCopies) {
        this.name = name;
        this.description = description;
        this.cardType = cardType;
        this.cost = cost;
        this.numberOfCopies = numberOfCopies;
    }

    public String getName() {
        return name;
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

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
