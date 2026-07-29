package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.UserController;
import com.joysistvi.recordingapp.Model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private final UserController userController;
    private final Scanner scanner = new Scanner(System.in);

    public UserView(UserController userController) {
        this.userController = userController;
    }
    public void showMenu() {

        int choice;

        do {

            System.out.println("\n===== USER MANAGEMENT =====");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addUser();
                    break;

                case 2:
                    viewUsers();
                    break;

                case 3:
                    updateUser();
                    break;

                case 4:
                    deleteUser();
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private void addUser() {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("Role (ADMIN/USER): ");
        String role = scanner.nextLine().toUpperCase();

        User user = new User(0, username, password, role);

        userController.addUser(user);

        System.out.println("User added successfully!");
    }

    private void viewUsers() {

        List<User> users = userController.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("\n===== USER LIST =====");

        for (User user : users) {

            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role : " + user.getRole());
            System.out.println("----------------------");
        }
    }

    private void updateUser() {

        System.out.print("Enter User ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New Username: ");
        String username = scanner.nextLine();

        System.out.print("New Password: ");
        String password = scanner.nextLine();

        System.out.print("Role (ADMIN/USER): ");
        String role = scanner.nextLine().toUpperCase();

        User user = new User(id, username, password, role);

        userController.updateUser(user);

        System.out.println("User updated successfully!");
    }

    private void deleteUser() {

        System.out.print("Enter User ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        userController.deleteUser(id);

        System.out.println("User deleted successfully!");
    }
}