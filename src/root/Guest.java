package src.root;
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
		
	public void addLoyaltyPoint(int additionalPoints) {
		this.loyaltyPoint += additionalPoints;
	}
	
	public void reserveRoom(Room room) {
		this.room = room;
		this.reservation = new Reservation(room);
		System.out.println("Room reserved: " + room.getRoomType());
	}
	
	public void addCharge(double amount) {
		if(reservation != null) {
			reservation.addCharge(amount);
			System.out.println("Charge has been added: $" + amount);
		} else {
			System.out.println("Need reservation first!");
		}
	}
		
	

}
