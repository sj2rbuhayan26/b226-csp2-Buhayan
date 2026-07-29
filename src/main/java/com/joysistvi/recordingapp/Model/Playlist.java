package com.joysistvi.recordingapp.Model;

import java.sql.Date;

public class Playlist {

    private int id;
    private int userId;
    private Date dateCreated;


    public Playlist(int id, int userId, Date dateCreated) {
        this.id = id;
        this.userId = userId;
        this.dateCreated = dateCreated;
    }


    public int getId() {
        return id;
    }


    public int getUserId() {
        return userId;
    }


    public Date getDateCreated() {
        return dateCreated;
    }
}