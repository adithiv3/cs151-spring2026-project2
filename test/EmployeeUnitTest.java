package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import hotel.Hotel;
import hotel.Employee;
import guest.Guest;
import guest.Reservation;
import room.*;
import exception.OverCapacityException;


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
        Guest guest = new Guest("John", "Gold");
        Room room = new SingleRoom(100.0);

        Reservation res = new Reservation(guest, room, LocalDate.now(), LocalDate.now().plusDays(2));

        assertNotNull(res);
        assertEquals(guest, res.getGuest());
    }

    @Test
    void testCheckInDeniedUnpaidBalance() {
        Hotel hotel = new Hotel("Hotel");
        Employee emp = new Employee("Alice", "Receptionist", hotel);
        Guest guest = new Guest("John", "Gold");
        Room room = new SingleRoom(100.0);
        
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