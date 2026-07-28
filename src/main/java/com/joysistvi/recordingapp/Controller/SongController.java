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
    // ADD SONG
    public boolean addSong(String title, String length, String genre, int albumId) {
        Song song = new Song(title, length, genre, albumId);
        return songService.addSong(song);
    }
    public void listSongs(){
        List<Song> songs = songService.listSongs();
        if (songs.isEmpty()){
            System.out.println("No songs found");
            return;
        }
        System.out.println(" SONG LIST ");
        for (Song song : songs){
            System.out.println("ID : " + song.getId());
            System.out.println("TITLE : " + song.getTitle());
            System.out.println("LENGTH : " + song.getLength());
            System.out.println("GENRE : " + song.getGenre());
            System.out.println("ALBUMS ID  : " + song.getAlbumId());
            System.out.println("---------------------------------");
        }


    }
    // UPDATE
    public boolean updateSong(int id, String title, String length, String genre) {

        Song song = new Song();
        song.setId(id);
        song.setTitle(title);
        song.setLength(length);
        song.setGenre(genre);

        return songService.updateSong(song);
    }
    // DELETE
    public boolean deleteSong(int id) {
        return songService.deleteSong(id);
    }
    // ARCHIVED
    public boolean archivedSong(int id){
        return songService.archiveSong(id);
    }
    // RESTORE SONG
    public boolean restoreSong(int id){return songService.restoreSong(id);}
    // READ ARCHIVED SONG
    public void listArchivedSongs() {

        List<Song> songs = songService.readArchivedSong();

        if (songs.isEmpty()) {
            System.out.println("No archived songs found.");
            return;
        }

        System.out.println("\n===== ARCHIVED SONGS =====");

        for (Song song : songs) {
            System.out.println("ID      : " + song.getId());
            System.out.println("Title   : " + song.getTitle());
            System.out.println("Length  : " + song.getLength());
            System.out.println("Genre   : " + song.getGenre());
            System.out.println("Album   : " + song.getAlbumName());
            System.out.println("----------------------------");
        }
    }
    // SEARCH SONG
    public void searchSong(String keyword){
        List<Song> songs = songService.searchSong(keyword);
        if (songs.isEmpty()){
            System.out.println("No matching song found");
            return;
        }
        System.out.println("\nSearch Result ");

        for (Song song : songs){
            System.out.println("ID : " + song.getId());
            System.out.println("TITLE : " + song.getTitle());
            System.out.println("LENGTH : " + song.getLength());
            System.out.println("GENRE : " + song.getGenre());
            System.out.println("ALBUM : " + song.getAlbumId());
            System.out.println("---------------------------------");

        }
    }
}

