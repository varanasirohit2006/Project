package carrentalsystem;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Rental> rentals;

    public Customer(String userId, String name, String password) {
        super(userId, name, password);
        this.rentals = new ArrayList<>();
    }

    public void displayDetails() {
        System.out.println("Customer ID: " + getUserId());
        System.out.println("Name: " + getName());
        System.out.println("Rentals: " + rentals.size());
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }
}