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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.elmehdi.anychart_exemple.Tableau.Tableau;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {
    private String TAG= MainActivity.class.getSimpleName();
    ImageView bgapp;
    public static String xxx="";
    LinearLayout textsplash, texthome, menus;
    RadioButton radioButton1,radioButton2,radioButton3;
    RadioGroup radioGroup;
    Animation frombottom;
    TextView tv1;
    TextView tv2;
    Button button3;
    ImageView imageView2;
    private ProgressDialog pDialog;
    private ListView lv;
    ArrayList<HashMap<String ,String>> contactList;
    String filen;
    String textn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioAu);
        radioButton2 = (RadioButton) findViewById(R.id.radioHie);
        radioButton3 = (RadioButton) findViewById(R.id.radioAn);
        tv1 = (TextView) findViewById(R.id.textView10);
        tv2 = (TextView) findViewById(R.id.textView11);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        menus = (LinearLayout) findViewById(R.id.menus);
        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        radioButton1.setChecked(true);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        radioGroup.startAnimation(frombottom);
        radioButton1.startAnimation(frombottom);
        radioButton2.startAnimation(frombottom);
        radioButton3.startAnimation(frombottom);
        imageView2.startAnimation(frombottom);
        tv1.startAnimation(frombottom);
        tv2.startAnimation(frombottom);

        menus.startAnimation(frombottom);

        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Situationpluviometrique();
            }
        });
        new GetContacts2().execute();
    }
    public void seter( double volMax,double tauxRemplissage)
    {
        tv1.setText("Taux de remplissage : "+String.valueOf(tauxRemplissage).substring(0,7)+"M m³");
        tv2.setText(String.valueOf((tauxRemplissage/volMax)*100).substring(0,5)+" %");
    }
    private class GetContacts2 extends AsyncTask<Void,Void,Void>
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
            String jsonStr = ah.makeServiceCall(ApiInterface.GetAujourBar_info4);
            Log.e(TAG,"Response from url: "+jsonStr);
            if(jsonStr != null)
            {
                try {
                    JSONArray jsonObject= new JSONArray(jsonStr);
                    double volume=0;
                    double remplissage=0;
                    for(int i=0;i<jsonObject.length();i++)
                    {
                        JSONObject c=jsonObject.getJSONObject(i);
                        volume= c.getDouble("volume") ;
                        remplissage= c.getDouble("vol") ;

                        Log.e(TAG,"volume: "+volume);Log.e(TAG,"remplissage: "+remplissage);

                        seter(volume,remplissage);
                    }

                }catch(final JSONException e)
                {
                    Log.e(TAG,"JSON parsing error: "+e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() { Toast.makeText(Home.this,"JSON parsing error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } else {
                Log.e(TAG,"Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() { Toast.makeText(Home.this,"Couldn't get json from server.",Toast.LENGTH_SHORT).show();
                    }
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

    public void OpenBar(View view) {

        Intent intent= new Intent(this,MainActivity.class);
        intent.putExtra("periode",periode());
        startActivity(intent);
    }
    public void OpenPie(View view) {
        Intent intent= new Intent(this,Chart.class);
        intent.putExtra("method","p"+periode());

        startActivity(intent);
    }
    public void OpenTableau(View view) {
        Intent intent= new Intent(this, Tableau.class);
        intent.putExtra("periode",periode());
        startActivity(intent);
    }

    public String periode() {
        String s="c";
        if(radioButton1.isChecked()==true){s="a";}
        if(radioButton2.isChecked()==true){s="b";}
        if(radioButton3.isChecked()==true){s="c";}
        return s;
    }

    private boolean isExternalStorageWritable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            Log.i("State","Yes, it is writable!");
            return true;
        }else{
            return false;
        }
    }

    public void Situationpluviometrique(){
        Intent intent= new Intent(this,Home2.class);
        startActivity(intent);
    }

    public void writeFile(View v){

        if(radioButton2.isChecked()==true){xxx=ApiInterface.GetHier_info;}
        if(radioButton3.isChecked()==true){xxx=ApiInterface.GetAnneePrec_info;}
        if(radioButton1.isChecked()==true){xxx=ApiInterface.GetAujour_info;}

        new Home.GetContacts().execute();
    }

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
            pDialog = new ProgressDialog(Home.this);
            pDialog.setMessage("loading...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids)
        {double totalvol=0;
            String url=Home.xxx;

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

                        double remplissage=c.getDouble("vol");
                        double volume=c.getDouble("volume");
                        String nomBarrage=c.getString("nom");

                        totalvol=totalvol+remplissage;

                        pero=c.getString("ddate");

                        String moyenneRemplissage=String.valueOf((remplissage/volume)*100);
                        String ss=moyenneRemplissage;
                        if(moyenneRemplissage.length()>5)
                        {   ss=""+moyenneRemplissage.charAt(0);
                            for (int j=1;j<5;j++)
                            {ss=ss+moyenneRemplissage.charAt(j);}
                        }
                        String v1=String.valueOf(remplissage);
                        String v2=String.valueOf(volume);
                        xxx =xxx+nomBarrage+";"+remplissage+";"+volume+";"+ss+"% \n";

                    }
                    File textFile = new File(Environment.getExternalStorageDirectory(), "/Download/situation-barrages-"+pero+".csv");
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
                        Toast.makeText(Home.this,
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
