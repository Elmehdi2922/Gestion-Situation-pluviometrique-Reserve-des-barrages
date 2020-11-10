package com.example.elmehdi.anychart_exemple.Entity;

import com.google.gson.annotations.SerializedName;

public class Barrages {
    @SerializedName("id")
    private int id;

    @SerializedName("nom")
    private String name;

    @SerializedName("vol")
    private float vol;

    @SerializedName("month")
    private int month;

    @SerializedName("year")
    private int year;

    @SerializedName("volume")
    private float volume;

    public String getName() {
        return name;
    }

    public float getVol() {
        return vol;
    }

    public float getVolume() {
        return volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVol(float vol) {
        this.vol = vol;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
