package com.example.miral.projecte;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class idiomaLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_idioma_log);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        Button changeLang=findViewById(R.id.chngeMyLang);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });

    }

    private void showChangeLanguageDialog() {
        final String[] listItems={"Castellano","Catalan","Ingles"};
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(idiomaLog.this);
        mBuilder.setTitle("Elige Idioma.....");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    Toast.makeText(getApplicationContext(), "Traduciendo al castellano", Toast.LENGTH_SHORT).show();
                    setLocale("ca-rES");
                    recreate();
                }
                else if(i==1){
                    Toast.makeText(getApplicationContext(), "Traduciendo al catalan", Toast.LENGTH_SHORT).show();
                    setLocale("ca");
                    recreate();
                }
                else if(i==2){
                    Toast.makeText(getApplicationContext(), "Traduciendo al ingles", Toast.LENGTH_SHORT).show();
                    setLocale("en");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialog=mBuilder.create();
        mDialog.show();
    }

        private void setLocale(String s) {
            Locale locale=new Locale(s);
            Locale.setDefault(locale);
            Configuration config =new Configuration();
            config.locale=locale;
            getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
            SharedPreferences.Editor editor=getSharedPreferences("Settings", getBaseContext().MODE_PRIVATE).edit();
            editor.putString("My_Lang",s);
            editor.apply();

        }
        public void loadLocale(){
            SharedPreferences prefs =getSharedPreferences("Settings", Activity.MODE_PRIVATE);
            String language=prefs.getString("My_Lang","");
            setLocale(language);
        }

}
