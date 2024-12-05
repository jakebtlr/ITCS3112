package cardealershipmanagementsystem;

import java.util.Date;
/**
 * @author Jake Butler
 * ITCS 3112-001, Essenmacher
 * @version 1.0
 * @since 11-18-2024
 * Maintenance Record Class
 */
public class MaintenanceRecord {
    private int recordId;
    private Date serviceDate;
    private String description;
    private float cost;

    /**
     *
     * @param recordId
     * @param serviceDate
     * @param description
     * @param cost
     */
    public MaintenanceRecord(int recordId, Date serviceDate, String description, float cost) {
        this.recordId = recordId;
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
    }

    /**
     *
     * @return
     */
    public String getServiceDetails() {
        return "Record ID: " + recordId + ", Date: " + serviceDate + ", Description: " + description + ", Cost: $" + cost;
    }
}
