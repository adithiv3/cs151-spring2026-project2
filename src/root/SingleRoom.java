package src.root;

public class SingleRoom extends Room {

    public SingleRoom(double basePrice) {
        super(basePrice, 1);
    }

    @Override
    public double calculateNightlyRate() {
        return basePrice; // no extra cost
    }

    @Override
    public String getRoomType() {
        return "Single Room";
    }
}