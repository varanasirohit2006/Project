package carrentalsystem;


public interface Authenticable {
    boolean authenticate(String password);
    void changePassword(String oldPassword, String newPassword);
}
