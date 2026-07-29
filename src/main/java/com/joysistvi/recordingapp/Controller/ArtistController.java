package com.joysistvi.recordingapp.Controller;

import com.joysistvi.recordingapp.Model.Artist;
import com.joysistvi.recordingapp.Service.ArtistService;

import java.util.List;

public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    public void addArtist(Artist artist){
        artistService.addArtist(artist);
    }

    public List<Artist> getAllArtist(){
        return artistService.getAllArtist();
    }
    public Artist getArtistById(int id){
        return artistService.getArtistById(id);
    }
    public void updateArtist(Artist artist){
        artistService.updateArtist(artist);
    }
    public void deleteArtist(int id){
        artistService.deleteArtist(id);
    }

}
