package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.Playlist;

import java.util.List;

public interface PlaylistRepo {

    void addPlaylist(int userId);

    List<Playlist> getAllPlaylists();

    void updatePlaylist(int id);

    void deletePlaylist(int id);
}