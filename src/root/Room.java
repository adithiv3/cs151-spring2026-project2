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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean status) {
        this.isAvailable = status;
    }

    public abstract int calculateCost();

    public abstract String getRoomType();

    public String getRoomId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomId'");
    }

}
