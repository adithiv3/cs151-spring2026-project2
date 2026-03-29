package hotel;

import guest.Guest;
import guest.Rating;
import guest.Reservation;
import room.Room;
import ui.Util;

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
    private List<Rating> ratings;

    public Hotel(String name) {
        this.name = name;
        this.hotelId = generateHotelId();
        this.rooms = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.ratings = new ArrayList<>();
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

    public Guest findGuestById(String id) {
        for (Guest g : guests) {
            if (g.getGuestId().equalsIgnoreCase(id)) return g;
        }
        return null;
    }

    public Employee findEmployeeById(String id) {
        for (Employee e : employees) {
            if (e.getEmployeeID().equalsIgnoreCase(id)) return e;
        }
        return null;
    }

    public Reservation findReservationById(String id) {
        for (Reservation r : reservations) {
            if (r.getReservationId().equalsIgnoreCase(id)) return r;
        }
        return null;
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

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0;
        int sum = 0;
        for (Rating r : ratings) sum += r.getStars();
        return (double) sum / ratings.size();
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeRoom(Room room) {
        if (!rooms.remove(room)) {
            System.out.println("Room " + room.getRoomId() + " not found in " + name + ".");
        }
    }

    public void removeEmployee(Employee employee) {
        if (!employees.remove(employee)) {
            System.out.println("Employee " + employee.getEmployeeID() + " not found in " + name + ".");
        }
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
                + " |Name: " + name
                + " |Available Rooms: " + (Util.MAXIMUM_INSTANCES - rooms.size())
                + " |Guests: " + guests.size()
                + " |Employees: " + employees.size()
                + " |Reservations: " + reservations.size();
    }
}
