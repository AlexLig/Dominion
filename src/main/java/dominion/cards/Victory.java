package dominion.cards;

public class Victory extends Card {
    private int victoryPoints;

    public Victory(String name, String description, int cost, int victoryPoints) {
        super(name, description, cost);
        this.victoryPoints = victoryPoints;
    }

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }
}
