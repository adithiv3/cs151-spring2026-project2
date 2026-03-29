import java.time.LocalDate;

public class Employee {

    private String employeeID;
    private String name;
    private String role;
    private Hotel assignedHotel;

    // to handle ID number generation
    private static int nextEmployeeID = 1;
    private static int totalEmployees = 0;

    public Employee(String name, String role, Hotel assignedHotel) {
        if (totalEmployees >= Main.MAXIMUM_INSTANCES) {
           throw new OverCapacityException("Maximum number of employees reached.");
            return;
        }
        this.name = name;
        this.role = role;
        this.assignedHotel = assignedHotel;
        this.employeeID = generateEmployeeID();
        totalEmployees++;
    }

    public Reservation createReservation(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut){
        if (room.isAvailable()){
            Reservation reservation = new Reservation(guest, room, checkIn, checkOut);
            System.out.println("Reservation " + reservation.getReservationId() + "created");
            return reservation;
        }
        System.out.println("Reservation failed.");
        return null;
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

    public void assignRoomForClening(Room room){
        if (this.role.equalsIgnoreCase("Manager") || this.role.equalsIgnoreCase("Housekeeping")){
            System.out.println("Room " + room.getRoomId() + " is assigned for cleaning to " + this.name);            
        }
        else {
            System.out.println("Access Denied: Role '" + this.role + "' cannot assign cleaning tasks.");
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