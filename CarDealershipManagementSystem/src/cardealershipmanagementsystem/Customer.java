package cardealershipmanagementsystem;

import java.util.List;
/**
 * @author Jake Butler
 * ITCS 3112-001, Essenmacher
 * @version 1.0
 * @since 11-18-2024
 * Customer Class
 */
public class Customer {
    private String customerId;
    private String name;
    private String contactInfo;
    private List<MaintenanceRecord> maintenanceRecords;

    /**
     *
     * @param customerId
     * @param name
     * @param contactInfo
     * @param maintenanceRecords
     */
    public Customer(String customerId, String name, String contactInfo, List<MaintenanceRecord> maintenanceRecords) {
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.maintenanceRecords = maintenanceRecords;
    }

    /**
     *
     * @return
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public List<MaintenanceRecord> getMaintenanceRecords() {
        return maintenanceRecords;
    }
}
