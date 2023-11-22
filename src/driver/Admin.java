package driver;

import java.util.Scanner;

public class Admin extends User {

    private int adminID = 1;


    public Admin() {
        super("admin", "admin", "1234");
        this.status = "Admin";
    }

    public String getPassword() {
        return this.password;
    }


}
