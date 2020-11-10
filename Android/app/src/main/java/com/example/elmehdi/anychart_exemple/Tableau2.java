package com.example.elmehdi.anychart_exemple;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
/*import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;*/
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class Tableau2 extends AppCompatActivity {
    private String TAG= MainActivity.class.getSimpleName();

    private CalendarView mCalenderView;
    private ProgressDialog pDialog;
    private ListView lv;
    //URL of the JSON
    private static String url=Localhost_Url.url+"get_province.info";
    public String v1="", v2="", v3="", v4="", xv="a";

    ArrayList<HashMap<String ,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau2);
        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView2);
        mCalenderView = (CalendarView) findViewById(R.id.calendarView1);

        Bundle extras = getIntent().getExtras();
        this.v1= extras.getString("type");
        url=Localhost_Url.url+"get_province.info.php";
        Log.d("mehdi","Tableau idbaa: "+v1);

        mCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                v2=""+(month+1); v3=""+dayOfMonth; v4=""+year;
                Log.d("mehdi","Tableau month: "+v2);
            }

        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long arg3) {
                passeposi((position+1),xv);
                Log.d("mehdi","Tableau idbaa: "+(position+1));
            }


        });
        new GetContacts().execute();
    }
    public void passeposi(int x,String p)
    {
        Intent intent= new Intent(this,MainActivity2.class);
        if(v1.equals("T")) {
            intent = new Intent(this, Tableau3.class);
        }
        intent.putExtra("prov",String.valueOf(x));
        intent.putExtra("mois",v2);
        intent.putExtra("jour",v3);
        intent.putExtra("annee",v4);

        startActivity(intent);
    }

    private class GetContacts extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //show loading dialog
            pDialog = new ProgressDialog(Tableau2.this);
            pDialog.setMessage("loading...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            HttpHandler ah = new HttpHandler();

            String jsonStr = ah.makeServiceCall(url);

            Log.e(TAG,"Response from url: "+jsonStr);

            if(jsonStr != null)
            {
                try {
                    JSONArray jsonObject= new JSONArray(jsonStr);

                    for(int i=0;i<jsonObject.length();i++)
                    {
                        JSONObject c=jsonObject.getJSONObject(i);

                        int nbrbassin=c.getInt("nbrbassin");
                        String nomp=c.getString("nomp");

                        HashMap<String, String> contact = new HashMap<>();

                        //adding each child node to HashMap

                        contact.put("nomp",nomp );
                        contact.put("nbrbassin",String.valueOf(nbrbassin));
                        Log.e(TAG,"nomp: "+nomp);
                        //adding contact to contact list
                        contactList.add(contact);

                    }
                }catch(final JSONException e)
                {
                    Log.e(TAG,"JSON parsing error: "+e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Tableau2.this,
                                    "JSON parsing error: "+e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } else {
                Log.e(TAG,"Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Tableau2.this,
                                "Couldn't get json from server.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

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
                    Tableau2.this,contactList,
                    R.layout.list_item2,new String[]{"nomp", "nbrbassin"},
                    new int[]{R.id.name,R.id.nbrbassin }
            );
            lv.setAdapter(adapter);
        }
    }
}
