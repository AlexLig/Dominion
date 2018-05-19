package dominion.game;

import java.util.List;

public class Tools {

    public static void moveStringCards(String card, int times, List<String> fromHere, List<String> toHere) {
        for (int i = 0; i < times; i++) {
            toHere.add(card);
            fromHere.remove(card);
        }
    }
    public static void addStringCard(String card, int times, List<String> toHere) {
        for (int i = 0; i < times; i++) {
            toHere.add(card);
        }
    }


}
