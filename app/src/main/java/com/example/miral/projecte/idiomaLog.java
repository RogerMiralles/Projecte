package com.example.miral.projecte;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.miral.projecte.fragments.idioma;

import java.util.LinkedList;
import java.util.Locale;

public class idiomaLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_idioma_log);

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
            public void onClick(DialogInterface dialog, int i) {
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
                dialog.dismiss();
            }
        });
        AlertDialog mDialog=mBuilder.create();
        mDialog.show();
    }

/*
    public void onItemClick(View view,int position){
            switch(position){
                case 0:
                    Toast.makeText(getApplicationContext(), "Traduciendo al castellano", Toast.LENGTH_SHORT).show();
                    setLocale("ca-rES");
                    recreate();
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "Traduciendo al catalan", Toast.LENGTH_SHORT).show();
                    setLocale("ca");
                    recreate();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(), "Traduciendo al ingles", Toast.LENGTH_SHORT).show();
                    setLocale("en");
                    recreate();
                    break;
            }
        }*/

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


    /*private void CargarFragmente(Fragment fragment){
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.contendedorFragmentoI,fragment).commit();
    }*/
}
