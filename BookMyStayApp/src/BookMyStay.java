public class BookMyStay {
    public static void main(String[] args){
        Room single_room = new SingleRoom();
        Room double_room = new DoubleRoom();
        Room suite_room = new SuiteRoom();

        System.out.println("Hotel Room Initialization");

        System.out.println("\nSingle Room: ");
        single_room.displayRoomDetails();
        System.out.println("Available: 5");

        System.out.println("\nDouble Room: ");
        double_room.displayRoomDetails();
        System.out.println("Available: 3");

        System.out.println("\nSuite Room: ");
        suite_room.displayRoomDetails();
        System.out.println("Available: 2");
    }
}
abstract class Room{
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;
    public Room(int numberOfBeds, int squareFeet, double pricePerNight){
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }
    public void displayRoomDetails(){
        System.out.println("Beds: "+numberOfBeds);
        System.out.println("Size: "+squareFeet+" sqft");
        System.out.println("Price per Night: "+pricePerNight);
    }
}

class SingleRoom extends Room{
    public SingleRoom(){
        super(1,250,1500.0);
    }
}

class DoubleRoom extends Room{
    public DoubleRoom(){
        super(2,400,2500.0);
    }
}

class SuiteRoom extends Room{
    public SuiteRoom(){
        super(3,750,5000.0);
    }
}

