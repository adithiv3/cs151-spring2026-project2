public class Client{

    private String name;
    private String room;
    private boolean hasParking;
    private String membership;
    private double duration; // in hours

    public void setDuration(double duration){
        this.duration = duration;
    }

    public double getDuration(){
        return duration;
    }

    public void setParking(boolean parking){ // when user first registers
        hasParking = parking;
    }

    public boolean getParking(){ // if user wants to upgrade
        return hasParking;
    }

    public void upgradeMembershipTo(String membership){
        this.membership = membership;
    }

    public void addParking(){
        hasParking = true;
    }

    public void extendStay(int hours){
        duration += hours;
    }
}