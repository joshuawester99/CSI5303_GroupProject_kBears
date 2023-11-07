import java.io.IOException;
import java.util.Scanner;

public class ProfileController {

    UserCatalog userCatalog;

    public ProfileController(UserCatalog userCatalog) {
        this.userCatalog = userCatalog;
    }

    public void modifyUserAccount(User currentUser){
        userCatalog.modifyAccount(currentUser);
    }

    public User getCredentials(boolean loggedIn) throws IOException {

        Scanner scanner = new Scanner(System.in);

        User user = new User();

        while (!loggedIn) {

            System.out.println("Please choose Create Account or Log In");
            String user_status = scanner.nextLine();

            if (user_status.equals("Create Account")) {

                user = userCatalog.guestSignUp();
                userCatalog.users.put(user.username, (Guest) user);
                loggedIn = true;

            } else if (user_status.equals("Log In")) {
                user = logIn();
                loggedIn = true;

            } else System.out.println("Invalid input. Please, try again.");
        }

        System.out.println("Welcome, " + user.getName());
        return user;
    }

    public User logIn() {

        Scanner scanner = new Scanner(System.in);

        User user;
        String input_password;
        String password;

        System.out.println("Please, type your username. Then press enter.");
        String username = scanner.nextLine();

        while (!userCatalog.users.containsKey(username)) {
            System.out.println("User Name Invalid! Please, try again.");
            username = scanner.nextLine();
        }
        user =userCatalog.users.get(username);

        password = user.getPassword();

        while (true) {
            System.out.println("What is your password?");
            input_password = scanner.nextLine();

            if (input_password.equals(password)) break;
            else System.out.println("Invalid Password! Please, try again.");
        }

        System.out.println("Logged in as a(n) " + user.getStatus());

        return user;
    }


}
