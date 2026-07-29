package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Artist;
import com.joysistvi.recordingapp.Repository.ArtistRepo;

import java.util.List;

public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepo artistRepo;

    public ArtistServiceImpl(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }

    @Override
    public void addArtist(Artist artist) {
        artistRepo.addArtist(artist);
    }

    @Override
    public List<Artist> getAllArtist() {
        return artistRepo.getAllArtist();
    }

    @Override
    public Artist getArtistById(int id) {
        return artistRepo.getArtistById(id);
    }

    @Override
    public void updateArtist(Artist artist) {
        artistRepo.updateArtist(artist);
    }

    @Override
    public void deleteArtist(int id) {
        artistRepo.deleteArtist(id);
    }
}