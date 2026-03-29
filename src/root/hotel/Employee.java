package hotel;

import exception.OverCapacityException;
import guest.Reservation;
import ui.Util;

public class Employee {

    private String employeeID;
    private String name;
    private String role;
    private Hotel assignedHotel;

    private static int nextEmployeeID = 1;
    private static int totalEmployees = 0;

    public Employee(String name, String role, Hotel assignedHotel) {
        if (totalEmployees >= Util.MAXIMUM_INSTANCES) {
            throw new OverCapacityException("Maximum number of employees reached.");
        }
        this.name = name;
        this.role = role;
        this.assignedHotel = assignedHotel;
        this.employeeID = generateEmployeeID();
        totalEmployees++;
    }

    public void checkInGuest(Reservation reservation){
        if (reservation != null && reservation.getOutstandingBalance() == 0) {
            reservation.checkIn();
        } else {
            System.out.println("Check-in denied due to unverified reservation or unpaid balance");
        }
    }

    public void checkOutGuest(Reservation reservation){
        if (reservation != null) {
            reservation.checkOut();
        } else {
            System.out.println("Check-out denied: no reservation found.");
        }
    }

    public String getEmployeeID(){
        return this.employeeID;
    }

    public String getName(){
        return this.name;
    }

    public String getRole(){
        return this.role;
    }

    public Hotel getAssignedHotel(){
        return this.assignedHotel;
    }

    private String generateEmployeeID(){
        return "EMPLOYEE-" + (nextEmployeeID++);
    }

    @Override
    public String toString(){
        return "Employee Name: " + name + " \n ID: " + employeeID + " \n Assigned Hotel: " + assignedHotel.getName() + "\n Role: " + role;
    }

}
