package com.joysistvi.recordingapp.Model;

public class Artists {
    
    private int Id;
    private String name;

    public Artists(){}

    public Artists(int Id, String name){
        this.Id = Id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
