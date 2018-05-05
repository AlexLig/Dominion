package dominion.game;


import java.util.ArrayList;

public class Game {
    private ArrayList<Player> player;

    public Game(int numberOfPlayers) {
        this.player = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            player.add(new Player());
        }
    }

    public ArrayList<Player> getPlayer() {
        return player;
    }
}
