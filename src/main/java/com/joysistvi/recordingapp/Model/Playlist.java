package com.joysistvi.recordingapp.Model;

import java.util.Date;

public class Playlist {
    private int Id;
    private String userId;
    private Date dateCreated;

    public Playlist(){}

    public Playlist(int Id, String userId, Date dateCreated){
        this.Id = Id;
        this.userId = userId;
        this.dateCreated = dateCreated;

    }

    public Playlist(int id) {
        Id = id;
    }

    public Playlist(String userId) {
        this.userId = userId;
    }

    public Playlist(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
