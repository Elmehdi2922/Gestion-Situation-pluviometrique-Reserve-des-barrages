package com.example.elmehdi.anychart_exemple;

import com.example.elmehdi.anychart_exemple.Entity.Barrages;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("get_aujour_info.php")
    Call<List<Barrages>> getGrowthInfo();

    String GetAujourBar_info4=Localhost_Url.url+"get_aujour-bar.info4.php/";

    String GetHier_info=Localhost_Url.url+"get_hier.info.php/";;

    String GetAnneePrec_info=Localhost_Url.url+"get_ann-prec.info.php/";

    String GetAujour_info=Localhost_Url.url+"get_aujour.info.php/";

    String GetAujourBar_info=Localhost_Url.url+"get_aujour-bar.info.php/";

    String Get_sbassin_info=Localhost_Url.url+"get_sbassin.info.php/";

    String Get_sbassin_info2=Localhost_Url.url+"get_sbassin.info2.php/";

    String Get_sbassin_info3=Localhost_Url.url+"/get_sbassin.info.php?";
}
