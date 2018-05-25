package dominion.cards.victoryCards;

import dominion.cards.Card;
import dominion.cards.CardType;

import dominion.player.Player;

public class Duchy extends Victory {
    private int victoryPoints;
    public Duchy() {
        super("Duchy","",2,CardType.VICTORY);
        this.victoryPoints = 3;
    }

    @Override
    public int getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void activate(Player player){}

}
