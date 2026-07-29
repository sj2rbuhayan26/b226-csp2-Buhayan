package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Album;
import java.util.List;

public interface AlbumService {

    void addAlbum(Album album);

    List<Album> getAllAlbums();

    void updateAlbum(Album album);

    void deleteAlbum(String id);
}