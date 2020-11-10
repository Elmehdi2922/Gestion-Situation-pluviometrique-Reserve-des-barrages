package com.example.elmehdi.anychart_exemple;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elmehdi.anychart_exemple.Entity.Barrages;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

public class bar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        getGrowthChart("b","a");
    }

    private void getGrowthChart(final String method,String periode)
    {
        retrofit2.Call<List<Barrages>> call= ApiClient.getAPIClient(periode).create(ApiInterface.class).getGrowthInfo();
        call.enqueue(new Callback<List<Barrages>>() {
            @Override
            public void onResponse(Call<List<Barrages>> call, Response<List<Barrages>> response) {
                if (response.body()!= null)
                {
                    AnyChartView anyChartView = findViewById(R.id.any_chart_view);
                    anyChartView.setProgressBar(findViewById(R.id.progress_bar));
                    Cartesian cartesian = AnyChart.column();
                    List<DataEntry> data = new ArrayList<>();

                    data.add(new ValueDataEntry("val 1", 8054));
                    Column column = cartesian.column(data);

                    column.tooltip()
                            .titleFormat("{%X}")
                            .position(Position.CENTER_BOTTOM)
                            .anchor(Anchor.CENTER_BOTTOM)
                            .offsetX(0d)
                            .offsetY(10d)
                            .format("{%Value}{groupsSeparator: }");

                    cartesian.animation(true);
                    cartesian.title("Gestion de suivits des Barrages d'Oum Rabiaa");

                    cartesian.yScale().minimum(0d);

                    cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

                    cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
                    cartesian.interactivity().hoverMode(HoverMode.BY_X);

                    anyChartView.setChart(cartesian);

                }
            }

            @Override
            public void onFailure(Call<List<Barrages>> call, Throwable t) {
            }
        });
    }
}
