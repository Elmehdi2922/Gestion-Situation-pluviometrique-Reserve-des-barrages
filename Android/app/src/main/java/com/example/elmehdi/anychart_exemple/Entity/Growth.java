package com.example.elmehdi.anychart_exemple.Entity;

import com.google.gson.annotations.SerializedName;

public class Growth {
    @SerializedName("nom")
    private String name;

    @SerializedName("vol")
    private float vol;

    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVol() {
        return vol;
    }

    public void setVol(float vol) {
        this.vol = vol;
    }
}
