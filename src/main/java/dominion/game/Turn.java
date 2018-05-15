package dominion.game;

public class Turn {
    private int treasurePoints;
    private int actionPoints;
    private int buyPoints;



    public Turn() {
        this.treasurePoints = 0 ;
        this.actionPoints = 1;
        this.buyPoints = 1;

    }

    public int getTreasurePoints() {
        return treasurePoints;
    }

    public void addTreasurePoints(int treasurePoints) {
        this.treasurePoints += treasurePoints;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public int getBuyPoints() {
        return buyPoints;
    }

    public void setBuyPoints(int buyPoints) {
        this.buyPoints = buyPoints;
    }
}
