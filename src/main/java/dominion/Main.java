package dominion;

import dominion.game.Game;


public class Main {

    public static void main(String[] args) {

        //Testing game: dealing a new game with 4 players.

        Game game = new Game(4);
        System.out.println("Welcome to new Dominion with " + game.getNumberOfPlayers() + " players!");
        game.newGame();

        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            System.out.println("Player " + i + ": ");
            for (int j = 0; j < game.getListOfPlayers().get(i).handDeck.size(); j++) {
                System.out.println(game.getListOfPlayers().get(i).handDeck.get(j).getName());

            }



        }
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            System.out.println("Player " + i + ": ");
            for (int j = 0; j < game.getListOfPlayers().get(i).handDeck.size(); j++) {
                System.out.println(game.getListOfPlayers().get(i).handDeck.get(j).getName());

            }



        }






    }
}
