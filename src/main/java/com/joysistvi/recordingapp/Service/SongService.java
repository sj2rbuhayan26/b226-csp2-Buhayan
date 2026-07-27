package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Song;
import com.joysistvi.recordingapp.Repository.SongRepo;

import java.util.List;

public class SongService {

    private final SongRepo songRepo;

    // Constructor injection
    public SongService(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    public boolean addSong(Song song) {
        if (song.getTitle() == null || song.getTitle().isEmpty() ) {
            System.out.println("Song title cannot be empty");
            return false;
        }

        return songRepo.createSong(song);
    }

    public List<Song> listSongs() {
        return songRepo.getAllSongs();
    }

//    public boolean updateSong(int id, String newTitle, String length, String genre) {
//        if (newTitle == null || newTitle.isEmpty()) {
//            System.out.println("New title cannot be empty.");
//            return false;
//        }
//        return songRepo.updateSongTitle(id, newTitle);
//    }

    public boolean deleteSong(){
        return true;
    }

}
