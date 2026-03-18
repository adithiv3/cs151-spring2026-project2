import java.util.ArrayList;

public class Hotel {
    String name, address;
    ArrayList<Room> roomList;
    ArrayList<Guest> guessList;
    ArrayList<Employee> employeeList;
    public Hotel(String name, String address){
        this.name = name;
        this.address = address;
        roomList = new ArrayList<Room>(100);
        guessList = new ArrayList<Guest>();
        employeeList = new ArrayList<Employee>();
    }
    @Override
    public String toString(){
        return "Hotel name: " + name
                + "\nAddress: " + address
                + "\nNumber of available rooms: " + (100 - roomList.size());
    }
}
