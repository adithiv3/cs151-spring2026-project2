package src.root;

public class Guest extends User {

	private Reservation reservation;
	private Room room;
	private int loyaltyPoint;

	public Guest(String name) {
		super(name);
		loyaltyPoint = 0;
	}

	
	// Getter methods
	public Reservation getReservation() {
		return reservation;
	}

	public Room getRoom() {
		return (room);
	}

	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}

	
	// Main/core functions
	public void addLoyaltyPoint(int additionalPoints) {
		this.loyaltyPoint += additionalPoints;
	}

	public void reserveRoom(Room room, int days) {
		if (room == null) {
            System.out.println("Invalid room.");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Room is already booked!");
            return;
        }

        this.room = room;
        this.reservation = new Reservation(room, days);

        room.setAvailability(false);

        System.out.println("Room reserved: " + room.getRoomType());
    }
	
	public void addCharge(double amount) {
		if (reservation != null) {
			reservation.addCharge(amount);
			System.out.println("Charge has been added: $" + amount);
		} else {
			System.out.println("Need reservation first!");
		}
	}
	
	public void cancelReservation() {
		if(reservation == null) {
			System.out.println("There is no reservation to cancel");
			return;
		}
		
		reservation.cancel();
		room.vacateRoom();
		
		System.out.println("Reservation has been cancelled");
	}
	
	public void extendStay(int extraDays) {
		if(reservation == null) {
			System.out.println("There is no reservation to extend");
			return;
		}
		
		reservation.extend(extraDays);
		System.out.println("Stay has been extended by " + extraDays + " days.");
		
	}
	
	public void pay() {
		if(reservation == null) {
			System.out.println("There is no reservation to pay for");
			return;
		}
		
		double total = reservation.calculateTotal();
		System.out.println("Payment successful: $" + total);
		
		loyaltyPoint += 10;

		
	}
	
	public void viewReservation() {
		if (reservation == null) {
			System.out.println("There is no reservation");
        } else {
            System.out.println(reservation);
        }
	}
	
	// Now we create our override methods
	@Override
	public void displayRole() {
		System.out.println("Guest User");
	}
	
	@Override
	public String toString() {
		String message = ("Guest: " + name + " | Loyalty Points: " + loyaltyPoint);
	}

}
