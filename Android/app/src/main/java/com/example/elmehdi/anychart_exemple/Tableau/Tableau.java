package com.example.elmehdi.anychart_exemple.Tableau;

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

import com.example.elmehdi.anychart_exemple.ApiInterface;
import com.example.elmehdi.anychart_exemple.Chart;
import com.example.elmehdi.anychart_exemple.HttpHandler;
import com.example.elmehdi.anychart_exemple.MainActivity;
import com.example.elmehdi.anychart_exemple.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class Tableau extends AppCompatActivity {
    private String TAG= MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;
    private static String url="";
    public String v="au";
    public String xv="a";
    public int man=-1;

    ArrayList<HashMap<String ,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau);
        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView);

        Bundle extras = getIntent().getExtras();
        this.v= extras.getString("periode");

        url= ApiInterface.GetAujour_info;
        Log.d("mehdi","Tableau idbaa: "+v);
        if(v.equals("a")){url=ApiInterface.GetAujour_info;xv="a";}
        if(v.equals("b")){url=ApiInterface.GetHier_info;xv="a";}
        if(v.equals("c")){url=ApiInterface.GetAnneePrec_info;xv="c";}

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long arg3) {passeposi(position+1,xv);Log.d("mehdi","Tableau idbaa: "+position);     }


        });
        new GetContacts().execute();
    }
    public void passeposi(int x,String p)
    {
        Intent intent= new Intent(this, Chart.class);
        intent.putExtra("method","x"+xv+String.valueOf(x));
        startActivity(intent);
    }

    private class GetContacts extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //show loading dialog
            pDialog = new ProgressDialog(Tableau.this);
            pDialog.setMessage("loading...");
            pDialog.setCancelable(false);
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            HttpHandler ah = new HttpHandler();
            String jsonStr = ah.makeServiceCall(url);
            Log.e(TAG,"Response from url: "+jsonStr);
            Boolean test =false;
            if(jsonStr != null)
            {
                try {
                    JSONArray jsonObject= new JSONArray(jsonStr);
                    //Getting json node
                    //looping through all
                    double var1=0,var2=0;
                    String var3="";
                    HashMap<String, String> contact = new HashMap<>();

                    for(int i=0;i<jsonObject.length();i++)
                    {
                        JSONObject c=jsonObject.getJSONObject(i);
                        test=true;
                        double voln=c.getDouble("vol"), vol=c.getDouble("volume");
                        String name=c.getString("nom");

                        Log.e(TAG,"voln: "+voln);Log.e(TAG,"vol: "+vol);

                        var1=var1+voln;var2=var2+vol;

                        String S=String.valueOf((vol/voln)*100), ss=S;

                        if(S.length()>5){ss=""+S.charAt(0);for (int j=1;j<5;j++){ss=ss+S.charAt(j);}}

                        String v1=String.valueOf(voln);
                        String v2=String.valueOf(vol);

                        contact = new HashMap<>();
                        //adding each child node to HashMap
                        contact.put("vol",""+String.valueOf(v2)+"/"+String.valueOf(v1));
                        contact.put("name",name );
                        contact.put("pourc",ss+" %");
                        Log.e(TAG,"name: "+name);
                        //adding contact to contact list
                        contactList.add(contact);
                    }
                    if(test)
                    {
                        contact = new HashMap<>();
                        var3=String.valueOf((var2/var1)*100);
                        var3=var3.substring(0,4);
                        contact.put("vol",""+String.valueOf(var2)+"/"+String.valueOf(var1).substring(0,5));
                        contact.put("name","Total" );
                        contact.put("pourc",var3+" %");
                        contactList.add(contact);
                    }
                }catch(final JSONException e)
                {
                    Log.e(TAG,"JSON parsing error: "+e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {Toast.makeText(Tableau.this,"JSON parsing error: "+e.getMessage(),Toast.LENGTH_SHORT).show();}
                    });
                }
            } else {
                Log.e(TAG,"Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() { Toast.makeText(Tableau.this,"Couldn't get json from server.",Toast.LENGTH_SHORT).show();}
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            //Dimmiss the dialog
            if(pDialog.isShowing()) {pDialog.dismiss(); }
            //updating json data to listview
            ListAdapter adapter = new SimpleAdapter(Tableau.this,contactList,R.layout.list_item,new String[]{"name","vol","pourc"},new int[]{R.id.name,R.id.email,R.id.mobile});
            lv.setAdapter(adapter);
        }
    }
}
