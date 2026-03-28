package src.root;

public class SuiteRoom extends Room {

    public SuiteRoom(double basePrice) {
        super(basePrice, 4);
    }

    @Override
    public double calculateNightlyRate() {
        return basePrice * 1.5; // premium pricing
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}
