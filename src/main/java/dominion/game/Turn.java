package dominion.game;

public class Turn {
    private int treasurePoints;
    private int numberOfActions;
    private int numberOfBuys;



    public Turn() {
        this.treasurePoints = 0 ;
        this.numberOfActions = 1;
        this.numberOfBuys = 1;

    }

    public int getTreasurePoints() {
        return treasurePoints;
    }

    public void addTreasurePoints(int treasurePoints) {
        this.treasurePoints += treasurePoints;
    }

    public int getNumberOfActions() {
        return numberOfActions;
    }

    public void setNumberOfActions(int numberOfActions) {
        this.numberOfActions = numberOfActions;
    }

    public int getNumberOfBuys() {
        return numberOfBuys;
    }

    public void setNumberOfBuys(int numberOfBuys) {
        this.numberOfBuys = numberOfBuys;
    }
}
