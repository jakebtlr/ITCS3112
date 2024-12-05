package cardealershipmanagementsystem;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Jake Butler
 * ITCS 3112-001, Essenmacher
 * @version 1.0
 * @since 11-18-2024
 * Maintenance Schedule Class
 */
public class MaintenanceSchedule {
    private List<MaintenanceRecord> scheduledServices;

    /**
     *
     */
    public MaintenanceSchedule() {
        this.scheduledServices = new ArrayList<>();
    }

    /**
     *
     * @param record
     */
    public void addServiceToSchedule(MaintenanceRecord record) {
        scheduledServices.add(record);
    }

    /**
     *
     * @return
     */
    public List<MaintenanceRecord> viewSchedule() {
        return scheduledServices;
    }
}
