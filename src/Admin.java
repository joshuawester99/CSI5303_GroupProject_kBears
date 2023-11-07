import java.util.Scanner;

public class Admin extends User {

    private int adminID = 1;
    private String name;
    private String username;
    private String password;

    public Admin() {
        this.name = "admin";
        this.username = "admin";
        this.password = "admin";
        this.status = "Admin";
    }

    public String getPassword() {
        return this.password;
    }


}
