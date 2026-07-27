package com.joysistvi.recordingapp.Repository;

// Contract

import com.joysistvi.recordingapp.Model.Song;

import java.util.List;
// Calls Model
public interface SongRepo {
    public List<Song> getAllSongs();
    public boolean createSong(Song song);
    public boolean updateSong(String title, String length, String genre, int id);
    public boolean deleteSong(int id);
}
