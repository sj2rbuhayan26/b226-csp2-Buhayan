package com.joysistvi.recordingapp.Model;

public class Album {

    private String id;
    private String name;
    private int year;
    private String artistsId;

    public Album() {}

    public Album(String id, String name, int year, String artistsId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.artistsId = artistsId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;      // Fixed
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArtistsId() {
        return artistsId;
    }

    public void setArtistsId(String artistsId) {
        this.artistsId = artistsId;
    }
}