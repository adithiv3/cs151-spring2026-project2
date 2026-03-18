import java.util.ArrayList;

public class Hotel {
    String name, address;
    ArrayList<Room> roomList;
    ArrayList<Guest> guestList;
    ArrayList<Employee> employeeList;
    ArrayList<Reservation> reservations;
    public Hotel(String name, String address){
        this.name = name;
        this.address = address;
        roomList = new ArrayList<Room>(100);
        guestList = new ArrayList<Guest>(100);
        employeeList = new ArrayList<Employee>(100);
        reservations = new ArrayList<Reservation>(100);
    }
    @Override
    public String toString(){
        return "Hotel name: " + name
                + "\nAddress: " + address
                + "\nNumber of available rooms: " + (100 - roomList.size());
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
