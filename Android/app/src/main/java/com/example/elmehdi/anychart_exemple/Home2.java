package com.example.elmehdi.anychart_exemple;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
/*import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;*/
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Home2 extends AppCompatActivity {
    private String TAG= MainActivity.class.getSimpleName();
    ImageView bgapp;

    public static String xxx="";
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;
    Button button3;
    private ProgressDialog pDialog;

    String textn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);

        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);
        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Situationpluviometrique();
            }
        });
    }
    public void OpenBar(View view) {
        Intent intent= new Intent(this,Tableau2.class);
        intent.putExtra("type","B");
        startActivity(intent);
    }

    public void OpenTableau(View view) {
        Intent intent= new Intent(this,Tableau2.class);
        intent.putExtra("type","T");
        startActivity(intent);
    }

    private boolean isExternalStorageWritable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){Log.i("State","Yes, it is writable!");return true;}else{return false;}
    }

    public void Situationpluviometrique(){
        Intent intent= new Intent(this,Home.class);
        startActivity(intent);
    }

    public void writeFile(View v){ xxx=ApiInterface.GetAujour_info;new Home2.GetContacts().execute(); }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    private class GetContacts extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //show loading dialog
            pDialog = new ProgressDialog(Home2.this);
            pDialog.setMessage("loading...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            String url= Home2.xxx;
            HttpHandler ah = new HttpHandler();

            xxx = "  \n\nAgence du Bassin Hydraulique de l'Oum Er Rbia\n Ensemble pour la protection de l'eau   \n\n\n\n\n";
            xxx =xxx+ "\n Nom;Volume Normal; Volume; Pourcentage\n";

            String pero="" ;
            String jsonStr = ah.makeServiceCall(url);
            Log.e(TAG,"Response from url: "+jsonStr);
            if(jsonStr != null)
            {
                try {
                    JSONArray jsonObject= new JSONArray(jsonStr);
                    for(int i=0;i<jsonObject.length();i++)
                    {
                        JSONObject c=jsonObject.getJSONObject(i);

                        double voln=c.getDouble("vol"), vol=c.getDouble("volume");
                        String name=c.getString("nom");

                        pero=c.getString("ddate");
                        String S=String.valueOf((vol/voln)*100);
                        String ss=S;
                        if(S.length()>5){ss=""+S.charAt(0);for (int j=1;j<5;j++){ ss=ss+S.charAt(j);}}
                        String v1=String.valueOf(voln);
                        String v2=String.valueOf(vol);

                        xxx =xxx+name+";"+voln+";"+vol+";"+ss+"% \n";
                    }
                    File textFile = new File(Environment.getExternalStorageDirectory(), "/Download/situation-pluie-"+pero+".csv");
                    xxx =xxx+" \n \n Pour :"+pero;
                    try{
                        FileOutputStream fos = new FileOutputStream(textFile);
                        fos.write(xxx.getBytes());
                        fos.close();


                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }catch(final JSONException e)
                {
                    textn =textn+"KHAlki;Elmehdi;fggf;11% \n";
                }
            } else {
                Log.e(TAG,"Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Home2.this,
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
        }
    }
}
