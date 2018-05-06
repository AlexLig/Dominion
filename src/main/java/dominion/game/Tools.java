package dominion.game;

import dominion.cards.Card;

import java.util.List;
import java.util.Stack;

public class Tools {

    public static Card findCardByName(String name, Iterable<Card> deck) {
        Card theCard = null;
        for (Card temp : deck) {
            if (temp.getName().equals(name)) {
                theCard = temp;
            }
        }
        return theCard;
    }

    public static void addCardToDeck(int times, Card card, List<Card> toThisDeck) {

        for (int i = 0; i < times; i++) {
            toThisDeck.add(card);
        }

    }

    public static void addCardByNameToDeck(int times, String name, Iterable<Card> fromThisDeck, List<Card> toThisDeck) {
        addCardToDeck(times, findCardByName(name, fromThisDeck), toThisDeck);

    }

    public static void drawCardsFromDeck(int numberOfCards, Stack<Card> fromThisDeck, List<Card> toThisDeck) {

        for (int i = 0; i < numberOfCards; i++) {
            toThisDeck.add(fromThisDeck.pop());
        }
    }

    public static void moveCardToDeck(Card card, List<Card> fromThisDeck, List<Card> toThisDeck) {
        toThisDeck.add(card);
        fromThisDeck.remove(card);
    }

    public static int countCardInDeck(Card card, Iterable<Card> deck) {
        int count = 0;
        for (Card tempCard:deck){
            if(tempCard.getName() == card.getName()){
                count++;
            }
        }
        return count;
    }

}
