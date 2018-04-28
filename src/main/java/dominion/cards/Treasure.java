package dominion.cards;

public class Treasure extends Card {
    private int treasurePoints;

    public Treasure(String name, String description, CardType cardType, int cost, int numberOfCopies, int treasurePoints) {
        super(name, description, cardType, cost, numberOfCopies);
        this.treasurePoints = treasurePoints;
    }


    public int getTreasurePoints() {
        return treasurePoints;
    }
}
