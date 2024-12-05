package cardealershipmanagementsystem;

import java.util.*;
/**
 * @author Jake Butler
 * ITCS 3112-001, Essenmacher
 * @version 1.0
 * @since 11-18-2024
 * Inventory Class
 */
public class Inventory {
    private List<Vehicle> vehicles;

    /**
     *
     */
    public Inventory() {
        this.vehicles = new ArrayList<>();
    }

    /**
     *
     * @param vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     *
     * @param vehicle
     */
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    /**
     *
     * @return
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     *
     * @param vin
     * @return
     */
    public Vehicle findVehicleByVin(String vin) {
        return vehicles.stream().filter(vehicle -> vehicle.vin.equals(vin)).findFirst().orElse(null);
    }

}
