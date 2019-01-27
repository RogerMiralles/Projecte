package com.example.miral.projecte;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button button = (Button) findViewById(R.id.btnLogin);
    }


    public void onClick(View view) {
        Intent listSong = new Intent(this,rvi_lista_ejers.class);
        startActivity(listSong);
    }
    public void onClickIdioma(View view){

    }

    public void setLocale(String lang){ 
        Locale locale = new Locale("values-ca-rES");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        Intent n = new Intent();

            }
}