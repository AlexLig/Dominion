package dominion.cards;

public class Victory extends Card {
    private int victoryPoints;

    public Victory(String name, String description, CardType cardType, int cost, int numberOfCopies, int victoryPoints) {
        super(name, description, cardType, cost, numberOfCopies);
        this.victoryPoints = victoryPoints;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }
}
