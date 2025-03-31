package carrentalsystem;


public class Admin extends User {
    public Admin(String userId, String name, String password) {
        super(userId, name, password);
    }


    public void displayDetails() {
        System.out.println("Admin ID: " + getUserId());
        System.out.println("Name: " + getName());
    }
}
