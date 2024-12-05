package cardealershipmanagementsystem;

/**
 * @author Jake Butler
 * ITCS 3112-001, Essenmacher
 * @version 1.0
 * @since 11-18-2024
 * Vehicle Class
 */
public class Vehicle {

    /**
     *
     */
    public String vin;
    private String make;
    private String model;
    private int year;
    private String color;
    private float price;
    private boolean isAvailable;

    /**
     *
     * @param vin
     * @param make
     * @param model
     * @param year
     * @param color
     * @param price
     * @param isAvailable
     */
    public Vehicle(String vin, String make, String model, int year, String color, float price, boolean isAvailable) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    /**
     *
     * @return
     */
    public String getVin() {
        return vin;
    }

    /**
     *
     * @return
     */
    public String getMake() {
        return make;
    }

    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     *
     * @param status
     */
    public void updateAvailability(boolean status) {
        this.isAvailable = status;
    }

    /**
     *
     * @return
     */
    public String getDetails() {
        return "VIN: " + vin + ", Make: " + make + ", Model: " + model + 
               ", Year: " + year + ", Color: " + color + 
               ", Price: $" + price + ", Available: " + isAvailable;
    }
}
