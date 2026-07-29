package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.PlaylistController;

import java.util.Scanner;

public class PlaylistView {

    private final PlaylistController playlistController;
    private final Scanner scanner = new Scanner(System.in);

    public PlaylistView(PlaylistController playlistController) {
        this.playlistController = playlistController;
    }


    public void showMenu() {

        int choice;

        do {

            System.out.println("\n===== PLAYLIST MANAGEMENT =====");
            System.out.println("1. Add Playlist");
            System.out.println("2. View Playlists");
            System.out.println("3. Update Playlist");
            System.out.println("4. Delete Playlist");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            choice = Integer.parseInt(scanner.nextLine());


            switch(choice) {

                case 1:
                    addPlaylist();
                    break;

                case 2:
                    viewPlaylists();
                    break;

                case 3:
                    updatePlaylist();
                    break;

                case 4:
                    deletePlaylist();
                    break;

                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while(choice != 0);

    }


    private void addPlaylist() {

        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        playlistController.addPlaylist(userId);

        System.out.println("Playlist added successfully!");

    }


    private void viewPlaylists() {

        playlistController.viewPlaylists();

    }


    private void updatePlaylist() {

        System.out.print("Enter Playlist ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        playlistController.updatePlaylist(id);

        System.out.println("Playlist updated successfully!");

    }


    private void deletePlaylist() {

        System.out.print("Enter Playlist ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        playlistController.deletePlaylist(id);

        System.out.println("Playlist deleted successfully!");

    }

}