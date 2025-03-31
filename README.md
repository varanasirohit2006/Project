# Car Rental System 🚗💨

A Java-based Car Rental System demonstrating Object-Oriented Programming (OOP) principles with complete implementation of Encapsulation, Abstraction, Inheritance, Interfaces, and Dynamic Binding.

## Features ✨

- **User Management**:
  - Admin and Customer roles
  - Secure password authentication
  - User registration system

- **Car Management**:
  - Add/remove cars from inventory
  - View available cars
  - Car rental and return functionality

- **OOP Principles Implemented**:
  - ✅ **Encapsulation**: All class attributes are private with controlled access
  - ✅ **Abstraction**: Abstract classes and hiding implementation details
  - ✅ **Inheritance**: Admin and Customer inherit from User class
  - ✅ **Interfaces**: Authenticable and Displayable interfaces
  - ✅ **Dynamic Binding**: Runtime polymorphism through method overriding

## Class Diagram 📐

```mermaid
classDiagram
    class Authenticable {
        <<interface>>
        +authenticate(String password) boolean
        +changePassword(String oldPassword, String newPassword) void
    }

    class Displayable {
        <<interface>>
        +displayDetails() void
    }

    class User {
        <<abstract>>
        -String userId
        -String name
        -String password
        +authenticate(String password) boolean
        +changePassword(String oldPassword, String newPassword) void
        +displayDetails()* void
    }

    class Admin {
        +displayDetails() void
    }

    class Customer {
        -List<Rental> rentals
        +displayDetails() void
        +addRental(Rental rental) void
    }

    class Car {
        -String carId
        -String brand
        -String model
        -double basePricePerDay
        -boolean isAvailable
        +displayDetails() void
    }

    class Rental {
        -Car car
        -Customer customer
        -Date rentalDate
        -Date returnDate
    }

    class CarRentalSystem {
        -List<Car> cars
        -List<Customer> customers
        -Admin admin
        -Scanner scanner
        +start() void
    }

    User <|-- Admin
    User <|-- Customer
    User ..|> Authenticable
    User ..|> Displayable
    Car ..|> Displayable
    Customer "1" *-- "0..*" Rental
    Rental "1" *-- "1" Car


Code Structure 📂
car-rental-system/
├── src/
│   └── salary/
│       ├── Authenticable.java       # Authentication interface
│       ├── Displayable.java         # Display interface
│       ├── User.java                # Abstract User class
│       ├── Admin.java               # Admin implementation
│       ├── Customer.java            # Customer implementation
│       ├── Car.java                 # Car entity
│       ├── Rental.java              # Rental entity
│       ├── CarRentalSystem.java     # Main system logic
│       └── Main.java                # Entry point
├── README.md                        # This file
└── .gitignore                       # Git ignore file

OOP Concepts Demonstrated 🧠
Concept	Implementation Example
Encapsulation	All class fields private with getters/setters
Abstraction	Abstract User class, interface methods
Inheritance	Admin/Customer extends User
Interfaces	Authenticable, Displayable
Dynamic Binding	displayDetails() behaves differently for Admin vs Customer


Installation & Usage 🛠️
Prerequisites:

Java JDK 8 or later

Git (optional)
git clone https://github.com/yourusername/car-rental-system.git
cd car-rental-system
javac salary/*.java


Running the Application:
java salary.Main


Sample Logins:
Admin: ID = "admin", Password = "admin123"
Customer: Register first through the application

