package com.example.elmehdi.anychart_exemple;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;

import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;

import java.util.ArrayList;
import java.util.List;


import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.LabelsOverlapMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.elmehdi.anychart_exemple.Entity.Barrages;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
 public String v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        this.v= extras.getString("periode");
        Log.d("mehdi","periode : ");

        retrofit2.Call<List<Barrages>> call= ApiClient.getAPIClient(v).create(ApiInterface.class).getGrowthInfo();

        call.enqueue(new Callback<List<Barrages>>() {

            @Override
            public void onResponse(Call<List<Barrages>> call, Response<List<Barrages>> response) {
                if (response.body()!= null)
                {
                    AnyChartView anyChartView = findViewById(R.id.any_chart_view);
                    anyChartView.setProgressBar(findViewById(R.id.progress_bar));
                    Cartesian cartesian = AnyChart.column();

                    List<DataEntry> data = new ArrayList<>();

                    for(Barrages barrages : response.body())
                    {
                       data.add(new ValueDataEntry(barrages.getName(), barrages.getVolume()));
                        Log.d("mehdi","getName : "+ barrages.getName()+" , getVolume : "+ barrages.getVolume());
                    }



                    Column column = cartesian.column(data);


                    column.labels()
                            .enabled(true)
                            .fontColor("#000000")
                            .position("top")
                            .rotation(90)
                            .format("{%Value}{groupsSeparator: }");

                    column.tooltip()
                            .titleFormat("{%X}")
                            .position(Position.CENTER_BOTTOM)
                            .anchor(Anchor.CENTER_BOTTOM)
                            .offsetX(0d)
                            .offsetY(10d)
                            .lineHeight("mehdi")
                            .format("Réserve Totale : {%Value}{groupsSeparator: } Mm3")

                            .separator("");
                    cartesian.animation(true);
                    cartesian.title("Barrages d Oum Rabiaa");
                    cartesian.yAxis(0).labels().rotation(45);
                    cartesian.yAxis(0).enabled(false);

                    cartesian.xAxis(0).labels().rotation(80);
                    cartesian.xAxis(0).overlapMode(LabelsOverlapMode.NO_OVERLAP);

                    cartesian.yScale().minimum(0d);

                    cartesian.xZoom(true);
                    cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

                    cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
                    cartesian.interactivity().hoverMode(HoverMode.BY_X);



                    anyChartView.setChart(cartesian);



                    anyChartView.setChart(cartesian);



                }
            }

            @Override
            public void onFailure(Call<List<Barrages>> call, Throwable t) {

            }
        });

    }
}
