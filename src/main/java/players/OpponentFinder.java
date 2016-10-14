package players;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olegshan on 14.10.2016.
 */
public class OpponentFinder {

    private List<Player> readyPlayers = new ArrayList<>();

    public void addPlayer(Player player) {
        readyPlayers.add(player);
    }

    public Player findOpponent(Player player) {
        if (readyPlayers.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("There are no players ready to play");
        }
        Player opponent = readyPlayers.get(0);
        double playerRating = player.getRating();
        double minDifference = getDifference(playerRating, opponent.getRating());

        for (Player p : readyPlayers) {
            double currentDifference = getDifference(playerRating, p.getRating());
            if (currentDifference <= minDifference) {
                opponent = p;
                minDifference = currentDifference;
            }
        }
        readyPlayers.remove(opponent);
        return opponent;
    }

    private double getDifference(double thisRating, double anotherRating) {
        return Math.abs(thisRating - anotherRating);
    }

    //added for testing purposes
    int playersCount() {
        return readyPlayers.size();
    }

}
