public class Guest extends User{
	
	private Reservation reservation;
	private Room room;
	private int loyaltyPoint;
	
	public Guest(String name) {
		super(name);
		loyaltyPoint = 0;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	
	public Room getRoom() {
		return(room);
	}
	
	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}
	
}
