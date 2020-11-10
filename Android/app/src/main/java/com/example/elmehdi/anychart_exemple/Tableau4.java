package com.example.elmehdi.anychart_exemple;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class Tableau4 extends AppCompatActivity {
    private String TAG= MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    public String v="au";

    ArrayList<HashMap<String ,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau4);
        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView4);

        Bundle extras = getIntent().getExtras();
        this.v= extras.getString("type");
        Log.d("mehdi","Tableau idbaa: "+v);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long arg3) {
                passeposi((position+1),v);
                Log.d("mehdi","Tableau idbaa: "+(position+1));
            }


        });
        new GetContacts().execute();
    }
    public void passeposi(int x,String p)
    {
        Intent intent= new Intent(this,Tableau2.class);
        intent.putExtra("type","T");
        intent.putExtra("mois",""+x);
        startActivity(intent);
    }

    private class GetContacts extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //show loading dialog
            pDialog = new ProgressDialog(Tableau4.this);
            pDialog.setMessage("loading...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            HashMap<String, String> mois = new HashMap<>();
            mois = new HashMap<>();mois.put("mois","janvier" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","février" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","mars" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","avril" ); contactList.add(mois);
            mois = new HashMap<>(); mois.put("mois","mai" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","juin" ); contactList.add(mois);
            mois = new HashMap<>(); mois.put("mois","juillet" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","août" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","septembre" ); contactList.add(mois);
            mois = new HashMap<>(); mois.put("mois","octobre" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","novembre" ); contactList.add(mois);
            mois = new HashMap<>();mois.put("mois","décembre" ); contactList.add(mois);

            Log.e(TAG,"mois: "+"");
            //adding contact to mois list

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            //Dimmiss the dialog
            if(pDialog.isShowing())
            {
                pDialog.dismiss();
            }

            //updating json data to listview
            ListAdapter adapter = new SimpleAdapter(
                    Tableau4.this,contactList,
                    R.layout.list_item4,new String[]{"mois"},
                    new int[]{R.id.name}
            );
            lv.setAdapter(adapter);
        }
    }
}
