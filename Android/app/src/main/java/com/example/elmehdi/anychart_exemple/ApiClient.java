package com.example.elmehdi.anychart_exemple;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String BASE_URL=ApiInterface.GetAujour_info;
    private static Retrofit retrofit;

    public static Retrofit getAPIClient(String ss)
    {
        Log.d("mehdi","ApiClient ss: "+ss);
        String v=ss;

        if(v.equals("b")){BASE_URL=ApiInterface.GetHier_info;}
        if(v.equals("c")){BASE_URL=ApiInterface.GetAnneePrec_info;}
        if(v.equals("a")){BASE_URL=ApiInterface.GetAujour_info;}
        if(v.equals("x")){BASE_URL=ApiInterface.GetAujourBar_info;}
        if(v.equals("T")){BASE_URL=ApiInterface.Get_sbassin_info;}
        if(v.equals("B")){BASE_URL=ApiInterface.Get_sbassin_info2;}

        retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return  retrofit;
    }
}
