package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.SongController;
import com.joysistvi.recordingapp.Model.Song;

import java.util.List;
import java.util.Scanner;

// View handles the user interface (shows menu, prompts, output)
// Calls Controller
public class SongView {

    private final SongController songController;
    private final Scanner scanner = new Scanner(System.in);

    // Constructor injection
    public SongView(SongController songController) {
        this.songController = songController;
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Song Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. View All Songs");
            System.out.println("3. Update Song");
            System.out.println("4. Delete Song");
            System.out.println("5. Archive Song");
            System.out.println("6. Restore Song");
            System.out.println("7. Search Song");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Length: ");
                    String length = scanner.nextLine();

                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();

                    System.out.print("Album ID: ");
                    int albumId = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    boolean success = songController.addSong(title, length, genre, albumId);

                    if (success) {
                        System.out.println("Song added successfully!");
                    } else {
                        System.out.println("Failed to add song.");
                    }
                    break;
                case 2:
                    System.out.println("View All Songs");
                    songController.listSongs();
                    break;
                case 3:
                    System.out.print("Song ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("New Length: ");
                    String newLength = scanner.nextLine();

                    System.out.print("New Genre: ");
                    String newGenre = scanner.nextLine();

                    boolean updated = songController.updateSong(id, newTitle, newLength, newGenre);

                    if (updated) {
                        System.out.println("Song updated successfully!");
                    } else {
                        System.out.println("Failed to update song.");
                    }
                    break;
                case 4 :
                    songController.listSongs();

                    System.out.print("\n Enter Song Id to delete : ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    boolean delete = songController.deleteSong(deleteId);

                    if (delete){
                        System.out.println("Song has Successful deleted");
                    }else {
                        System.out.println("Failed to delete song");
                    }
                    break;
                case 5 :
                    songController.listSongs();
                    System.out.print("\n Enter song id to archive :  ");
                    int archivedid = scanner.nextInt();
                    scanner.nextLine();

                    boolean archived = songController.archivedSong(archivedid);

                    if (archived){
                        System.out.println("Song has Successful archived");
                    }else{
                        System.out.println("Failed to archive song");
                    }
                    break;
                case 6 :
                    songController.listArchivedSongs();

                    System.out.print("\nEnter song id to restore : ");
                    int restoredId = scanner.nextInt();
                    scanner.nextLine();

                    boolean restored = songController.restoreSong(restoredId);

                    if (restored){
                        System.out.println("Song restores successfully.");
                    }else{
                        System.out.println("Failed to restore song,");
                    }
                    break;

                case 7 :
                    System.out.print("Enter title , genre , or album : ");
                    String keyword = scanner.nextLine();

                    songController.searchSong(keyword);
                    break;


                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

}
