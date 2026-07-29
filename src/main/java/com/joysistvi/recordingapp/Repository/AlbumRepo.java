package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.Album;
import java.util.List;

public interface AlbumRepo {

    void addAlbum(Album album);

    List<Album> getAllAlbums();

    void updateAlbum(Album album);

    void deleteAlbum(String id);
}