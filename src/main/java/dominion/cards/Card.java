package dominion.cards;


import dominion.game.Game;
import dominion.player.Player;

public abstract class  Card {
    private String name;
    private String description;
    private int cost;
    private CardType cardType;
    protected CardEffects cardEffects;




    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public Card(String name, String description, int cost, CardType cardType) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.cardType = cardType;
        this.cardEffects = new CardEffects();

    }



    public int getVictoryPoints(){
        return 0;
    }

    public CardType getCardType() {
        return cardType;
    }


    public final void doPlayCard(Player player){

        if (canBePlayed(player)){
            activate(player);
            discardCard(player);
            cardReport(player);
        }

    }
    protected abstract boolean canBePlayed(Player player);
    protected abstract void activate(Player player);
    protected final void discardCard(Player player){
        player.getDiscard().add(name);
        player.getHand().remove(name);
    }
    protected final void cardReport(Player player){
        System.out.println("Player " + player.getId() + ": played " + name +" card");
    }
}
