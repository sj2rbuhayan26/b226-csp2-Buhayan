package com.joysistvi.recordingapp.Model;

public class Artist {

    private int id;
    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(String name) {
        this.name = name;
    }

    public Artist() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}