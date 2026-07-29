package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.UserController;
import com.joysistvi.recordingapp.Model.User;

import java.util.Scanner;

public class LoginView {

    private final UserController userController;
    private final AdminView adminView;
    private final UserDashboardView userDashboardView;
    private final Scanner scanner = new Scanner(System.in);

    public LoginView(UserController userController,
                     AdminView adminView,
                     UserDashboardView userDashboardView) {

        this.userController = userController;
        this.adminView = adminView;
        this.userDashboardView = userDashboardView;
    }

    public void login() {

        while (true) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            User user = userController.login(username, password);

            if (user == null) {
                System.out.println("Invalid username or password!");
                continue;
            }

            System.out.println("Welcome " + user.getUsername());

            if (user.getRole().equalsIgnoreCase("ADMIN")) {
                adminView.showMenu();
            }else if(user.getRole().equalsIgnoreCase("USER")){
                userDashboardView.showMenu();
            }
            else {
                userDashboardView.showMenu();
            }

            break;
        }
    }
}