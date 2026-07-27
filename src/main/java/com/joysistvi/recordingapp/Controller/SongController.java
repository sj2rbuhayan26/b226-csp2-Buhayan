package com.joysistvi.recordingapp.Controller;

import com.joysistvi.recordingapp.Model.Song;
import com.joysistvi.recordingapp.Service.SongService;

import java.util.List;

// Call the Service
public class SongController {

    private final SongService SongService;

    // Constructor injection
    public SongController(SongService songService) {
        this.SongService = songService;
    }


    public boolean addSong(String title, String length, String genre, int albumId) {
        Song song = new Song(title, length, genre, albumId);
        return SongService.addSong(song);
    }

    public List<Song> listSongs() {
        return SongService.listSongs();
    }

    // public boolean updateSong(){}
    // public boolean deleteSong(){}
}
