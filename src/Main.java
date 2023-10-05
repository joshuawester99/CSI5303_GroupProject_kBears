import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<Room>();
        HashMap<String, Guest> guests = new HashMap<String, Guest>();
        HashMap<String, Admin> admins = new HashMap<>();
        int guestIncrement = 1;

        Room room1 = new Room("1A", false, "Queen", 2, "economy");
        Room room2 = new Room("1B", false, "King", 1, "comfort");
        Room room3 = new Room("1C", false, "King", 1, "executive");
        Room room4 = new Room("2A", true, "Twin", 2, "economy");
        Room room5 = new Room("2B", true, "Queen", 2, "comfort");

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        admins.put("admin", new Admin("Nick", "admin", "admin", 1));

        String status = "none";
        Scanner scanner = new Scanner(System.in);

        while(true) {

            while (!status.equals("Admin") & !status.equals("Clerk") & !status.equals("Guest")) {

                System.out.println("Please enter your User status (Admin, Clerk, Guest):");
                status = scanner.nextLine();

            }

            if (status.equals("Guest")) {
                String guestStatus = "none";

                while (!guestStatus.equals("Create Account") & !guestStatus.equals("Log In")) {

                    System.out.println("Please choose Create Account or Log In");
                    guestStatus = scanner.nextLine();
                }

                if (guestStatus.equals("Create Account")) {
                    String name = "none";
                    String userName = "none";
                    String password = "none";


                    System.out.println("What is your name?:");
                    name = scanner.nextLine();

                    System.out.println("What is your User Name?:");
                    userName = scanner.nextLine();

                    System.out.println("What is your password?:");
                    password = scanner.nextLine();

                    guests.put(userName, new Guest(name, userName, password, guestIncrement));
                    guestIncrement += 1;

                }

                if (guestStatus.equals("Log In")) {
                    String inputUserName = "none";
                    String inputPassword = "none";
                    boolean passwordCheck = false;

                    while (!guests.containsKey(inputUserName)) {

                        System.out.println("What is your user name?");
                        inputUserName = scanner.nextLine();

                        if (!guests.containsKey(inputUserName)) {
                            System.out.println("User Name Invalid!");
                        }

                    }

                    while (!passwordCheck) {
                        System.out.println("What is your password?");
                        inputPassword = scanner.nextLine();

                        if (inputPassword.equals(guests.get(inputUserName).getPassword())) {
                            System.out.println("Welcome, " + guests.get(inputUserName).getName());
                            passwordCheck = true;

                            while (true) {
                                System.out.println("Would you like to modify your account? (Y/N)");
                                String inputChoice = scanner.nextLine();

                                if (inputChoice.equals("N")) {
                                    System.out.println("Goodbye.");
                                    break;
                                } else if (inputChoice.equals("Y")) {
                                    while (true) {
                                        System.out.println("What would you like to modify? (name, userName, password)");
                                        String inputOperation = scanner.nextLine();

                                        if (inputOperation.equals("name")) {
                                            System.out.println("What is your new name?");
                                            String newName = scanner.nextLine();
                                            guests.get(inputUserName).setName(newName);
                                            System.out.println("Name changed!");
                                            break;
                                        } else if (inputOperation.equals("userName")) {
                                            System.out.println("What is your new userName?");
                                            String newUserName = scanner.nextLine();
                                            guests.get(inputUserName).setName(newUserName);
                                            System.out.println("userName changed!");
                                            break;
                                        } else if (inputOperation.equals("password")) {
                                            System.out.println("What is your new password?");
                                            String newPassword = scanner.nextLine();
                                            guests.get(inputUserName).setName(newPassword);
                                            System.out.println("password changed!");
                                            break;
                                        } else {
                                            System.out.println("Invalid Selection!");
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            }


                        } else {
                            System.out.println("Invalid Password!");
                        }
                    }
                }

            } else if (status.equals("Admin")){
                while(true){
                    System.out.println("Please provide your userName:");
                    String adminUserName = scanner.nextLine();
                    if (admins.containsKey(adminUserName)){
                        System.out.println("Please enter you password:");
                        String adminPassword = scanner.nextLine();

                        if (admins.get(adminUserName).getPassword().equals(adminPassword)){
                            System.out.println("Successfully Logged In!");
                        }
                    }
                }
            }
        }
    }
}