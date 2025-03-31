package carrentalsystem;

import java.util.Date;

public class Rental {
    private Car car;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;

    public Rental(Car car, Customer customer, Date rentalDate, Date returnDate) {
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    // Encapsulated getters
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public Date getRentalDate() { return rentalDate; }
    public Date getReturnDate() { return returnDate; }
}