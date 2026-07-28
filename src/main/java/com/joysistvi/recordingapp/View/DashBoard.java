package com.joysistvi.recordingapp.View;

import com.joysistvi.recordingapp.Controller.SongController;
import com.joysistvi.recordingapp.Model.Album;
import com.joysistvi.recordingapp.Model.Artists;
import com.joysistvi.recordingapp.Repository.SongRepo;
import com.joysistvi.recordingapp.Repository.SongRepositoryImpl;
import com.joysistvi.recordingapp.Service.SongService;
import com.joysistvi.recordingapp.Service.SongServiceImp;
import com.joysistvi.recordingapp.config.DbConnection;

import java.util.Scanner;

public class DashBoard {
    private Scanner scanner = new Scanner(System.in);
    DbConnection dbConnection = new DbConnection();
    SongRepo songRepo = new SongRepositoryImpl(dbConnection);
    SongService songService = new SongServiceImp(songRepo);
    SongController songController = new SongController(songService);
    private SongView songView = new SongView(songController);

    public void start(){
        while (true){
            System.out.println("\n ==== Recording Studio Application ==== ");
            System.out.println(" 1. Song Menu ");
            System.out.println(" 2. Exit ");
            System.out.print(" Select : ");
            int select = scanner.nextInt();

            switch (select){
                case 1 :
                    mainMenu();
                    break;
                case 2 :
                    System.out.println(" Good Bye ...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Invalid Input ...");


            }
        }
    }


    public void mainMenu(){
        while (true) {
            System.out.println("\n === Welcome to Recording Studio Apps === ");
            System.out.println(" 1 Manage Songs ");
            System.out.println(" 2 Manage Albums ");
            System.out.println(" 3 Manage Artist ");
            System.out.println(" 4 Exit ");
            System.out.print(" Enter a choice : ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1 :
                    songView.showMenu();
                    break;
                case 2 :
                    break;
                case 3 :

                    break;
                case 4 :
                    System.out.println("Exiting Application ....");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
        }

    }

    public static void main(String[] args) {
        new DashBoard().start();
    }
}
