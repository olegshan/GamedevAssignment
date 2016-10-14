package players;

/**
 * Created by olegshan on 14.10.2016.
 */
public class Player {
    private String name;
    private double rating;

    public Player(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
