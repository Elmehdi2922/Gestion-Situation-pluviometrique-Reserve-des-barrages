package com.example.elmehdi.anychart_exemple;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.elmehdi.anychart_exemple.Entity.Barrages;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
  //  private static String pariode="au";*/
    private OnFragmentInteractionListener mListener;

   // public int pe;

    private BarChart mBarChart;
    private PieChart mpPieChart;

    public ChartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChartFragment newInstance(String param1, String param2) {
        ChartFragment fragment = new ChartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        String c=Character.toString(getArguments().getString("method").charAt(1)) ;
        getGrowthChart(getArguments().getString("method"),c);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_chart, container, false);
        mBarChart = view.findViewById(R.id.barChart);
        mpPieChart = view.findViewById(R.id.pieChart);

        //Determiner la methode
        String c=Character.toString(getArguments().getString("method").charAt(1));
        if (Character.toString(getArguments().getString("method").charAt(0)).equals("x")){c="x";}

        Log.d("mehdi","ChartFragment c: "+c);
        getGrowthChart(getArguments().getString("method"),c);
        return view;
    }

    private void getGrowthChart(final String method,String periode)
    {
        Call<List<Barrages>> call= ApiClient.getAPIClient(periode).create(ApiInterface.class).getGrowthInfo();
        call.enqueue(new Callback<List<Barrages>>() {
            @Override
            public void onResponse(Call<List<Barrages>> call, Response<List<Barrages>> response) {
                if (response.body()!= null)
                {
                    String x=""+method.charAt(0);
                    String vx=""+method.charAt(1);
                    List<BarEntry> barEntries= new ArrayList<>();
                    List<PieEntry> pieEntries= new ArrayList<>();
                    ArrayList<String> lnom= new ArrayList<>();
                    if(x.equals("b"))
                    {
                        barEntries= new ArrayList<>();
                        lnom= new ArrayList<>();

                        for(Barrages barrages : response.body()){barEntries.add(new BarEntry(barrages.getId(),barrages.getVolume(),barrages.getName()));lnom.add(barrages.getName());}

                        BarDataSet barDataSet= new BarDataSet(barEntries,"Barrages");
                        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        BarData barData= new BarData(barDataSet);
                        barData.setBarWidth(0.9f);

                        mBarChart.setVisibility(View.VISIBLE);
                        mBarChart.animateY(5000);
                        mBarChart.setData(barData);
                        mBarChart.setFitBars(true);

                        Description description=new Description();
                        description.setText("Gestion de suivits des Barrages d'Oum Rabiaa");
                        mBarChart.setDescription(description);
                        mBarChart.invalidate();
                    }
                    else if(x.equals("p"))
                    {
                        pieEntries= new ArrayList<>();

                        for(Barrages barrages : response.body()) { pieEntries.add(new PieEntry(barrages.getVolume(),barrages.getName())); }

                        mpPieChart.setVisibility(View.VISIBLE);
                        mpPieChart.animateXY(5000,5000);

                        PieDataSet pieDataSet= new PieDataSet(pieEntries," Volume Normal");

                        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                        PieData pieData = new PieData(pieDataSet);
                        mpPieChart.setData(pieData);

                        Description description=new Description();
                        description.setText("Gestion de suivits des Barrages d'Oum Rabiaa");
                        mpPieChart.setDescription(description);
                        mpPieChart.invalidate();

                        }else if(x.equals("x"))
                        {
                            String idbar="";
                            String method=getArguments().getString("method");

                            //Choisir la date
                            String var="2019";
                            if(String.valueOf(method.charAt(1)).equals("c")){var="2018";}

                            for(int i=2;i<method.length();i++){idbar=idbar+method.charAt(i);}

                            Log.d("mehdi","ChartFragment idba: "+idbar);
                            Log.d("mehdi","ChartFragment var : "+var);

                            for(Barrages barrages : response.body())
                            {
                                Log.d("mehdi","ChartFragment Month barrage : "+barrages.getYear()+" ## ChartFragment Year barrage : "+var);
                                if(String.valueOf(barrages.getYear()).equals(var) && String.valueOf(barrages.getId()).equals(idbar)) {
                                    barEntries.add(new BarEntry(barrages.getMonth(), barrages.getVol()));
                                }
                            }

                            BarDataSet barDataSet= new BarDataSet(barEntries,"Mois");
                            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                            BarData barData= new BarData(barDataSet);
                            barData.setBarWidth(0.9f);

                            mBarChart.setVisibility(View.VISIBLE);
                            mBarChart.animateY(5000);
                            mBarChart.setData(barData);
                            mBarChart.setFitBars(true);

                            Description description=new Description();
                            description.setText("Gestion de suivits des Barrages d'Oum Rabiaa Par mois");
                            mBarChart.setDescription(description);
                            mBarChart.invalidate();
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Barrages>> call, Throwable t) { }
            });
        }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void setInteractionListener(OnFragmentInteractionListener mListener){
        this.mListener = mListener;
    }
}
