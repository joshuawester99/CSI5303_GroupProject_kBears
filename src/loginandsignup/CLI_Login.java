package loginandsignup;

import driver.CLI_Controller;
import driver.Main;

import java.io.IOException;
import java.util.Scanner;

public class CLI_Login {

    Scanner scanner = new Scanner(System.in);

    String username;
    String password;

    public void login() throws IOException {
        while (true){
            System.out.println("What is your username:");
            username = scanner.nextLine();
            if (Main.masterController.checkForUsername(username)){
                break;
            }
            else {
                System.out.println("Invalid Username!");
            }
        }

        while (true){
            System.out.println("What is your password:");
            password = scanner.nextLine();
            if (Main.masterController.checkForPassword(username, password)){
                Main.masterController.setCurrentUser(username);
                System.out.println("Logged In Successfully!");
                break;
            }
            else {
                System.out.println("Invalid Password!");
            }
        }

        CLI_Controller cliController = new CLI_Controller();
        cliController.selectOperation(Main.masterController.getCurrentUser());
    }
}
