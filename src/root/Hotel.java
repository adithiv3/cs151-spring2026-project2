import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private static int nextHotelId = 1;

    private String hotelId;
    private String name;
    private List<Room> rooms;
    private List<Guest> guests;
    private List<Employee> employees;
    private List<Reservation> reservations;

    public Hotel(String name) {
        this.name = name;
        this.hotelId = generateHotelId();
        this.rooms = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void registerGuest(Guest guest) {
        if (guests.contains(guest)) {
            System.out.println("Guest " + guest.getName() + " is already registered.");
            return;
        }
        guests.add(guest);
    }

    public void hireEmployee(Employee employee) {
        if (employees.contains(employee)) {
            System.out.println("Employee " + employee.getEmployeeID() + " is already hired.");
            return;
        }
        employees.add(employee);
    }

    public Room findAvailableRoom(String roomType, int guestCount) {
        for (Room room : rooms) {
            if (room.isAvailable()
                    && room.getRoomType().equalsIgnoreCase(roomType)
                    && room.canFitGuests(guestCount)) {
                return room;
            }
        }
        return null;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    private String generateHotelId() {
        return "HOTEL-" + (nextHotelId++);
    }

    @Override
    public String toString() {
        return "Hotel ID: " + hotelId
                + "\nName: " + name
                + "\nAvailable Rooms: " + (Main.MAXIMUM_INSTANCES - rooms.size())
                + "\nGuests: " + guests.size()
                + "\nEmployees: " + employees.size()
                + "\nReservations: " + reservations.size();
    }
}
