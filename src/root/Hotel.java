import java.util.ArrayList;

public class Hotel {
    private static int totalHotels = 0;

    String name, address;
    ArrayList<Room> roomList;
    ArrayList<Guest> guestList;
    ArrayList<Employee> employeeList;
    ArrayList<Reservation> reservations;
    public Hotel(String name, String address){
        if (totalHotels >= Main.MAXIMUM_INSTANCES) {
            System.out.println("Error: Maximum number of hotels reached.");
            return;
        }
        totalHotels++;
        this.name = name;
        this.address = address;
        roomList = new ArrayList<Room>(Main.MAXIMUM_INSTANCES);
        guestList = new ArrayList<Guest>(Main.MAXIMUM_INSTANCES);
        employeeList = new ArrayList<Employee>(Main.MAXIMUM_INSTANCES);
        reservations = new ArrayList<Reservation>(Main.MAXIMUM_INSTANCES);
    }
    @Override
    public String toString(){
        return "Hotel name: " + name
                + "\nAddress: " + address
                + "\nNumber of available rooms: " + (Main.MAXIMUM_INSTANCES - roomList.size());
    }
    public void addGuest(Guest g){
        guestList.add(g);
    }
    public void removeGuest(Guest g){
        guestList.remove(g);
    }
    public void addRoom(Room r){
        roomList.add(r);
    }
    public void removeRoom(Room room){
        roomList.remove(room);
    }
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }
    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }
}
