package com.example.elmehdi.anychart_exemple;

import com.example.elmehdi.anychart_exemple.Entity.Pluies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface2 {
    @GET("get_sbassin.info.php")
    Call<List<Pluies>> getGrowthInfo();
}
