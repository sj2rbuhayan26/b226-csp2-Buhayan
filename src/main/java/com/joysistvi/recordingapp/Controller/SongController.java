package com.joysistvi.recordingapp.Controller;

import com.joysistvi.recordingapp.Model.Song;
import com.joysistvi.recordingapp.Service.SongService;

import java.util.List;

// Call the Service
public class SongController {

    private final SongService songService;

    // Constructor injection
    public SongController(SongService songService) {
        this.songService = songService;
    }


    public boolean addSong(String title, String length, String genre, int albumId) {
        Song song = new Song(title, length, genre, albumId);
        return songService.addSong(song);
    }

    public List<Song> listSongs() {
        return songService.listSongs();
    }

    // public boolean updateSong(){}
    // public boolean deleteSong(){}
}
