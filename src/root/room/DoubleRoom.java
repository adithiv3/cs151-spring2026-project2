package room;

public class DoubleRoom extends Room {

    public DoubleRoom(double basePrice) {
        super(basePrice, 2);
    }

    @Override
    public double calculateNightlyRate() {
        return basePrice * 1.2;
    }

    @Override
    public String getRoomType() {
        return "Double Room";
    }
}
