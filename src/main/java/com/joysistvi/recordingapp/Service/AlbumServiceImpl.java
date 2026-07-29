package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Album;
import com.joysistvi.recordingapp.Repository.AlbumRepo;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepo albumRepo;

    public AlbumServiceImpl(AlbumRepo albumRepo){
        this.albumRepo = albumRepo;
    }

    @Override
    public void addAlbum(Album album){
        albumRepo.addAlbum(album);
    }

    @Override
    public List<Album> getAllAlbums(){
        return albumRepo.getAllAlbums();
    }

    @Override
    public void updateAlbum(Album album){
        albumRepo.updateAlbum(album);
    }

    @Override
    public void deleteAlbum(String id){
        albumRepo.deleteAlbum(id);
    }
}