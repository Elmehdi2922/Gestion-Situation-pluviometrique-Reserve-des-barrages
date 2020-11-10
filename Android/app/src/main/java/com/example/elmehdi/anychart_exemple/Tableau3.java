package com.example.elmehdi.anychart_exemple;

import android.app.ProgressDialog;
import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Tableau3 extends AppCompatActivity {
    private String xx,v2,v3,v4;
    private TextView t1,t2,t3,t4,t5,t6;

    private String TAG= MainActivity.class.getSimpleName();

    //URL of the JSON
    private static String url="";


    ArrayList<HashMap<String ,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau3);

        contactList = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        this.xx= extras.getString("prov");
        this.v2= extras.getString("mois");
        this.v3= extras.getString("jour");
        this.v4= extras.getString("annee");

        //Valeur de Test
        url=ApiInterface.Get_sbassin_info3+"mois=6&annee=2019&jour=1";
        //url=ApiInterface.Get_sbassin_info3+"mois="+v2+"&annee="+v4+"&jour="+v3;

        String monthString="";
        switch (v2) {
            case "1":  monthString = "janvier";break;
            case "2":  monthString = "février";break;
            case "3":  monthString = "mars"; break;
            case "4":  monthString = "avril";break;
            case "5":  monthString = "mai";break;
            case "6":  monthString = "juin";break;
            case "7":  monthString = "juillet"; break;
            case "8":  monthString = "août";break;
            case "9":  monthString = "septembre";break;
            case "10": monthString = "octobre";break;
            case "11": monthString = "novembre";break;
            case "12": monthString = "décembre";break;
            default  : monthString = "Invalid month";break;
        }

        t1=(TextView) findViewById(R.id.post);
        t2=(TextView) findViewById(R.id.p2018);
        t3=(TextView) findViewById(R.id.p2019);
        t4=(TextView) findViewById(R.id.moyenne);
        t5=(TextView) findViewById(R.id.id2018);
        t6=(TextView) findViewById(R.id.id2019);
        t5.setText(monthString+" "+ this.v4);

        if(this.v4==null){this.v4="1";t6.setText(monthString+" "+ (Integer.valueOf(this.v4)-1));}

        new GetContacts().execute();
    }


    private class GetContacts extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //show loading dialog
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
                    //Getting json node
                    //looping through all
                    String s="\n", s2="\n",s3="\n",s4="\n ", x;
                    double x2018=0,x2019=0;
                    double GOBOLET1=0,GOBOLET2=0;

                    Log.e(TAG,"xx: "+xx);
                    for(int i=0;i<jsonObject.length();i++)
                    {
                        JSONObject c=jsonObject.getJSONObject(i);

                        if(c.getString("provinceid").equals(xx))
                        {
                            s=s+c.getString("nomsb")+"\n\n";
                            if(c.getString("p2018").equals(null)){GOBOLET1=0;}else{GOBOLET1=c.getDouble("p2018");}
                            if(c.getString("p2019").equals(null)){GOBOLET2=0;}else{GOBOLET2=c.getDouble("p2019");}

                            s2=s2+GOBOLET1+"\n\n";s3=s3+GOBOLET2+"\n\n";
                            x2018=GOBOLET1;x2019=GOBOLET2;

                            String xxx=""+(x2019-x2018);
                            if(xxx.length()>5){xxx=xxx.substring(0,4);}
                            x=xxx;
                            Log.e(TAG,"x: "+x);Log.e(TAG,"x2019: "+x2019);Log.e(TAG,"x2018: "+x2018);

                            if((x2019-x2018)>0){ x=x+"▲";}else if ((x2019-x2018)<0){ x=x+"▼";}else{x=x+" ";}

                            Log.e(TAG,"x: "+x);
                            s4=s4+x+"\n\n";
                        }
                    }
                    rempli(s,s2,s3,s4);
                }catch(final JSONException e)
                {
                    Log.e(TAG,"JSON parsing error: "+e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {Toast.makeText(Tableau3.this, "JSON parsing error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } else {
                Log.e(TAG,"Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() { Toast.makeText(Tableau3.this,"Couldn't get json from server.", Toast.LENGTH_SHORT).show();     }
                });
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
        }
    }
    public void rempli(String s,String s2,String s3,String s4)
    {
        t1.setText(s);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
    }
}
