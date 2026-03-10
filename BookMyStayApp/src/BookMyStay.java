import java.util.HashMap;
import java.util.Map;

public class BookMyStay {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status");
        System.out.println("===========================");

        displayRoomStatus("Single Room", 1, 250, 1500.0, inventory);

        displayRoomStatus("Double Room", 2, 400, 2500.0, inventory);

        displayRoomStatus("Suite Room", 3, 750, 5000.0, inventory);
    }

    private static void displayRoomStatus(String name, int beds, int size, double price, RoomInventory inv) {
        Integer available = inv.getRoomAvailability().get(name);
        System.out.println(name + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available Rooms: " + (available != null ? available : 0));
        System.out.println();
    }
}


class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        // Data derived from the "Hotel Room Inventory Status" report
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }


    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

