package src.root;

public class DeluxRoom extends Room {
    protected final int PRICE = 200;

    public DeluxRoom(int roomId, int capacity, int price, boolean isAvailable) {
        super(roomId, capacity, isAvailable);
    }

    public int calculateCost() {
        return PRICE;
    }

}
