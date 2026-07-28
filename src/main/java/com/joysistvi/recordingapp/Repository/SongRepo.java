package com.joysistvi.recordingapp.Repository;

// Contract

import com.joysistvi.recordingapp.Model.Song;

import java.util.List;
// Calls Model
public interface SongRepo {
    public List<Song> getAllSongs();
    public boolean createSong(Song song);
    public boolean updateSong(Song song);
    public boolean deleteSong(int id);
    public boolean archiveSong(int id);
    public boolean restoreSong(int id);
    public List<Song> searchSong(String keyword);
    public List<Song> readArchivedSong();
}
