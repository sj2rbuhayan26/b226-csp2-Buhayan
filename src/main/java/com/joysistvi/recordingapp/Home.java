package com.joysistvi.recordingapp;

import com.joysistvi.recordingapp.Controller.SongController;
import com.joysistvi.recordingapp.Repository.SongRepo;
import com.joysistvi.recordingapp.Repository.SongRepositoryImpl;
import com.joysistvi.recordingapp.Service.SongService;
import com.joysistvi.recordingapp.Service.SongServiceImp;
import com.joysistvi.recordingapp.View.*;
import com.joysistvi.recordingapp.config.DbConnection;
import com.joysistvi.recordingapp.Repository.AlbumRepo;
import com.joysistvi.recordingapp.Repository.AlbumRepositoryImpl;

import com.joysistvi.recordingapp.Service.AlbumService;
import com.joysistvi.recordingapp.Service.AlbumServiceImpl;
import com.joysistvi.recordingapp.Controller.AlbumController;

import com.joysistvi.recordingapp.Repository.PlaylistRepo;
import com.joysistvi.recordingapp.Repository.PlaylistRepositoryImpl;
import com.joysistvi.recordingapp.Service.PlaylistService;
import com.joysistvi.recordingapp.Service.PlaylistServiceImpl;
import com.joysistvi.recordingapp.Controller.PlaylistController;

import com.joysistvi.recordingapp.Repository.UserRepo;
import com.joysistvi.recordingapp.Repository.UserRepositoryImpl;
import com.joysistvi.recordingapp.Service.UserService;
import com.joysistvi.recordingapp.Service.UserServiceImpl;
import com.joysistvi.recordingapp.Controller.UserController;


import java.util.Scanner;

public class Home {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DbConnection dbConnection = new DbConnection();

        SongRepo songRepo = new SongRepositoryImpl(dbConnection);
        SongService songService = new SongServiceImp(songRepo);
        SongController songController = new SongController(songService);
        SongView songView = new SongView(songController);

        AlbumRepo albumRepo = new AlbumRepositoryImpl(dbConnection);
        AlbumService albumService = new AlbumServiceImpl(albumRepo);
        AlbumController albumController = new AlbumController(albumService);
        AlbumView albumView = new AlbumView(albumController);


        // Playlist
        PlaylistRepo playlistRepo = new PlaylistRepositoryImpl(dbConnection);
        PlaylistService playlistService = new PlaylistServiceImpl(playlistRepo);
        PlaylistController playlistController = new PlaylistController(playlistService);
        PlaylistView playlistView = new PlaylistView(playlistController);

        // User
        UserRepo userRepo = new UserRepositoryImpl(dbConnection);
        UserService userService = new UserServiceImpl(userRepo);
        UserController userController = new UserController(userService);
        UserView userView = new UserView(userController);

        UserDashboardView userDashboardView = new UserDashboardView(
                playlistView
        );
        AdminView adminView = new AdminView(
                songView,
                albumView,
                playlistView,
                userView
        );

        LoginView loginView = new LoginView(
                userController,
                adminView,
                userDashboardView
        );

        loginView.login();

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