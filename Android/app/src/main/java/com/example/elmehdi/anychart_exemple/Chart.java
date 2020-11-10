package com.example.elmehdi.anychart_exemple;

import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;


public class Chart extends AppCompatActivity implements ChartFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        ChartFragment chartFragment=new ChartFragment();
        Bundle bundle=new Bundle();
        bundle.putString("method",getIntent().getStringExtra("method"));
        chartFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,chartFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
