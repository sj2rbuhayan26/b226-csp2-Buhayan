package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.AlbumController;
import com.joysistvi.recordingapp.Model.Album;

import java.util.Scanner;

public class AlbumView {

    private final AlbumController controller;
    private final Scanner scanner = new Scanner(System.in);

    public AlbumView(AlbumController controller){
        this.controller = controller;
    }

    public void showMenu(){

        int choice;

        do{

            System.out.println("\n===== ALBUM MENU =====");
            System.out.println("1. Add Album");
            System.out.println("2. View Albums");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch(choice){

                case 1:

                    Album album = new Album();

                    System.out.print("Album ID: ");
                    album.setId(scanner.nextLine());

                    System.out.print("Album Name: ");
                    album.setName(scanner.nextLine());

                    System.out.print("Year: ");
                    album.setYear(Integer.parseInt(scanner.nextLine()));

                    System.out.print("Artist ID: ");
                    album.setArtistsId(scanner.nextLine());

                    controller.addAlbum(album);

                    break;

                case 2:

                    for(Album a : controller.getAllAlbums()){

                        System.out.println("--------------------");
                        System.out.println("ID : " + a.getId());
                        System.out.println("Name : " + a.getName());
                        System.out.println("Year : " + a.getYear());
                        System.out.println("Artist ID  : " + a.getArtistsId());
                    }

                    break;

                case 0:
                    System.out.println("Back to menu");
                    return;

                default:
                    System.out.println("Invalid choice.");

            }

        }while(choice != 0);
    }
}