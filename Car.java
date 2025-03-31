package carrentalsystem;


public class Car implements Displayable {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    
    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPricePerDay() { return basePricePerDay; }
    public boolean isAvailable() { return isAvailable; }

    public void rent() { isAvailable = false; }
    public void returnCar() { isAvailable = true; }

    public void displayDetails() {
        System.out.println("Car ID: " + carId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price/Day: $" + basePricePerDay);
        System.out.println("Status: " + (isAvailable ? "Available" : "Rented"));
    }
}