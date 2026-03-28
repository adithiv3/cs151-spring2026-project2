package src.root;

public abstract class Room {
    private static int idCounter = 100;

    protected int roomId;
    protected double basePrice;
    protected int capacity;
    protected boolean isAvailable;

    public Room(double basePrice, int capacity) {
        this.roomId = generateRoomId();
        setBasePrice(basePrice);
        setCapacity(capacity);
        this.isAvailable = true;
    }

    private int generateRoomId() {
        return idCounter++;
    }

    // 🔥 Business logic
    public boolean canFitGuests(int guests) {
        return guests <= capacity;
    }

    public void markOccupied() {
        isAvailable = false;
    }

    public void markAvailable() {
        isAvailable = true;
    }

    public abstract double calculateNightlyRate();

    public abstract String getRoomType();

    public int getRoomId() {
        return roomId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice > 0) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Base price must be positive");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Capacity must be positive");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId +
                ", Type: " + getRoomType() +
                ", Capacity: " + capacity +
                ", Price: $" + calculateNightlyRate() +
                ", Available: " + isAvailable;
    }
}
