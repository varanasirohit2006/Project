package carrentalsystem;

public abstract class User implements Authenticable, Displayable {
    private String userId;
    private String name;
    private String password;

    public User(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

   
    public String getUserId() { return userId; }
    public String getName() { return name; }


    public boolean authenticate(String password) {
        return this.password.equals(password);
    }


    public void changePassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Incorrect previous password! Password change failed.");
        }
    }


    public abstract void displayDetails();
}
