package src.root;

public class RegularRoom extends Room {
    protected final int PRICE = 100;

    public RegularRoom(int roomId, int capacity, int price, boolean isAvailable) {
        super(roomId, capacity, isAvailable);
    }

    public int calculateCost() {
        return this.PRICE;
    }
}
