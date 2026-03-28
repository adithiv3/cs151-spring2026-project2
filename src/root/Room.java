public abstract class Room {
    private static final int ROOMS_PER_FLOOR = 25;
    private static int totalRooms = 0;

    protected String roomId;
    protected double basePrice;
    protected int capacity;
    protected boolean isAvailable;

    public Room(double basePrice, int capacity) {
        if (totalRooms >= Main.MAXIMUM_INSTANCES) {
            System.out.println("Error: Maximum number of rooms reached.");
            return;
        }
        this.roomId = generateRoomId();
        totalRooms++;
        setBasePrice(basePrice);
        setCapacity(capacity);
        this.isAvailable = true;
    }

    private String generateRoomId() {
        int floor = (totalRooms / ROOMS_PER_FLOOR) + 1;
        int roomOnFloor = totalRooms % ROOMS_PER_FLOOR;
        int number = floor * 100 + roomOnFloor;
        return "ROOM-" + number;
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

    public String getRoomId() {
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
