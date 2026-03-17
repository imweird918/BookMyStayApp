import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Service {
    private String serviceName;
    private double cost;

    public Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() { return serviceName; }
    public double getCost() { return cost; }
}

class AddOnServiceManager {
    private Map<String, List<Service>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        double total = 0.0;
        if (servicesByReservation.containsKey(reservationId)) {
            for (Service service : servicesByReservation.get(reservationId)) {
                total += service.getCost();
            }
        }
        return total;
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection");

        AddOnServiceManager manager = new AddOnServiceManager();
        manager.addService("Single-1", new Service("Spa", 1000.0));
        manager.addService("Single-1", new Service("Breakfast", 500.0));

        System.out.println("Reservation ID: Single-1");
        System.out.println("Total Add-On Cost: " + manager.calculateTotalServiceCost("Single-1"));
    }
}