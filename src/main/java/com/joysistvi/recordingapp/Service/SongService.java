package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Song;

import java.util.List;

public interface SongService {

    boolean addSong(Song song);

    List<Song> listSongs();

    boolean updateSong(Song song);

    boolean deleteSong(int id);

    boolean archiveSong(int id);

    boolean restoreSong(int id);

    List<Song> readArchivedSong();

    List<Song> searchSong(String keyword);


}