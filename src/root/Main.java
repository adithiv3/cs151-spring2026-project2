import hotel.Employee;
import hotel.Hotel;
import room.DoubleRoom;
import room.SingleRoom;
import room.SuiteRoom;
import ui.HotelSystemUI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hotel> hotels = new ArrayList<>();

        Hotel grandHilton = new Hotel("Grand Hilton");
        grandHilton.addRoom(new SingleRoom(100.0));
        grandHilton.addRoom(new SingleRoom(100.0));
        grandHilton.addRoom(new SingleRoom(100.0));
        grandHilton.addRoom(new DoubleRoom(150.0));
        grandHilton.addRoom(new DoubleRoom(150.0));
        grandHilton.addRoom(new SuiteRoom(300.0));
        grandHilton.addRoom(new SuiteRoom(300.0));
        Employee hiltonManager = new Employee("Alice", "Manager", grandHilton);
        grandHilton.hireEmployee(hiltonManager);
        Employee hiltonFrontDesk = new Employee("Alex", "Front Desk", grandHilton);
        grandHilton.hireEmployee(hiltonFrontDesk);
        hotels.add(grandHilton);

        Hotel seasideResort = new Hotel("Seaside Resort");
        seasideResort.addRoom(new SingleRoom(120.0));
        seasideResort.addRoom(new DoubleRoom(180.0));
        seasideResort.addRoom(new DoubleRoom(180.0));
        seasideResort.addRoom(new SuiteRoom(350.0));
        Employee resortManager = new Employee("Bob", "Manager", seasideResort);
        seasideResort.hireEmployee(resortManager);
        Employee resortHousekeeper = new Employee("Carol", "Housekeeping", seasideResort);
        seasideResort.hireEmployee(resortHousekeeper);
        hotels.add(seasideResort);

        HotelSystemUI ui = new HotelSystemUI(hotels);
        ui.start();
    }
}
