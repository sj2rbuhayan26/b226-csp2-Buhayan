package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.ArtistController;
import com.joysistvi.recordingapp.Model.Artist;

import java.util.List;
import java.util.Scanner;

public class ArtistView {

    private final ArtistController artistController;
    private final Scanner scanner = new Scanner(System.in);

    public ArtistView(ArtistController artistController) {
        this.artistController = artistController;
    }

    public void showMenu(){
        int choice;

        do {
            System.out.println("\n==== ARTIST MANAGEMENT ====");
            System.out.println("1. Add Artist");
            System.out.println("2. View Artist");
            System.out.println("3. Update Artist");
            System.out.println("4. Delete Artist");
            System.out.println("0. Back");
            System.out.print("Choice : ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){

                case 1 :
                    addArtist();
                    break;
                case 2 :
                    viewArtist();
                    break;
                case 3 :
                    updateArtist();
                    break;
                case 4 :
                    deleteArtist();
                    break;
                case 0 :
                    break;
                default :
                    System.out.println("Invalid Choice");
            }
        }while (choice == 0);
    }
    private void addArtist() {
        System.out.print("Artist Name: ");
        String name = scanner.nextLine();

        Artist artist = new Artist(name);

        artistController.addArtist(artist);

    }
    private void viewArtist(){
        List<Artist> artists = artistController.getAllArtist();

        if (artists == null || artists.isEmpty()){
            System.out.println("No artist found");
            return;
        }
        for (Artist artist : artists){
            System.out.printf("%-5d %-30s%n",
                    artist.getId(),
                    artist.getName());
        }
    }
    private void updateArtist(){
        System.out.println("Artist ID : ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("New Name : ");
        String name = scanner.nextLine();

        artistController.updateArtist(new Artist(id,name));

        System.out.println("Artist Updated Sucessfully");
    }

    private void deleteArtist(){
        System.out.println("Artist ID : ");
        int id = Integer.parseInt(scanner.nextLine());

        artistController.deleteArtist(id);

        System.out.println("Artist Delete Successfully");

    }




}
