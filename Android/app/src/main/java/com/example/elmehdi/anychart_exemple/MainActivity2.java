package com.example.elmehdi.anychart_exemple;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Cartesian;


import com.anychart.core.cartesian.series.RangeColumn;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.example.elmehdi.anychart_exemple.Entity.Pluies;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity2 extends AppCompatActivity {
 public String v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        this.v= extras.getString("prov");
        Log.d("mehdi","prov : "+v);

        Call<List<Pluies>> call= ApiClient.getAPIClient("B").create(ApiInterface2.class).getGrowthInfo();

        call.enqueue(new Callback<List<Pluies>>() {
            @Override
            public void onResponse(Call<List<Pluies>> call, Response<List<Pluies>> response) {
                if (response.body()!= null)
                {
                    String provincenomp="";
                    AnyChartView anyChartView = findViewById(R.id.any_chart_view);
                    anyChartView.setProgressBar(findViewById(R.id.progress_bar));
                    Cartesian cartesian = AnyChart.column();

                    List<DataEntry> data = new ArrayList<>();

                    float max=0;
                    for(Pluies pluies : response.body())
                    {
                        if(v.equals(String.valueOf(pluies.getProvinceid())))
                        {
                            data.add(new CustomDataEntry(pluies.getNomsb(), pluies.getP2019(), pluies.getP2018()));
                            provincenomp=pluies.getNomp();

                            if(max<pluies.getP2019()){max =pluies.getP2019()+1;}
                            if(max<pluies.getP2018()){max =pluies.getP2018()+1;}

                            Log.d("mehdi","getName : "+ pluies.getNomsb()+" , getP2019 : "+ pluies.getP2019());
                        }
                    }
                    cartesian.title("Situation pluviométrique \\dans la zone d’action du Province de "+provincenomp);

                    Set set = Set.instantiate();
                    set.data(data);
                    Mapping londonData = set.mapAs("{ x: 'x', high: 'londonHigh', low: 'londonLow' }");
                    Mapping edinburgData = set.mapAs("{ x: 'x', high: 'edinburgHigh', low: 'edinburgLow' }");

                    RangeColumn columnLondon = cartesian.rangeColumn(londonData);
                    columnLondon.name("Juin 2018");
                    columnLondon.tooltip().format("{%x} (2018): {%low} Mm3");
                    RangeColumn columnEdinburg = cartesian.rangeColumn(edinburgData);
                    columnEdinburg.name("Juin 2019");
                    columnEdinburg.tooltip().format("{%x} (2019): {%low} Mm3");

                    cartesian.xAxis(true);
                    cartesian.yAxis(true);

                    cartesian.yAxis(0).labels().rotation(45);
                    cartesian.xAxis(0).labels().rotation(80);
                    cartesian.yScale().minimum(0d) .maximum(max);
                    cartesian.legend(true);
                    cartesian.yGrid(true).yMinorGrid(true);

                    cartesian.tooltip().titleFormat("{%SeriesName} ({%x})");
                    anyChartView.setChart(cartesian);

                }else
                {Log.d("mehdi","Vide : ");}
            }

            @Override
            public void onFailure(Call<List<Pluies>> call, Throwable t) {
            }
        });
    }

    private class CustomDataEntry extends DataEntry {
        public CustomDataEntry(String x,  Number edinburgLow,Number londonLow) {
            setValue("x", x);
            setValue("edinburgHigh", 0);
            setValue("edinburgLow", edinburgLow);
            setValue("londonHigh", 0);
            setValue("londonLow", londonLow);
        }
    }
}
