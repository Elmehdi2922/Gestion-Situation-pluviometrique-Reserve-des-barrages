package com.example.elmehdi.anychart_exemple.Entity;

import com.google.gson.annotations.SerializedName;

public class Pluies {
    @SerializedName("provinceid")
    private int provinceid;

    @SerializedName("nomp")
    private String nomp;

    @SerializedName("sbid")
    private int sbid;

    @SerializedName("nomsb")
    private String nomsb;

    @SerializedName("p2018")
    private float p2018;

    @SerializedName("p2019")
    private float p2019;

    public int getProvinceid() {
        return provinceid;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public int getSbid() {
        return sbid;
    }

    public String getNomsb() {
        return nomsb;
    }

    public float getP2018() {
        return p2018;
    }

    public float getP2019() {
        return p2019;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public void setSbid(int sbid) {
        this.sbid = sbid;
    }

    public void setNomsb(String nomsb) {
        this.nomsb = nomsb;
    }

    public void setP2018(float p2018) {
        this.p2018 = p2018;
    }

    public void setP2019(float p2019) {
        this.p2019 = p2019;
    }
}
