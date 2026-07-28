package com.joysistvi.recordingapp;

import com.joysistvi.recordingapp.Controller.SongController;
import com.joysistvi.recordingapp.Repository.SongRepo;
import com.joysistvi.recordingapp.Repository.SongRepositoryImpl;
import com.joysistvi.recordingapp.Service.SongService;
import com.joysistvi.recordingapp.Service.SongServiceImp;
import com.joysistvi.recordingapp.View.SongView;
import com.joysistvi.recordingapp.config.DbConnection;

import java.util.Scanner;

public class Home {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DbConnection dbConnection = new DbConnection();

        SongRepo songRepo = new SongRepositoryImpl(dbConnection);
        SongService songService = new SongServiceImp(songRepo);
        SongController songController = new SongController(songService);
        SongView songView = new SongView(songController);

        int choice;

        do {
            printMainMenu();
            choice = readInt(scanner);

            switch (choice) {
                case 1:
                    songView.showMenu();
                    break;

                case 2:
                    System.out.println("Album Management is not available yet.");
                    break;

                case 3:
                    System.out.println("Artist Management is not available yet.");
                    break;

                case 4:
                    System.out.println("Playlist Management is not available yet.");
                    break;

                case 5:
                    System.out.println("User Management is not available yet.");
                    break;

                case 0:
                    System.out.println("Thank you for using Recording Studio App!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n===== RECORDING STUDIO APP =====");
        System.out.println("1. Song Management");
        System.out.println("2. Album Management");
        System.out.println("3. Artist Management");
        System.out.println("4. Playlist Management");
        System.out.println("5. User Management");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}