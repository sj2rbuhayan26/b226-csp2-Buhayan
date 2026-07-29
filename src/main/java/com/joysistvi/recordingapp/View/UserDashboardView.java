package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.PlaylistController;
import com.joysistvi.recordingapp.Model.Playlist;

import java.util.Scanner;

public class UserDashboardView {
    private final PlaylistView playlistView;
    private final Scanner scanner = new Scanner(System.in);

    public UserDashboardView(PlaylistView playlistView){
        this.playlistView = playlistView;
    }
    public void showMenu() {

        int choice;

        do {

            System.out.println("\n===== USER DASHBOARD =====");
            System.out.println("1. Browse Songs");
            System.out.println("2. Browse Albums");
            System.out.println("3. Browse Artist");
            System.out.println("4. My PlayList");
            System.out.println("0. Log Out");
            System.out.print("Choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Browse Song");
                    break;

                case 2:
                    System.out.println("Browse Album");
                    break;
                case 3:
                    System.out.println("Browse Artist");
                    break;
                case 4 :
                    System.out.println("My Playlist");
                    playlistView.showMenu();
                    break;
                case 0 :
                    System.out.println("Log Out");
                    break;
            }

        } while (choice != 0);
    }
}