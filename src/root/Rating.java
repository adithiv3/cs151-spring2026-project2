public class Rating {
    private String guestName;
    private int stars;
    private String description;

    public Rating(String guestName, int stars, String description) {
        this.guestName = guestName;
        this.stars = Math.max(1, Math.min(5, stars));
        this.description = description;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + stars + "/5] by " + guestName + ": " + description;
    }
}
