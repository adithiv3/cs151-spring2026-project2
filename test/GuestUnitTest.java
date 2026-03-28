package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class GuestUnitTest {

    // This test will test my constructor
    @Test
    void testGuestCreation() {
        Guest john = new Guest("John", "Gold");

        assertEquals("John", john.getName());
        assertEquals("Gold", john.getMembershipLevel());
        assertEquals(0.0, john.getOutstandingBalance());
        assertNotNull(john.getGuestId());
    }

    // This test will test adding a charge
    @Test
    void testAddCharge() {
        Guest alice = new Guest("Alice", "Basic");

        alice.addCharge(50.0, "Room Service");

        assertEquals(50.0, alice.getOutstandingBalance());
    }

    // This test will test processing a payment
    @Test
    void testProcessPayment() {
        Guest bob = new Guest("Bob", "Silver");

        bob.addCharge(100.0, "Dinner");
        bob.processPayment(40.0);

        assertEquals(60.0, bob.getOutstandingBalance());
    }

    // This test will test overpaying
    @Test
    void testOverPayment() {
        Guest gigi = new Guest("Gigi", "Basic");

        gigi.addCharge(80.0, "Mini Bar");
        gigi.processPayment(100.0); // overpay

        assertEquals(0.0, gigi.getOutstandingBalance());
    }

    // This test will test our reservation function
    @Test
    void testReserveRoomSuccess() {
        Hotel hotel = new Hotel("Test Hotel");

        Room room = new SingleRoom(100, 2, true);
        hotel.addRoom(room);

        Guest david = new Guest("David", "Gold");

        Reservation res = david.reserveRoom(
                hotel,
                room.getRoomType(),
                1,
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        assertNotNull(res);
        assertEquals(david, res.getGuest());
    }

    // This test will test failing to reserve a room 
    @Test
    void testReserveRoomFail() {
        Hotel hotel = new Hotel("Empty Hotel");

        Guest eve = new Guest("Eve", "Basic");

        assertThrows(RoomUnavailableException.class, () -> {
            eve.reserveRoom(
                    hotel,
                    "Single",
                    1,
                    LocalDate.now(),
                    LocalDate.now().plusDays(2)
            );
        });
    }

    // This test will test canceling our reservation
    @Test
    void testCancelReservation() {
        Hotel hotel = new Hotel("Test Hotel");

        Room room = new SingleRoom(100, 2, true);
        hotel.addRoom(room);

        Guest frank = new Guest("Frank", "Gold");

        frank.reserveRoom(
                hotel,
                room.getRoomType(),
                1,
                LocalDate.now(),
                LocalDate.now().plusDays(2)
        );

        frank.cancelCurrentReservation();

        assertNull(frank.getCurrentReservation());
    }

    // This will test inputing an invalid date
    @Test
    void testInvalidDateRange() {
        Hotel hotel = new Hotel("Test Hotel");

        Guest grace = new Guest("Grace", "Basic");

        assertThrows(InvalidDateRangeException.class, () -> {
            grace.reserveRoom(
                    hotel,
                    "Single",
                    1,
                    LocalDate.now(),
                    LocalDate.now().minusDays(1) // invalid
            );
        });
    }

    // This test will test exceeding room capacity
    @Test
    void testOverCapacity() {
        Hotel hotel = new Hotel("Test Hotel");

        Room room = new SingleRoom(100, 1, true); // capacity = 1
        hotel.addRoom(room);

        Guest henry = new Guest("Henry", "Basic");

        assertThrows(OverCapacityException.class, () -> {
            henry.reserveRoom(
                    hotel,
                    room.getRoomType(),
                    3, // too many guests
                    LocalDate.now(),
                    LocalDate.now().plusDays(2)
            );
        });
    }
}
