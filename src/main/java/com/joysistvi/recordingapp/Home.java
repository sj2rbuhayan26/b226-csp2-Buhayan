package com.joysistvi.recordingapp;

import com.joysistvi.recordingapp.Controller.*;
import com.joysistvi.recordingapp.Repository.*;
import com.joysistvi.recordingapp.Service.*;
import com.joysistvi.recordingapp.View.*;
import com.joysistvi.recordingapp.config.DbConnection;


import java.util.Scanner;

public class Home {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DbConnection dbConnection = new DbConnection();

        // Song
        SongRepo songRepo = new SongRepositoryImpl(dbConnection);
        SongService songService = new SongServiceImp(songRepo);
        SongController songController = new SongController(songService);
        SongView songView = new SongView(songController);

        // Album
        AlbumRepo albumRepo = new AlbumRepositoryImpl(dbConnection);
        AlbumService albumService = new AlbumServiceImpl(albumRepo);
        AlbumController albumController = new AlbumController(albumService);
        AlbumView albumView = new AlbumView(albumController);

        // Artist
        ArtistRepo artistRepo = new ArtistRepositoryImpl(dbConnection);
        ArtistService artistService = new ArtistServiceImpl(artistRepo);
        ArtistController artistController = new ArtistController(artistService);
        ArtistView artistView = new ArtistView(artistController);

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

        //

        UserDashboardView userDashboardView = new UserDashboardView(
                playlistView,
                albumView,
                artistView,
                songView
        );
        AdminView adminView = new AdminView(
                songView,
                albumView,
                playlistView,
                userView,
                artistView
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