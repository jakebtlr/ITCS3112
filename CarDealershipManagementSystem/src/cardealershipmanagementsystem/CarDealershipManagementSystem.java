package cardealershipmanagementsystem;

import java.util.*;
/**
 * @author Jake Butler
 * ITCS 3112-001, Essenmacher
 * @version 1.0
 * @since 11-18-2024
 * Car Dealership Management System
 */
public class CarDealershipManagementSystem {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        MaintenanceSchedule schedule = new MaintenanceSchedule();
        List<Customer> customers = addPredefinedCustomers(); 
        List<Employee> employees = addPredefinedEmployees(); 

        addPredefinedVehicles(inventory);

        boolean running = true;
        while (running) {
            System.out.println("\nCar Dealership Management System");
            System.out.println("Are you an Employee or Customer?");
            System.out.println("1. Employee");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int userType = scanner.nextInt();
            scanner.nextLine(); 

            switch (userType) {
                case 1 -> {
                    System.out.println("Enter your Employee ID:");
                    String employeeId = scanner.nextLine();
                    Optional<Employee> employeeOpt = employees.stream()
                            .filter(e -> e.getEmployeeId().equals(employeeId))
                            .findFirst();
                    if (employeeOpt.isPresent()) {
                        Employee employee = employeeOpt.get();
                        System.out.println("Welcome, " + employee.getPosition() + "!");
                        handleEmployee(scanner, inventory, schedule, employee);
                    } else {
                        System.out.println("Invalid Employee ID.");
                    }
                }
                case 2 -> {
                    System.out.println("Enter your Customer ID:");
                    String customerId = scanner.nextLine();
                    Optional<Customer> customerOpt = customers.stream()
                            .filter(c -> c.getCustomerId().equals(customerId))
                            .findFirst();
                    if (customerOpt.isPresent()) {
                        Customer customer = customerOpt.get();
                        System.out.println("Welcome, " + customer.getName() + "!");
                        handleCustomer(scanner, inventory, schedule, customer);
                    } else {
                        System.out.println("Invalid Customer ID.");
                    }
                }
                case 3 -> {
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static List<Employee> addPredefinedEmployees() {
        return List.of(
            new Employee("E001", "Manager"),
            new Employee("E002", "Sales Representative"),
            new Employee("E003", "Service Technician"),
            new Employee("E004", "Finance Specialist"),
            new Employee("E005", "Receptionist"),
            new Employee("E006", "Parts Specialist"),
            new Employee("E007", "Inventory Manager"),
            new Employee("E008", "Marketing Specialist"),
            new Employee("E009", "Detailer"),
            new Employee("E010", "Lot Attendant")
        );
    }

    private static List<Customer> addPredefinedCustomers() {
        return List.of(
            new Customer("C001", "Alice Johnson", "alice.johnson@gmail.com", createServiceHistory("Toyota Camry")),
            new Customer("C002", "Bob Smith", "bob.smith@yahoo.com", createServiceHistory("Honda Accord")),
            new Customer("C003", "Charlie Brown", "charlie.brown@hotmail.com", createServiceHistory("Ford Mustang")),
            new Customer("C004", "Diana Prince", "diana.prince@wonder.com", createServiceHistory("Chevrolet Malibu")),
            new Customer("C005", "Ethan Hunt", "ethan.hunt@impossible.com", createServiceHistory("Nissan Altima")),
            new Customer("C006", "Fiona Gallagher", "fiona.gallagher@shameless.com", createServiceHistory("Tesla Model 3")),
            new Customer("C007", "George Bailey", "george.bailey@life.com", createServiceHistory("BMW 3 Series")),
            new Customer("C008", "Hannah Montana", "hannah.montana@music.com", createServiceHistory("Audi A4")),
            new Customer("C009", "Ian Fleming", "ian.fleming@spy.com", createServiceHistory("Mercedes-Benz C-Class")),
            new Customer("C010", "Jessica Jones", "jessica.jones@detective.com", createServiceHistory("Volkswagen Jetta"))
        );
    }

    private static List<MaintenanceRecord> createServiceHistory(String vehicleName) {
        Random random = new Random();
        List<MaintenanceRecord> records = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            records.add(new MaintenanceRecord(
                i,
                new Date(System.currentTimeMillis() - random.nextInt(1000000000)),
                "Maintenance for " + vehicleName,
                100.0f + random.nextFloat() * 200
            ));
        }
        return records;
    }

    private static void addPredefinedVehicles(Inventory inventory) {
        List<Vehicle> vehicles = List.of(
            new Vehicle("VIN001", "Toyota", "Camry", 2021, "White", 24000.00f, true),
            new Vehicle("VIN002", "Honda", "Accord", 2020, "Black", 23000.00f, true),
            new Vehicle("VIN003", "Ford", "Mustang", 2022, "Red", 36000.00f, true),
            new Vehicle("VIN004", "Chevrolet", "Malibu", 2019, "Blue", 21000.00f, true),
            new Vehicle("VIN005", "Nissan", "Altima", 2021, "Gray", 22000.00f, true),
            new Vehicle("VIN006", "Tesla", "Model 3", 2023, "White", 45000.00f, true),
            new Vehicle("VIN007", "BMW", "3 Series", 2020, "Black", 41000.00f, true),
            new Vehicle("VIN008", "Audi", "A4", 2018, "Blue", 38000.00f, true),
            new Vehicle("VIN009", "Mercedes-Benz", "C-Class", 2022, "Silver", 42000.00f, true),
            new Vehicle("VIN010", "Volkswagen", "Jetta", 2019, "Gray", 20000.00f, true)
        );
        for (Vehicle vehicle : vehicles) {
            inventory.addVehicle(vehicle);
        }
        System.out.println("Predefined vehicles added to inventory.");
    }

    private static void handleEmployee(Scanner scanner, Inventory inventory, MaintenanceSchedule schedule, Employee employee) {
        boolean back = false;
        while (!back) {
            System.out.println("\nEmployee Menu");
            System.out.println("1. Browse Vehicles");
            System.out.println("2. Add Vehicle to Inventory");
            System.out.println("3. Remove Vehicle from Inventory");
            System.out.println("4. View Maintenance Schedule");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    List<Vehicle> vehicles = inventory.getVehicles();
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles available in inventory.");
                    } else {
                        vehicles.forEach(vehicle -> System.out.println(vehicle.getDetails()));
                    }
                }
                case 2 -> {
                    System.out.println("You are about to add a new vehicle to the inventory.");
                    System.out.println("Please follow the prompts below:");

                    System.out.print("Enter the Vehicle Identification Number (VIN): ");
                    String vin = scanner.nextLine();

                    System.out.print("Enter the Make (e.g., Toyota, Honda, Ford): ");
                    String make = scanner.nextLine();

                    System.out.print("Enter the Model (e.g., Camry, Accord, Mustang): ");
                    String model = scanner.nextLine();

                    System.out.print("Enter the Year of Manufacture (e.g., 2021): ");
                    int year;
                    while (true) {
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid year (e.g., 2021): ");
                        }
                    }

                    System.out.print("Enter the Color of the Vehicle (e.g., Red, Black, Blue): ");
                    String color = scanner.nextLine();

                    System.out.print("Enter the Price of the Vehicle (e.g., 25000.00): ");
                    float price;
                    while (true) {
                        try {
                            price = Float.parseFloat(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid price (e.g., 25000.00): ");
                        }
                    }

                    Vehicle vehicle = new Vehicle(vin, make, model, year, color, price, true);
                    employee.addVehicleToInventory(vehicle, inventory);
                    System.out.println("The following vehicle has been successfully added to the inventory:");
                    System.out.println(vehicle.getDetails());
                }
                case 3 -> {
                    System.out.println("Enter Vehicle VIN to remove:");
                    String vin = scanner.nextLine();
                    Vehicle vehicle = inventory.findVehicleByVin(vin);
                    if (vehicle != null) {
                        employee.removeVehicleFromInventory(vehicle, inventory);
                        System.out.println("Vehicle removed from inventory.");
                    } else {
                        System.out.println("Vehicle not found in inventory.");
                    }
                }
                case 4 -> {
                    List<MaintenanceRecord> records = schedule.viewSchedule();
                    if (records.isEmpty()) {
                        System.out.println("No maintenance scheduled.");
                    } else {
                        records.forEach(record -> System.out.println(record.getServiceDetails()));
                    }
                }
                case 5 -> back = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleCustomer(Scanner scanner, Inventory inventory, MaintenanceSchedule schedule, Customer customer) {
        boolean back = false;
        while (!back) {
            System.out.println("\nCustomer Menu");
            System.out.println("1. Browse Vehicles");
            System.out.println("2. View Your Service History");
            System.out.println("3. Schedule Maintenance");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    List<Vehicle> vehicles = inventory.getVehicles();
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles available in inventory.");
                    } else {
                        vehicles.forEach(vehicle -> System.out.println(vehicle.getDetails()));
                    }
                }
                case 2 -> {
                    System.out.println("Service History for Customer " + customer.getName() + ":");
                    customer.getMaintenanceRecords().forEach(record -> System.out.println(record.getServiceDetails()));
                }
                case 3 -> {
                    System.out.println("Scheduling Maintenance for Customer: " + customer.getName());

                    System.out.print("Enter a brief description of the service required (e.g., Oil Change, Tire Rotation): ");
                    String description = scanner.nextLine();

                    System.out.print("What is your budget for this service? (e.g., 150.00): ");
                    float cost;
                    while (true) {
                        try {
                            cost = Float.parseFloat(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid budget (e.g., 150.00): ");
                        }
                    }

                    System.out.print("When would you like to schedule this service? (Enter date in format YYYY-MM-DD): ");
                    String dateInput;
                    Date serviceDateTime;
                    while (true) {
                        try {
                            dateInput = scanner.nextLine();
                            System.out.print("At what time would you like the service? (Enter time in 24-hour format HH:mm, e.g., 14:30): ");
                            String timeInput = scanner.nextLine();
                            String dateTimeInput = dateInput + " " + timeInput;
                            serviceDateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTimeInput);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please ensure the date and time are in the correct format (YYYY-MM-DD and HH:mm): ");
                        }
                    }

                    MaintenanceRecord newRecord = new MaintenanceRecord(
                            customer.getMaintenanceRecords().size() + 1,
                            serviceDateTime,
                            description,
                            cost
                    );

                    customer.getMaintenanceRecords().add(newRecord);
                    schedule.addServiceToSchedule(newRecord);

                    System.out.println("Maintenance scheduled successfully!");
                    System.out.println(newRecord.getServiceDetails());
                }
                case 4 -> back = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
