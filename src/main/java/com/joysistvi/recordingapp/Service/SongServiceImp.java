package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Song;
import com.joysistvi.recordingapp.Repository.SongRepo;

import java.util.List;

public class SongServiceImp implements SongService{

    private final SongRepo songRepo;

    public SongServiceImp(SongRepo songRepo) {
        this.songRepo = songRepo;
    }

    // CREATE
    @Override
    public boolean addSong(Song song) {
        return songRepo.createSong(song);
    }

    // READ
    @Override
    public List<Song> listSongs() {
        return songRepo.getAllSongs();
    }

    // UPDATE
    @Override
    public boolean updateSong(Song song) {
        return songRepo.updateSong(song);
    }

    // DELETE
    @Override
    public boolean deleteSong(int id) {
        return songRepo.deleteSong(id);
    }

    //ARCHIVE
    @Override
    public boolean archiveSong(int id){return songRepo.archiveSong(id);}

    //RESTORE SONG
    public boolean restoreSong(int id){return songRepo.restoreSong(id);}

    //READ ARCHIVED SONG
    @Override
    public List<Song> readArchivedSong(){
        return songRepo.readArchivedSong();
    }
    //SEARCH SONG
    @Override
    public List<Song> searchSong(String keyword) {return songRepo.searchSong(keyword);}

}