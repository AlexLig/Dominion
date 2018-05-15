package dominion.game;

import java.util.ArrayList;
import java.util.Stack;

public class PlayerState {
    private Stack<String> deck;
    private ArrayList<String> hand;
    private ArrayList<String> discard;
    private Turn turn;

    public PlayerState() {
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.turn = new Turn();
    }

    public Stack<String> getDeck() {
        return deck;
    }

    public void setDeck(Stack<String> deck) {
        this.deck = deck;
    }

    public ArrayList<String> getHand() {
        return hand;
    }

    public void setHand(ArrayList<String> hand) {
        this.hand = hand;
    }

    public ArrayList<String> getDiscard() {
        return discard;
    }

    public void setDiscard(ArrayList<String> discard) {
        this.discard = discard;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
}
