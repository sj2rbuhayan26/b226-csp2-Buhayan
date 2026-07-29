package com.joysistvi.recordingapp.Controller;

import com.joysistvi.recordingapp.Model.Album;
import com.joysistvi.recordingapp.Service.AlbumService;

import java.util.List;

public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    public void addAlbum(Album album){
        albumService.addAlbum(album);
    }

    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    public void updateAlbum(Album album){
        albumService.updateAlbum(album);
    }

    public void deleteAlbum(String id){
        albumService.deleteAlbum(id);
    }
}