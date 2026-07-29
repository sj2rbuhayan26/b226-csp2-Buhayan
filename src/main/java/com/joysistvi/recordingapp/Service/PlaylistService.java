package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Playlist;

import java.util.List;


public interface PlaylistService {


    void addPlaylist(int userId);


    List<Playlist> getAllPlaylists();


    void updatePlaylist(int id);


    void deletePlaylist(int id);

}