package cardealershipmanagementsystem;

import java.util.List;
/**
 * @author Jake Butler
 * ITCS 3112-001, Essenmacher
 * @version 1.0
 * @since 11-18-2024
 * Employee Class
 */
public class Employee extends Customer {
    private String employeeId;
    private String position;

    /**
     *
     * @param employeeId
     * @param position
     */
    public Employee(String employeeId, String position) {
        super(employeeId, "Employee " + employeeId, "employee" + employeeId + "@dealership.com", List.of());
        this.employeeId = employeeId;
        this.position = position;
    }

    /**
     *
     * @return
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     *
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param vehicle
     * @param inventory
     */
    public void addVehicleToInventory(Vehicle vehicle, Inventory inventory) {
        inventory.addVehicle(vehicle);
        System.out.println("Employee " + employeeId + " added vehicle to inventory: " + vehicle.getDetails());
    }

    /**
     *
     * @param vehicle
     * @param inventory
     */
    public void removeVehicleFromInventory(Vehicle vehicle, Inventory inventory) {
        inventory.removeVehicle(vehicle);
        System.out.println("Employee " + employeeId + " removed vehicle from inventory: " + vehicle.getDetails());
    }
}
