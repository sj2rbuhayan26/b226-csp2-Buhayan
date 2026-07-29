package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.UserController;
import com.joysistvi.recordingapp.Model.User;

import java.util.Scanner;

public class LoginView {

    private final UserController controller;
    private final AdminView adminView;
    private final UserDashboardView userDashboardView;
    private final Scanner scanner = new Scanner(System.in);

    public LoginView(UserController controller, AdminView adminView, UserDashboardView userDashboardView) {
        this.controller = controller;
        this.adminView = adminView;
        this.userDashboardView = userDashboardView;
    }

    public void showMenu(){

        while(true){

            System.out.println("\n===== RECORDING APP =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            System.out.print("Choice: ");
            int choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                case 1:
                    login();
                    break;

                case 2:
                    register();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }

        }

    }

    private void login(){

        System.out.println("\n ==== LOGIN ====");

        System.out.print("Username: ");
        String username=scanner.nextLine();

        System.out.print("Password: ");
        String password=scanner.nextLine();

        User user=controller.login(username,password);

        if(user==null){
            System.out.println("Invalid username or password.");
            return;
        }

        System.out.println("Welcome "+user.getUsername());

        if(user.getRole().equalsIgnoreCase("ADMIN")){
             adminView.showMenu();
        }else{
            userDashboardView.showMenu();
        }

    }

    private void register(){

        System.out.println("\n ==== REGISTRER ====");

        System.out.print("Username: ");
        String username=scanner.nextLine();

        System.out.print("Password: ");
        String password=scanner.nextLine();

        User user=new User(username,password,"USER");

        if(controller.register(user)){
            System.out.println("Registration Successful.");
        }else{
            System.out.println("Registration Failed.");
        }

    }

}