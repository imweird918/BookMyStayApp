import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }

    public void setAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }
}

class FilePersistenceService {
    public void saveInventory(RoomInventory inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public void loadInventory(RoomInventory inventory, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.\n");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    inventory.setAvailability(parts[0], Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("No valid inventory data found. Starting fresh.\n");
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService service = new FilePersistenceService();
        String filePath = "inventory.txt";

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        service.loadInventory(inventory, filePath);

        System.out.println("Current Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double"));
        System.out.println("Suite: " + inventory.getRoomAvailability().get("Suite"));

        service.saveInventory(inventory, filePath);
        System.out.println("Inventory saved successfully.");
    }
}