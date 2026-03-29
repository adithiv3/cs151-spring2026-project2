package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import hotel.Hotel;
import hotel.Employee;
import guest.Guest;
import guest.Reservation;
import room.*;
import exception.OverCapacityException;


public class ReservationUnitTest {

    @Test
    void testReservationCreation() {
        Guest guest = new Guest("John", "Alice");
        Room room = new DoubleRoom(150.0);
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = LocalDate.now().plusDays(3);

        Reservation res = new Reservation(guest, room, checkIn, checkOut);

        assertEquals(guest, res.getGuest());
        assertEquals(room, res.getRoom());
        assertEquals(100.0, res.getOutstandingBalance());
        assertFalse(res.isCancelled());
    }

    @Test
    void testCheckIn() {
        Guest guest = new Guest("Alice", "Gold");
        Room room = new SingleRoom(100.0);
        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(1));

        res.checkIn();

        assertTrue(res.isCheckedIn());
        assertFalse(res.isCheckedOut());
    }

    @Test
    void testCheckOut() {
        Guest guest = new Guest("Alice", "Gold");
        Room room = new SingleRoom(100.0);
        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(1));

        res.checkOut();

        assertTrue(res.isCheckedOut());
    }

    @Test
    void testCancelReservation() {
        Guest guest = new Guest("Jon", "Gold");
        Room room = new DoubleRoom(200.0);
        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(2));

        res.cancelReservation();

        assertTrue(res.isCancelled());
    }

    @Test
    void testAddCharge() {
        Guest guest = new Guest("Bob", "Gold");
        Room room = new SuiteRoom(300.0);
        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(5));

        // Initial balance is 100.0, adding 50.0
        res.addCharge(50.0, "Wine");

        assertEquals(150.0, res.getOutstandingBalance());
    }

    @Test
    void testProcessPayment() {
        Guest guest = new Guest("Gold", "John");
        Room room = new SuiteRoom(350.0);
        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(2));

        // Initial balance is 100.0, paying 40.0
        res.processPayment(40.0);

        assertEquals(60.0, res.getOutstandingBalance());
    }

    @Test
    void testToString() {
        Guest guest = new Guest("Bob", "Basic");
        Room room = new SingleRoom(100.0);
        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(1));

        String details = res.toString();

        assertTrue(details.contains("RESERVATION-"));
        assertTrue(details.contains("Sam"));
        assertTrue(details.contains("105"));
    }

    @Test
    void testMaxReservationLimit() {
        Guest guest = new Guest("LimitTester", "Basic");
        Room room = new SingleRoom(100.0);
        
        try {
            for (int i = 0; i < 100; i++) {
                new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(1));
            }
        } catch (Exception e) {
            fail("Should not fail before hitting 100.");
        }

        // The 101st reservation
        boolean caught = false;
        try {
            new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(1));
        } catch (OverCapacityException e) {
            caught = true;
        }
        
        assertTrue(caught, "Should throw OverCapacityException at 101st reservation");
    }
}