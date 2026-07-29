package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.UserController;
import com.joysistvi.recordingapp.Model.User;

import java.util.Scanner;

public class LoginView {

    private final UserController controller;
    private final AdminView adminView;
    private final UserDashboardView userDashboardView;
    private final Scanner scanner = new Scanner(System.in);

    public LoginView(UserController controller,
                     AdminView adminView,
                     UserDashboardView userDashboardView) {
        this.controller = controller;
        this.adminView = adminView;
        this.userDashboardView = userDashboardView;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("      RECORDING APP");
            System.out.println("==============================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;

                case 2:
                    register();
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void login() {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = controller.login(username, password);

        if (user == null) {
            System.out.println("Invalid username or password.");
            return;
        }

        System.out.println("Welcome, " + user.getUsername() + "!");

        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            adminView.showMenu();
        } else {
            userDashboardView.showMenu();
        }
    }

    private void register() {

        System.out.println("\n===== REGISTER =====");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("Select Role");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("Choice: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            scanner.nextLine();
            return;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        String role;

        switch (choice) {
            case 1:
                role = "USER";
                break;

            case 2:
                role = "ADMIN";
                break;

            default:
                System.out.println("Invalid role.");
                return;
        }

        User user = new User(username, password, role);

        if (controller.register(user)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }
    }
}