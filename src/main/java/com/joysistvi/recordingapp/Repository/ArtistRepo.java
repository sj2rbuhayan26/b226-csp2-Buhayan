package com.joysistvi.recordingapp.Repository;

import com.joysistvi.recordingapp.Model.Artist;

import java.util.List;

public interface ArtistRepo {

    void addArtist(Artist artist);

    List<Artist> getAllArtist();

    Artist getArtistById(int id);

    void updateArtist(Artist artist);

    void deleteArtist(int id);

}

