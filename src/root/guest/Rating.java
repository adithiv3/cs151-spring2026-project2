package guest;

public class Rating {
    private String guestName;
    private int stars;

    public Rating(String guestName, int stars) {
        this.guestName = guestName;
        this.stars = Math.max(1, Math.min(5, stars));
    }

    public String getGuestName() {
        return guestName;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return "[" + stars + "/5] by " + guestName;
    }
}
