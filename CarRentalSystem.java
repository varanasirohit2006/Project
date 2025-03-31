package carrentalsystem;

import java.util.*;

public class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Admin admin = new Admin("admin", "Admin", "admin123");
    private Scanner scanner = new Scanner(System.in);

    // Abstraction - showing essential features only
    public void start() {
        while (true) {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. Admin Login\n2. User Login\n3. Register\n4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: adminLogin(); break;
                case 2: userLogin(); break;
                case 3: registerUser(); break;
                case 4: System.out.println("Exiting system. Thank you!"); return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void adminLogin() {
        System.out.print("Enter Admin ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();
        
        // Dynamic binding through interface
        Authenticable auth = admin;
        if (admin.getUserId().equals(id) && auth.authenticate(pass)) {
            adminMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Car\n2. Remove Car\n3. View All Cars\n4. View All Users\n5. Logout");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addCar(); break;
                case 2: removeCar(); break;
                case 3: viewAllCars(); break;
                case 4: viewAllUsers(); break;
                case 5: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void addCar() {
        System.out.print("Enter Car ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Price per day: ");
        double price = scanner.nextDouble();
        cars.add(new Car(id, brand, model, price));
        System.out.println("Car added successfully!");
    }

    private void removeCar() {
        System.out.print("Enter Car ID to remove: ");
        String id = scanner.nextLine();
        cars.removeIf(car -> car.getCarId().equals(id));
        System.out.println("Car removed successfully!");
    }

    private void viewAllCars() {
        System.out.println("\nAll Cars:");
        // Using interface for display
        for (Displayable car : cars) {
            car.displayDetails();
            System.out.println("-------------------");
        }
    }

    private void viewAllUsers() {
        System.out.println("\nAll Users:");
        // Dynamic binding through interface
        for (Displayable user : customers) {
            user.displayDetails();
            System.out.println("-------------------");
        }
    }

    private void registerUser() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        String userId = "CUS" + (customers.size() + 1);
        customers.add(new Customer(userId, name, password));
        System.out.println("User registered! Your ID: " + userId);
    }

    private void userLogin() {
        System.out.print("Enter User ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();
        
        for (Customer customer : customers) {
            // Using interface for authentication
            Authenticable auth = customer;
            if (customer.getUserId().equals(id) && auth.authenticate(pass)) {
                userMenu(customer);
                return;
            }
        }
        System.out.println("Invalid credentials!");
    }

    private void userMenu(Customer customer) {
        while (true) {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. View Available Cars\n2. Rent a Car\n3. Return a Car\n4. Change Password\n5. View My Details\n6. Logout");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: viewAvailableCars(); break;
                case 2: rentCar(customer); break;
                case 3: returnCar(customer); break;
                case 4: changePassword(customer); break;
                case 5: customer.displayDetails(); break;
                case 6: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void viewAvailableCars() {
        System.out.println("\nAvailable Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                car.displayDetails();
                System.out.println("-------------------");
            }
        }
    }

    private void rentCar(Customer customer) {
        viewAvailableCars();
        System.out.print("Enter Car ID to rent: ");
        String carId = scanner.nextLine();
        
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                car.rent();
                customer.addRental(new Rental(car, customer, new Date(), null));
                System.out.println("Car rented successfully!");
                return;
            }
        }
        System.out.println("Car not available or invalid ID!");
    }

    private void returnCar(Customer customer) {
        System.out.print("Enter Car ID to return: ");
        String carId = scanner.nextLine();
        
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                car.returnCar();
                System.out.println("Car returned successfully!");
                return;
            }
        }
        System.out.println("Invalid Car ID or car not rented!");
    }

    private void changePassword(Customer customer) {
        System.out.print("Enter current password: ");
        String oldPassword = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        
        // Using interface for password change
        Authenticable auth = customer;
        auth.changePassword(oldPassword, newPassword);
    }
}
