package com.example.elmehdi.anychart_exemple.Entity;

import com.google.gson.annotations.SerializedName;

public class Pl {

    @SerializedName("nomsb")
    private String name;

    @SerializedName("p2018")
    private float p2018;

    @SerializedName("p2019")
    private float p2019;

    public Pl(String name, float p2018, float p2019) {
        this.name = name;
        this.p2018 = p2018;
        this.p2019 = p2019;
    }

    public String getName() {
        return name;
    }

    public float getP2018() {
        return p2018;
    }

    public float getP2019() {
        return p2019;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setP2018(float p2018) {
        this.p2018 = p2018;
    }

    public void setP2019(float p2019) {
        this.p2019 = p2019;
    }
}
