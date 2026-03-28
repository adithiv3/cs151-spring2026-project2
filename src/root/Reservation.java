import java.time.LocalDate;

public class Reservation {
    private String reservationID;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean cancelled;
    private double outstandingBalance;
    private static int nextReservationId = 1; // Used for generateReservationID()
    private static int totalReservations = 0;

    public Reservation( Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate){
        if (totalReservations >= Main.MAXIMUM_INSTANCES) {
            System.out.println("Error: Maximum number of reservations reached.");
            return;
        }
        totalReservations++;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.cancelled = false;
        this.reservationID = generateReservationID();
        this.outstandingBalance = calculateTotalCharge();
    }

    public void confirmReservation(){
        System.out.println("Reservation " + reservationID + " confirmed.");
    }

    public void cancelReservation(){
        this.cancelled = true;
        System.out.println("Reservation " + reservationID + " cancelled.");
    }

    public void checkIn(){
        if (!cancelled)
            System.out.println("Guest checked in.");
    }

    public void checkOut(){
        if (outstandingBalance == 0)
            System.out.println("Guest checked out.");
        else
            System.out.println("Cannot checkout: Balance remaining.");
    }

    public double calculateTotalCharge(){
        return 100.0;
    }

    public void addCharge (double amount, String reason){
        if (amount > 0)
            outstandingBalance += amount;
    }

    public void processPayment (double amount){
        outstandingBalance -= amount;
    }

    public double getOutstandingBalance(){
        return outstandingBalance;
    }
    
    public String getReservationId(){
        return reservationID;
    }

    private String generateReservationID(){
        return "RESERVATION-" + (nextReservationId++);
    }

    public LocalDate getDueDate(){
        return checkOutDate;
    }
}
