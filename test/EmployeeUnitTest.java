package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class EmployeeUnitTest {

    @Test
    void testEmployeeCreation() {
        Hotel hotel = new Hotel("Hotel");
        Employee emp = new Employee("Alice", "Receptionist", hotel);

        assertEquals("Alice", emp.getName());
        assertEquals("Receptionist", emp.getRole());
        assertEquals(hotel, emp.getAssignedHotel());

        assertTrue(emp.getEmployeeID().contains("EMPLOYEE-"));
    }

    @Test
    void testCreateReservationSuccess() {
        Hotel hotel = new Hotel("Hotel");
        Employee emp = new Employee("Bob", "Receptionist", hotel);
        Guest guest = new Guest("John", "Gold");
        Room room = new Room("101", "Single", 1, true);

        Reservation res = emp.createReservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(2));

        assertNotNull(res);
        assertEquals(guest, res.getGuest());
    }

    @Test
    void testCreateReservationRoomUnavailable() {
        Hotel hotel = new Hotel("Hotel");
        Employee emp = new Employee("Bob", "Receptionist", hotel);
        Guest guest = new Guest("John", "Gold");
        Room room = new Room("101", "Single", 1, false);

        Reservation res = emp.createReservation(
            guest, 
            room, 
            LocalDate.now(), 
            LocalDate.now().plusDays(2)
        );

        assertNull(res);
    }

    @Test
    void testAssignCleaningHousekeeping() {
        Hotel hotel = new Hotel("Hotel");
        Employee cleaner = new Employee("John", "Housekeeping", hotel);
        Room room = new Room("102", "Double", 2, true);

        cleaner.assignRoomForClening(room);
        assertEquals("Housekeeping", cleaner.getRole());
    }

    @Test
    void testAssignCleaningDenied() {
        Hotel hotel = new Hotel("Hotel");
        Employee receptionist = new Employee("Dave", "Receptionist", hotel);
        Room room = new Room("103", "Suite", 4, true);

        receptionist.assignRoomForClening(room);
        assertNotEquals("Housekeeping", receptionist.getRole());
        assertNotEquals("Manager", receptionist.getRole());
    }

    @Test
    void testCheckInDeniedUnpaidBalance() {
        Hotel hotel = new Hotel("Hotel");
        Employee emp = new Employee("Alice", "Receptionist", hotel);
        Guest guest = new Guest("John", "Gold");
        Room room = new Room("104", "Single", 1, true);
        
        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(1));
        
        // Manually add a charge to create an outstanding balance
        res.addCharge(100.0, "Service Fee"); 
        
        emp.checkInGuest(res);
        // Balance is 100 so checkIn should not have been called/successful
        assertTrue(res.getOutstandingBalance() > 0);
    }

    @Test
    void testOverCapacity(){
        Hotel hotel = new Hotel("Limit Hotel");
        try {
            for (int i = 0; i < 100; i++) {
                new Employee("Staff " + i, "Receptionist", hotel);
            }
        } catch (OverCapacityException e) {
            fail("Should not have hit the limit before 100 employees.");
     }
        boolean caughtExpectedError = false;
        try {
         new Employee("The Extra Person", "Manager", hotel);
        } catch (OverCapacityException e) {
           caughtExpectedError = true;
        }
         assertTrue(caughtExpectedError, "Should have triggered an OverCapacityException");
    }        
}