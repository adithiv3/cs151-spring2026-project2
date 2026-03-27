package src.root;

public abstract class Room {
    protected int roomId;
    protected int capacity;
    protected boolean isAvailable;

    public Room(int roomId, int capacity, boolean isAvailable) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }

    public void bookRoom() {
        this.isAvailable = false;
    }

    public void vacateRoom() {
        this.isAvailable = true;
    }

    public abstract int calculateCost();
}
