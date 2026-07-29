package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Playlist;
import com.joysistvi.recordingapp.Repository.PlaylistRepo;

import java.util.List;


public class PlaylistServiceImpl implements PlaylistService {


    private final PlaylistRepo playlistRepo;


    public PlaylistServiceImpl(PlaylistRepo playlistRepo){

        this.playlistRepo = playlistRepo;

    }



    @Override
    public void addPlaylist(int userId){

        playlistRepo.addPlaylist(userId);

    }



    @Override
    public List<Playlist> getAllPlaylists(){

        return playlistRepo.getAllPlaylists();

    }



    @Override
    public void updatePlaylist(int id){

        playlistRepo.updatePlaylist(id);

    }



    @Override
    public void deletePlaylist(int id){

        playlistRepo.deletePlaylist(id);

    }

}