package room;

public class SuiteRoom extends Room {

    public SuiteRoom(double basePrice) {
        super(basePrice, 4);
    }

    @Override
    public double calculateNightlyRate() {
        return basePrice * 1.5;
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}
