package com.joysistvi.recordingapp.Controller;


import com.joysistvi.recordingapp.Model.Playlist;
import com.joysistvi.recordingapp.Service.PlaylistService;

import java.util.List;


public class PlaylistController {


    private final PlaylistService playlistService;



    public PlaylistController(PlaylistService playlistService){

        this.playlistService = playlistService;

    }



    public void addPlaylist(int userId){

        playlistService.addPlaylist(userId);

    }



    public void viewPlaylists(){


        List<Playlist> playlists = playlistService.getAllPlaylists();


        if(playlists.isEmpty()){

            System.out.println("No playlists found.");

            return;

        }



        System.out.println("\n===== PLAYLIST LIST =====");



        for(Playlist playlist : playlists){


            System.out.println("Playlist ID: " + playlist.getId());
            System.out.println("User ID: " + playlist.getUserId());
            System.out.println("Date Created: " + playlist.getDateCreated());
            System.out.println("------------------------");


        }


    }



    public void updatePlaylist(int id){

        playlistService.updatePlaylist(id);

    }



    public void deletePlaylist(int id){

        playlistService.deletePlaylist(id);

    }

}