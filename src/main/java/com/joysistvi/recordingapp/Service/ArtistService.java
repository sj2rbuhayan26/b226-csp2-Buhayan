package com.joysistvi.recordingapp.Service;

import com.joysistvi.recordingapp.Model.Artist;

import java.util.List;

public interface ArtistService {

    void addArtist(Artist artist);

    List<Artist> getAllArtist();

    Artist getArtistById(int id);

    void updateArtist(Artist artist);

    void deleteArtist(int id);
}
