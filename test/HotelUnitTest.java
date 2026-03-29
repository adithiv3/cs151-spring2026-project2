package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import hotel.Hotel;
import hotel.Employee;
import guest.Guest;
import guest.Reservation;
import room.*;
import exception.OverCapacityException;


public class HotelUnitTest {

    @Test
    void testHotelCreation() {
        Hotel hotel = new Hotel("The Hotel");
        
        assertEquals("The Hotel", hotel.getName());
        assertNotNull(hotel.getHotelId());
        // Lists should be empty but not null
        assertNotNull(hotel.getRooms());
        assertEquals(0, hotel.getRooms().size());
    }

    @Test
    void testAddAndRemoveRoom() {
        Hotel hotel = new Hotel("Hotel");
        Room room = new Room("101", "Suite", 4, true);

        hotel.addRoom(room);
        assertEquals(1, hotel.getRooms().size());

        hotel.removeRoom(room);
        assertEquals(0, hotel.getRooms().size());
    }

    @Test
    void testHireEmployee() {
        Hotel hotel = new Hotel("The Resort");
        Employee emp = new Employee("Bob", "Manager", hotel);

        hotel.hireEmployee(emp);
        hotel.hireEmployee(emp); // Adding the same person again

        // Should only be 1 because of contains() in Hotel.java
        assertEquals(1, hotel.getEmployees().size());
    }

    @Test
    void testFindAvailableRoomSuccess() {
        Hotel hotel = new Hotel("Hotel");
        Room room = new Room("102", "Single", 1, true);
        hotel.addRoom(room);

        Room found = hotel.findAvailableRoom("Single", 1);

        assertNotNull(found);
        assertEquals("102", found.getRoomId());
    }

    @Test
    void testFindAvailableRoomWrongType() {
        Hotel hotel = new Hotel("Hotel");
        Room room = new Room("105", "Double", 2, true);
        hotel.addRoom(room);

        Room found = hotel.findAvailableRoom("Single", 1);

        assertNull(found);
    }

    @Test
    void testFindAvailableRoomOverCapacity() {
        Hotel hotel = new Hotel("Hotel");
        Room room = new Room("106", "Single", 1, true); // Capacity is 1
        hotel.addRoom(room);

        Room found = hotel.findAvailableRoom("Single", 3);

        assertNull(found);
    }

    @Test
    void testRegisterGuest() {
        Hotel hotel = new Hotel("Hotel");
        Guest guest = new Guest("Bob", "Silver");

        hotel.registerGuest(guest);
        hotel.registerGuest(guest);

        assertEquals(1, hotel.getGuests().size());
    }

    @Test
    void testAddReservation() {
        Hotel hotel = new Hotel("Grand Plaza");
        Guest guest = new Guest("John", "Basic");
        Room room = new Room("404", "Double", 2, true);
        Reservation res = new Reservation(guest, room, null, null);

        hotel.addReservation(res);

        assertEquals(1, hotel.getReservations().size());
        assertEquals(res, hotel.getReservations().get(0));
    }
}