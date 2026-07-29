package com.joysistvi.recordingapp.View;

import java.util.Scanner;

public class AdminView {

    private final SongView songView;
    private final AlbumView albumView;
    private final PlaylistView playlistView;
    private final UserView userView;

    private final Scanner scanner = new Scanner(System.in);

    public AdminView(SongView songView,
                     AlbumView albumView,
                     PlaylistView playlistView,
                     UserView userView) {

        this.songView = songView;
        this.albumView = albumView;
        this.playlistView = playlistView;
        this.userView = userView;
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n===== ADMIN DASHBOARD =====");
            System.out.println("1. Song Management");
            System.out.println("2. Album Management");
            System.out.println("3. Playlist Management");
            System.out.println("4. User Management");
            System.out.println("0. Logout");
            System.out.print("Choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    songView.showMenu();
                    break;

                case 2:
                    albumView.showMenu();
                    break;

                case 3:
                    playlistView.showMenu();
                    break;

                case 4:
                    userView.showMenu();
                    break;

                case 0:
                    System.out.println("Logged out.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}